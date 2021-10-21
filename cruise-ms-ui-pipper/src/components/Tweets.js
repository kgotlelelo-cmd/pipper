import React, { Component } from 'react'
import Tweet from './Tweet'

export class Tweets extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
             posts: []
        }
    }

    componentDidMount() {
    }
    
    

    render() {
        return (
            <div>
                {
                    this.state.posts.map((id,message,likes)=>(
                        <Tweet key={id} message={message} likes={likes} />
                    ))
                }
            </div>
        )
    }
}

export default Tweets