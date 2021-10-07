import React from 'react';
import './css/background.css';

export default class backGround extends React.Component{

    render(){
        return(
            <div className='grid-container'>
                <div className='grid-item'>1</div>
                <div className='grid-item'>2</div>
                <div className='grid-item'>3</div>
            </div>
        );
    }
};