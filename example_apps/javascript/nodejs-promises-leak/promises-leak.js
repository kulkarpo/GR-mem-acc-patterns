'use strict';
const http = require('http');

const server = http.createServer(handleServer);

async function handleServer(request, response) {
  if (request.url === '/') {
    await unSolvablePromise();
    response.end('Done');
  }
}

server.listen(3030);

function unSolvablePromise() {
  return new Promise(async (resolve, reject) => { })
}
