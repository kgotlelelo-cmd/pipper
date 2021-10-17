const fetch = require('node-fetch');
const logger = require('../config/logger');
const sortPosts = require('./sortPosts');

exports.fetchPosts = function fetchPosts(callback,url=process.env.DEV_URL_POSTS){
    logger.info(
        "fetching all post from domain service"
    );

    fetch(url)
        .then(res => res.json())
        .then(sortPosts)
        .then(callback)
        .then(json => logger.debug(json))
        .catch((err)=>{
            logger.error(err);
        })
}