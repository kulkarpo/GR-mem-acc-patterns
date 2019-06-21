const http = require('http');
const server = http.createServer(handleServer);
const path = require('path');
const fs = require('fs');

server.listen(9999);

function handleServer(request, response) {
  if (request.url === '/') {
    const readable = fs.createReadStream(path.join(__dirname, './big.file'));
    readable.pipe(response);
  }
}

process.on('uncaughtException', console.error);
