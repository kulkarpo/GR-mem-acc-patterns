FROM node:12-alpine

RUN apk add --update python \
    python-dev \
    py-pip \
    build-base

ADD ./ /myapp

WORKDIR /myapp
RUN ls
RUN npm install

CMD ["node", "buffer-06.js"]
