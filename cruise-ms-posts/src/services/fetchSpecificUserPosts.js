const fetch = require('node-fetch');
const logger = require('../config/logger');
const {sortPosts} = require('./fetchPosts');

function fetchClientPosts(callback,url=process.env.DEV_URL_CLIENT_POSTS){
    logger.info(
        "fecthing client post from domain service"
    );

    fetch(url)
        .then(res => res.json())
        .then(sortPosts)
        .then(callback)
        .then(json => logger.debug(json))
        .catch((err)=>{
            logger.error(err);
        });
}

module.exports =fetchClientPosts;