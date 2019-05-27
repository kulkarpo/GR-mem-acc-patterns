FROM node:12-alpine

RUN apk add --update python \
    python-dev \
    py-pip \
    build-base

ADD ./ /myapp

WORKDIR /myapp
RUN ls
RUN npm install

EXPOSE 3030

CMD ["node", "memleak-heapsnapshot.js"]
