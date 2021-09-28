const express = require("express");
const logger = require('../config/logger');
const register = require("../services/registerUser");
const users = require('../services/users');
const {fetchSpecificUser,fectchUserByEmail} = require('../services/userInfo');

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
    fetchSpecificUser((value) => res.send(value),process.env.DEV_URL_CLIENT_BY_ID+req.params.id);
    logger.info("Done");
});

index.get("/clients/email/:email",(req,res)=>{
    logger.info(`requesting client with email ${req.params.email}`);
    fectchUserByEmail((value) => res.send(value),process.env.DEV_URL_CLIENT_BY_EMAIL+req.params.email);
    logger.info("Done");
});

module.exports = index;