const express = require("express");
const index  = express.Router();
const callDomainApi = require('./fetch')

index.get("/posts",(req,res)=>{
    callDomainApi((value) => res.send(value));
});


index.get("/posts/timeline",(req,res)=>{
    res.send("To be completed");
})


module.exports  = index;