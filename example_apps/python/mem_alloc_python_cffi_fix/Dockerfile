FROM vergissberlin/alpine-development:latest

RUN apk add --update \
    python3 \
    python-dev \
    py-pip \
    build-base \
  && pip install virtualenv \
  && rm -rf /var/cache/apk/*

RUN apk add --update cmake
RUN apk add --update libffi-dev

ADD ./ /myapp/
WORKDIR /myapp

RUN mkdir build
WORKDIR /myapp/build 
RUN cmake ..
RUN make

WORKDIR /myapp

RUN pip install -r requirements.txt
CMD EXAMPLE_BUILD_DIR=build python -u /myapp/test.py
