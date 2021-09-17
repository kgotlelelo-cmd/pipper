const fetch = require('node-fetch');

function callDomainApi(callback){

    fetch('http://localhost:8080/cruise-ms-domain/clients')
        .then(res=>res.json())
        .then(posts)
        .then(callback)
        .then(json => console.log(json)) //should put logger
        .catch((err)=>{
            console.log(err)
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

module.exports = callDomainApi;