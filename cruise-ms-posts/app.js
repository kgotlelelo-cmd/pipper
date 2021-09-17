const express = require('express')
const app = express();

var bodyParser = require("body-parser");

app.use(bodyParser.json());
app.use(express.urlencoded({ extended: false }));

const indexRouter = require('./index');
app.use('/',indexRouter);

const port = 3001;

app.listen(port,()=>{
    console.log(`running on port ${port}`)
})