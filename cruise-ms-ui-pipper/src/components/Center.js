import React, { Component } from 'react'
import Header from '../components/Header'
// import '../css/index.css'

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
            </div>
        )
    }
}

export default Center
