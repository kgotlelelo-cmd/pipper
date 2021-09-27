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

index.get("/clients",(req,res)=>{
    logger.info("clients endpoint was called");
    users((value) => res.send(value));
    logger.info("Done");

});

index.get("/clients/:id",(req,res)=>{
    logger.info(`requesting client with id ${req.params.id}`);
    user((value) => res.send(value),process.env.DEV_URL_CLIENT_BY_ID+req.params.id);
    logger.info("Done");
});

module.exports = index;