const fetch = require('node-fetch');
const logger = require('../config/logger');
const sortPosts = require('./fetchPosts/sortPosts');

function fetchClientPosts(callback,id){
    logger.info(
        "fecthing client post from domain service"
    );

    //need fixing with id from user
    fetch(process.env.MOCKOON_URL_CLIENT_POSTS)
        .then(res => res.json())
        .then(sortPosts)
        .then(callback)
        .then(json => logger.debug(json))
        .catch((err)=>{
            logger.error(err);
        });
}

module.exports =fetchClientPosts;