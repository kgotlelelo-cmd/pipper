import React, { Component } from 'react'

export class Button extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
             
        }
    }
    

    render() {
        return (
            <button
                className="btn"
            >{this.props.title}</button>
        )
    }
}

export default Button
