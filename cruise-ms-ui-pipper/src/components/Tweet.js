import React, { Component } from 'react'
import PropTypes from 'prop-types';

export class Tweet extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
             
        }
    }
    
    

    render() {
        return (
            <div>
                <h3>{this.props.heading}</h3>
                <p>{this.props.message}</p>
                <p>{this.props.likes}</p>
            </div>
        )
    }
}

Tweet.defaultProps = {
    heading: "Anon"
}

Tweet.propTypes ={
    heading: PropTypes.string,
    message: PropTypes.string.isRequired,
    likes: PropTypes.number.isRequired
}

export default Tweet
