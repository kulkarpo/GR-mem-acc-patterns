FROM node:12-alpine

RUN apk add --update python \
    python-dev \
    py-pip \
    build-base

ADD ./ /myapp

WORKDIR /myapp

CMD ["node", "2-closure.js"]
