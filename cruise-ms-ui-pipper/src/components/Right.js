import React, { Component } from 'react'
import Search from '../components/Search'
import Trends from '../components/Trends'

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
                <Trends/>
            </div>
        )
    }
}

export default Right
