const express = require("express");
const index  = express.Router();
const fetchPosts = require('../services/fetchPosts/fetchPosts');
const userPosts = require('../services/fetchSpecificUserPosts/fetchClientPosts');
const logger = require('../config/logger');

index.get("/posts",(req,res)=>{
    logger.info("The posts end point was called");
    fetchPosts((value) => res.send(value));
    logger.info("Response of posts was sent");
});

index.get("/client:id/posts",(req,res)=>{
    logger.info(`the fetchPosts of specific user endpoint was called
    with ${req.body} as a parameter`);
    userPosts((value)=> res.send(value),req.body);
    logger.info("Response sent");

});

index.delete("/posts:id",(req,res)=>{
    logger.info("delete Posts");
});

index.put("/posts:id",(req,res)=>{
    logger.info("edit posts");
});

module.exports  = index;