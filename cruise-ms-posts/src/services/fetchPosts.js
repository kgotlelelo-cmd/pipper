const fetch = require('node-fetch');
const logger = require('../config/logger');

function fetchPosts(callback,url=process.env.DEV_URL_POSTS){
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

function sortPosts(posts){
    posts.sort((a,b) => (a.id < b.id) ? 1 : ((b.id < a.id) ? -1 : 0));
    return posts;
}

module.exports =fetchPosts,sortPosts;