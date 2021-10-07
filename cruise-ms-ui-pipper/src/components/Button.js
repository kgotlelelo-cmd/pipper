import React from 'react';
import '../css/button.css';

export default class Button extends React.Component{

    constructor(props){
        super(props);
        this.state = {
            url:""
        }
    };

    render(){
        return(
            <p  className="button" >{this.props.name}</p>
        );
    };
}