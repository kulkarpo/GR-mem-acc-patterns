'use strict';

const { EventEmitter } = require('events');

const connector = new EventEmitter();
connector.setMaxListeners(0); // Not advisable to do this one

setInterval(() => {
  connector.emit('connected', {
    async get() {
      return 'One'
    }
  });
}, 1000);

module.exports = connector;
