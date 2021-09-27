const fetch = require('node-fetch');
const logger = require('../config/logger');

function fetchSpecificUser(callback,url=process.env.DEV_URL_CLIENT_BY_ID){
    logger.info("fetching a specific clients from domain application");
    fetch(url)
        .then(res=>res.json())
        .then(callback)
        .then(json => logger.debug(json))
        .catch((err)=>{
            logger.error(err);
        });
}

function fectchUserByEmail(callback,url=process.env.DEV_URL_CLIENT_BY_EMAIL){
    logger.info("fetching a specific clients by email from domain application");
    fetch(url)
        .then(res=> res.json())
        .then(callback)
        .then(json => logger.debug(json))
        .catch((err)=>{
            logger.error(err);
        });
}

module.exports = fetchSpecificUser,fectchUserByEmail;