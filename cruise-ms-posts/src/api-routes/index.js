const express = require("express");
const index  = express.Router();
const {fetchPosts} = require('../services/fetchPosts');
const userPosts = require('../services/fetchSpecificUserPosts');
const logger = require('../config/logger');

index.get("/posts",(req,res)=>{
    logger.info("The posts end point was called");
    fetchPosts((value) => res.send(value));
    logger.info("Response of posts was sent");
});

index.get("/client:id/posts",(req,res)=>{
    logger.info(`the fetchPosts of specific user endpoint was called
    with ${req.params.id} as a parameter`);
    userPosts((value)=> res.send(value),url=process.env.DEV_URL_CLIENT_POSTS+req.params.id+"/posts");
    logger.info("Response sent");

});

index.delete("/posts:id",(req,res)=>{
    logger.info("delete Posts");
});

index.put("/posts:id",(req,res)=>{
    logger.info("edit posts");
});

module.exports  = index;