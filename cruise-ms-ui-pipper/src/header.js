import React from 'react';
import Button from './components/Button';

import './css/header.css'

export default class header extends React.Component{

    constructor(props){
        super(props);
        this.state={

        }
    };

    render(){
        return(
            <div className="header">
                <Button name="Home"/>
                <Button name="profile"/>
            </div>
        );
    }
}