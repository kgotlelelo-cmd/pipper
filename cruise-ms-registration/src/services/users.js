const fetch = require('node-fetch');
const logger = require('../config/logger');

function fetchAllusers(callback,url=process.env.DEV_URL_CLIENTS){
    logger.info("fetching all clients from domain application");
    fetch(url)
        .then(res=>res.json())
        .then(callback)
        .then(json => logger.debug(json))
        .catch((err)=>{
            logger.error(err);
        });
}

module.exports = fetchAllusers;