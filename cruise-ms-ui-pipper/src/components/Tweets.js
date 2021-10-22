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
                    this.state.posts.map((value)=>(
                        <Tweet key={value.id} message={value.message} likes={value.likes} />
                    ))
                }
            </div>
        )
    }
}

export default Tweets