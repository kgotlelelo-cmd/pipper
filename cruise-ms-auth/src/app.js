const express = require('express');
const { auth, requiresAuth} = require('express-openid-connect');
const app = express();
const verify = require('./service/verifyClient');

require('dotenv').config();
const logger = require('./config/logger');

app.use(
    auth({
        authRequired:false,
        auth0Logout:true,
        issuerBaseURL: process.env.ISSUER_BASE_URL,
        baseURL: process.env.BASE_URL,
        clientID: process.env.CLIENT_ID,
        secret: process.env.SECRET
    })
);

app.get('/',requiresAuth(),(req, res) => {
    verify(req,(value)=>res.send(value));
})


const port = process.env.PORT || 3000;

app.listen(port,()=>{
    logger.info(`Running on Port ${port}`);
})