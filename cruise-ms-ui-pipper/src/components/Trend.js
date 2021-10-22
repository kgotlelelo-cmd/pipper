import React, { Component } from 'react'

export class Trend extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
             
        }
    }
    

    render() {
        return (
            <div>
                <p>{this.props.category}</p>
                <p>{this.props.hastag}</p>
                <p>{this.props.tweets}</p>
            </div>
        )
    }
}

export default Trend
