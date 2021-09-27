const fetch = require("node-fetch");
logger = require('../config/logger');

function register(body){
    logger.info("Posting into domain service");
    fetch(process.env.MOCK_REG_URL,{
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