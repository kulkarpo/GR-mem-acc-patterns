'use strict';
const http = require('http');

const server = http.createServer(handleServer);

async function handleServer(request, response) {
  if (request.url === '/') {
    await Promise.race([unSolvablePromise, timeout(500)]);
    response.end('Done');
  }
}

server.listen(3030);

function unSolvablePromise() {
  return new Promise((resolve, reject) => { })
}

function timeout(timer) {
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve();
    }, timer)
  });
}
