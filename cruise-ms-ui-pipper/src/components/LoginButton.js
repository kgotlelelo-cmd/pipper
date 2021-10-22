import React, { Component } from 'react'
import Button from './Button'

export class LoginButton extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
             isLoggin: false
        }
    }
    

    render() {
        return (
            <div className="login">
                {
                    (this.state.isLoggin)
                    ? <Button title="Logout"/>
                    : <Button title="Login"/>
                }   
            </div>
        )
    }
}

export default LoginButton