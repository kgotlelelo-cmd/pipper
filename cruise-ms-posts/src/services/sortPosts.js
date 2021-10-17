function sortPosts(posts){
    posts.sort((a,b) => (a.id < b.id) ? 1 : ((b.id < a.id) ? -1 : 0));
    return posts;
}

module.exports = sortPosts;