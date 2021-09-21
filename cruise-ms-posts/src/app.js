const express = require('express')
const app = express();
const logger = require('./config/logger');
require("dotenv").config();


var bodyParser = require("body-parser");

app.use(bodyParser.json());
app.use(express.urlencoded({ extended: false }));

const indexRouter = require('./api-routes/index');
app.use('/',indexRouter);

const port = process.env.DEV_PORT;

app.listen(port,()=>{
    logger.info(`running on port ${port}`);
})