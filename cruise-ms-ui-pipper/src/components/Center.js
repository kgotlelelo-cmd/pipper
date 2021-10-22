import React, { Component } from 'react'
import Header from '../components/Header'
import InputArea from '../components/InputArea'


export class Center extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
             
        }
    }
    

    render() {
        return (
            <div className="grid-item">
                <Header/>
                <InputArea/>
            </div>
        )
    }
}

export default Center
