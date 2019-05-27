const http = require('http');
const server = http.createServer(handleServer);
const pipeline = require('pump');
const fs = require('fs');
const path = require('path');

server.listen(3030);

function handleServer(request, response) {
  if (request.url === '/') {
    const readable = fs.createReadStream(path.join(__dirname, './big.file'));

    pipeline(
      readable,
      response,
      (err) => {
        if (err) console.error(err);
        response.end(err.message);
      }
    )
  }
}

process.on('uncaughtException', console.error);
