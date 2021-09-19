const express = require('express')
const app = express();
require("dotenv").config();

var bodyParser = require("body-parser");

app.use(bodyParser.json());
app.use(express.urlencoded({ extended: false }));

const indexRouter = require('./index');
app.use('/',indexRouter);

const port = process.env.DEV_PORT;
console.log(port)

app.listen(port,()=>{
    console.log(`running on port ${port}`)
})