import React, { Component } from 'react'
import Tweet from './Tweet'

export class Tweets extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
             posts: [
                 {
                     id:1,
                     message:"Lorem ipsum dolor sit amet consectetur adipisicing elit",
                     likes:1
                 },
                 {
                    id:2,
                    message:"molestiae quas vel sint commodi repudiandae consequuntur voluptatum laborum",
                    likes:5
                },
                {
                    id:3,
                    message:"numquam blanditiis harum quisquam eius sed odit fugiat iusto fuga praesentium",
                    likes:7
                },
                {
                    id:4,
                    message:"optio, eaque rerum! Provident similique accusantium nemo autem. Veritatis",
                    likes:100
                },
                {
                    id:5,
                    message:"obcaecati tenetur iure eius earum ut molestias architecto voluptate aliquam",
                    likes:6
                },
                {
                    id:6,
                    message:"nihil, eveniet aliquid culpa officia aut! Impedit sit sunt quaerat, odit",
                    likes:1
                },
                {
                    id:7,
                    message:"tenetur error, harum nesciunt ipsum debitis quas aliquid. Reprehenderit",
                    likes:8
                },
                {
                    id:8,
                    message:"quia. Quo neque error repudiandae fuga? Ipsa laudantium molestias eos",
                    likes:5
                },
                {
                    id:9,
                    message:"sapiente officiis modi at sunt excepturi expedita sint? Sed quibusdam",
                    likes:3
                }
             ]
        }
    }

    componentDidMount() {
    }
    
    

    render() {
        return (
            <div>
                {
                    this.state.posts.map((value)=>(
                        <Tweet key={value.id} message={value.message} likes={value.likes} />
                    ))
                }
            </div>
        )
    }
}

export default Tweets