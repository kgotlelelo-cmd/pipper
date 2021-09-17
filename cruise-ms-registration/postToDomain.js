const fetch = require("node-fetch");

function postToDomain(body){
    console.log(typeof(body));
    fetch('http://localhost:8080/cruise-ms-domain/client/register',{
        method: 'post',
        body: JSON.stringify(body),
        headers: { 'Content-Type': 'application/json' },
    }).then(res => res.json())
    .then(json => console.log(json));
}

module.exports = postToDomain;