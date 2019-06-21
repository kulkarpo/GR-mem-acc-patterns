const http = require('http');

const requestLogs = [];
const server = http.createServer((req, res) => {
    requestLogs.push({ url: req.url, date: new Date() });
    res.end(JSON.stringify(requestLogs));
});

server.listen(9999);
console.log('Server listening to port 9999. Press Ctrl+C to stop it.');
