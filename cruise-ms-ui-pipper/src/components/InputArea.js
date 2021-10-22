import React, { Component } from 'react'

export class InputArea extends Component {
    
    constructor(props) {
        super(props)
    
        this.state = {
            message:""
        }
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }
    
    handleChange(event){
        this.setState({message: event.target.value});
    }

    handleSubmit(event){
        alert(this.state.message);
        event.preventDefault();
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <label>
                    <input
                    className="inputArea"
                    type="text"
                    value={this.state.message}
                    onChange={this.handleChange}
                    />
                </label>
                <input type="submit" value="Submit"/>
            </form>
        )
    }
}

export default InputArea