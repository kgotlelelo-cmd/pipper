import React, { Component } from 'react'
import PropTypes from 'prop-types';

export class Header extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
             
        }
    }
    

    render() {
        return (
            <h1 className="header"
            >{this.props.title}</h1>
        )
    }
}

Header.defaultProps = {
    title: "pipper"
}

Header.propTypes = {
    title: PropTypes.string
};

export default Header
