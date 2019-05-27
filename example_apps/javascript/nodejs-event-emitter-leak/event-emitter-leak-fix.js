'use strict';

const http = require('http');
const connector = require('./lib/connector');
const server = http.createServer(handleServer);
server.listen(3030);

function handleServer(request, response) {
  if (request.url === '/') {
    console.log(connector.listeners('connected').length);

    connector.once('connected', async (db) => {
      response.end(await db.get());
    });
  }
}
