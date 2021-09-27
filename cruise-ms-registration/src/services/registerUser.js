const fetch = require("node-fetch");
logger = require('../config/logger');

function register(body,url=process.env.DEV_REG_URL){
    logger.info("Posting into domain service");
    fetch(url,{
        method: 'post',
        body: JSON.stringify(body),
        headers: { 'Content-Type': 'application/json' },
    }).then(res => res.json())
    .then(json => logger.debug(json))
    .catch((err)=>{
        logger.error(err);
    });
}

module.exports = register;