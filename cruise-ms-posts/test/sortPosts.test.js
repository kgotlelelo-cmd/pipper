const sortpost = require('../src/services/sortPosts');

test('should sort post by id', () => {

    let posts = [
        {
            "id":1,
            "message":"dfdfsdfsdfsdfsdf",
            "likes":0
        },
        {
            "id":2,
            "message":"dfdfsdfsdfsdfsdf",
            "likes":0
        },
        {
            "id":3,
            "message":"dfdfsdfsdfsdfsdf",
            "likes":0
        }
    ];

    let firstpost = sortpost(posts)[0];
    expect(firstpost).toEqual({
        id:3,
        message:"dfdfsdfsdfsdfsdf",
        likes:0
    });
})
