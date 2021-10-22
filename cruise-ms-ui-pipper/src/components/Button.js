import React, { Component } from 'react'
import PropTypes from 'prop-types';


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

Button.propTypes = {
    title: PropTypes.string.isRequired
}

export default Button
