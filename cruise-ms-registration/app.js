const express = require("express");
const app = express();
var bodyParser = require("body-parser");

app.use(bodyParser.json());
app.use(express.urlencoded({ extended: true }));

const indexRouter = require("./index");
app.use("/",indexRouter);
const port=4000;

app.listen(port,()=>{
    console.log("running")
});