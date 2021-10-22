import React, { Component } from 'react'
import Button from '../components/Button'
import LoginButton from '../components/LoginButton'


export class Left extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
             
        }
    }
    

    render() {
        return (
            <div className="grid-item">
                <Button title="Home"/>
                <Button title="Explore"/>
                <Button title="Notification"/>
                <Button title="Messages"/>
                <Button title="Profile"/>
                <Button title="More"/>
                <LoginButton/>
            </div>
        )
    }
}

export default Left
