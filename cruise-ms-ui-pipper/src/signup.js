import React ,{Component} from "react";
import {Box, Button, TextField} from '@mui/material';

class Signup extends Component {

    constructor(props, context) {
        super(props, context);
        this.state = {
            username: "",
            firstName: "",
            lastName: "",
            email: "",
        }
        this.handleChange = this.handleChange.bind(this);
        this.handleSignUp = this.handleSignUp.bind(this);
        this.handleLogin = this.handleLogin.bind(this);
    }

    handleChange(event,field){
        this.setState({
            [field]: event.target.value
        });
    }

    handleSignUp(){
        alert(this.state.username+
            " "+this.state.firstName+
            " "+this.state.lastName+
            " "+this.state.email);
    }

    handleLogin(){
        alert("Logged in")
    }

    render() {
        return (
            <Box
            sx={{
                // backgroundColor: 'primary.main',
                border: '1px solid black',
                padding: '7px',
                width: '300px',
                height: '300px',
                justifyContent: 'center',
                position: 'absolute',
                margin: 'auto',
                left: '0',
                right: '0',
                top: '0',
                bottom: '0'
            }}>
                <div>
                    <TextField
                        required
                        id={'outlined-required'}
                        label={'Required'}
                        defaultValue={'username'}
                        placeholder={'username'}
                        onChange={(event)=>this.handleChange(event,"username")}
                        sx={{
                            display: "block",
                            marginLeft: '30px',
                            marginTop: '7px',
                            marginBottom: '7px'
                        }}
                    />
                    <TextField
                        required
                        id={'outlined-required'}
                        label={'Required'}
                        defaultValue={'firstname'}
                        placeholder={'firstname'}
                        onChange={(event)=>this.handleChange(event,"firstName")}
                        sx={{
                            display: "block",
                            marginLeft: '30px',
                            marginTop: '7px',
                            marginBottom: '7px'
                        }}
                    />
                    <TextField
                        required
                        id={'outlined-required'}
                        label={'Required'}
                        defaultValue={'lastname'}
                        placeholder={'lastname'}
                        onChange={(event)=>this.handleChange(event,"lastName")}

                        sx={{
                            display: "block",
                            marginLeft: '30px',
                            marginTop: '7px',
                            marginBottom: '7px'
                        }}
                    />
                    <TextField
                        required
                        id={'outlined-required'}
                        label={'Required'}
                        defaultValue={'email'}
                        placeholder={'email'}
                        onChange={(event)=>this.handleChange(event,"email")}

                        sx={{
                            display: "block",
                            marginLeft: '30px',
                            marginTop: '7px',
                            marginBottom: '7px'
                        }}
                    />
                    <Button
                        variant={'Contained'}
                        onClick={this.handleSignUp}
                        sx={{
                            border: '1px solid black',
                            marginLeft: '30px'
                        }}
                    >
                        SignUp
                    </Button>
                    <Button
                        variant={'Contained'}
                        onClick={this.handleLogin}
                        sx={{
                            border: '1px solid black',
                            marginLeft: '47px',
                            paddingLeft: '25px',
                            paddingRight: '25px'
                        }}
                    >
                        Login
                    </Button>
                </div>
            </Box>
        );
    }
}

export default Signup;
