const index = require('../src/api-routes/index');

const request = require("supertest");
const express = require("express");
const app = express();

app.use(express.urlencoded({ extended:false}));
app.use("/",index);

test('test posts endpoint', done=>{

    request(app)
        .get("/posts")
        .expect("Content-Type",/json/)
        .expect(200,done)
})
