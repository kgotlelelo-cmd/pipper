import React, { Component } from 'react'
import Search from '../components/Search'


export class Right extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
             
        }
    }
    

    render() {
        return (
            <div className="grid-item">
                <Search/>   
            </div>
        )
    }
}

export default Right
