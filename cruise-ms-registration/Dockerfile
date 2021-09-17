FROM node:14

RUN mkdir -p registration/app

WORKDIR /registration/app

COPY package*.json /registration/app/

RUN npm install

COPY . /registration/app/

EXPOSE 4000

CMD ["npm","start"]