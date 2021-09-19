const express = require("express");
const app = express();
require("dotenv").config();
var bodyParser = require("body-parser");

app.use(bodyParser.json());
app.use(express.urlencoded({ extended: true }));

const indexRouter = require("./index");
app.use("/",indexRouter);
const port=process.env.DEV_PORT;

app.listen(port,()=>{
    console.log(`running on port ${port}`)
});