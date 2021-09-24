const fetch = require('node-fetch');
const logger = require('../config/logger');

function fetchAllClients(callback){
    logger.info("fetching all clients from domain application");
    fetch(process.env.MOCKOON_URL_CLIENT)
        .then(res=>res.json())
        .then(posts)
        .then(callback)
        .then(json => logger.debug(json))
        .catch((err)=>{
            logger.error(err);
        });
}

function posts(clients){

    let post ={
        username: "",
        body: "",
        likes: 0
    }
    

    let posts = [];

    for(client of clients){
        if(client.posts != null){
            post.username = client.username;
            for(clientpost of client.posts){
                post.body = clientpost.body;
                post.likes = clientpost.likes;
                posts.push(post);
            }
        }
    }
    return posts;
}

module.exports = fetchAllClients;