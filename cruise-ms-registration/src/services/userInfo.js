const fetch = require('node-fetch');
const logger = require('../config/logger');

function fetchSpecificUser(url=process.env.MOCKOON_URL_CLIENT,callback){
    logger.info("fetching a specific clients from domain application");
    fetch(process.env.MOCKOON_URL_CLIENT)
        .then(res=>res.json())
        .then(callback)
        .then(json => logger.debug(json))
        .catch((err)=>{
            logger.error(err);
        });
}

module.exports = fetchSpecificUser;