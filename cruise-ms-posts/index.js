const express = require("express");
const index  = express.Router();
const callDomainApi = require('./fetch')
const logger = require('./logger');

index.get("/posts",(req,res)=>{
    logger.info("The posts end point was called");
    callDomainApi((value) => res.send(value));
    logger.info("Response of posts was sent");
});


module.exports  = index;