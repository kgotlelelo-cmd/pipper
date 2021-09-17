FROM node:14

RUN mkdir -p posts/app

WORKDIR /posts/app

COPY package*.json /posts/app/

RUN npm install

COPY . /posts/app

EXPOSE 3001

CMD [ "npm","start" ]