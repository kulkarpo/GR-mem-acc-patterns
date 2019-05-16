var heapdump = require('heapdump');

var dummy = 0;
function leakFunc(){
    var leakVar = dummy;

    var closure = function(){
        console.log(leakVar);
    };
    dummy = {
        str        : new Array(1000000).join('a'),
        holdLeakVar: function(){}
    };
    // leakVar = null;
}
setInterval(leakFunc, 300);

process.on('SIGHUP', function(){
    global.gc && global.gc();
    console.log(process.memoryUsage());
});