const express = require("express");
const postToDomain = require("./postToDomain");
const index = express.Router();


index.post("/register",(req,res)=>{
    console.log(req.body);
    postToDomain(req.body)
    res.send({sucessful:true})
});
module.exports = index;