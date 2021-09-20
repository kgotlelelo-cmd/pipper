const express = require("express");
const logger = require('./logger');
const postToDomain = require("./postToDomain");
const index = express.Router();


index.post("/register",(req,res)=>{
    logger.info("register endpoint was called");
    logger.debug(req.body);
    postToDomain(req.body)
    res.send({sucessful:true})
});
module.exports = index;