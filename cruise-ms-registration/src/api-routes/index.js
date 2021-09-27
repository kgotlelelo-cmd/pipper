const express = require("express");
const logger = require('../config/logger');
const register = require("../services/registerUser");
const users = require('../services/users');
const user = require('../services/userInfo');
const index = express.Router();


index.post("/register",(req,res)=>{
    logger.info("register endpoint was called");
    logger.debug(req.body);
    register(req.body)
    res.send({sucessful:true})
});

index.get("/client",(req,res)=>{
    logger.info("clients endpoint was called");
    users((value) => res.send(value));
    logger.info("Done");

});

index.get("/client:id",(req,res)=>{
    logger.info(`requesting client with id ${req.body}`);
    user((value) => res.send(value));
    logger.info("Done");
});

module.exports = index;