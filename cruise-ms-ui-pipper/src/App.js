import React, { Component } from 'react'
import Center from './components/Center'
import Left from './components/Left'
import Right from './components/Right'
import './css/index.css';

export class App extends Component {

  constructor(props) {
    super(props)
  
    this.state = {
       
    }
  }
  

  render() {
    return (
      <div className="grid-container">
      <Left/>
      <Center/>
      <Right/>
      </div>
    )
  }
}

export default App
