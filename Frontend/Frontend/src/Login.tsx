import React, { Component } from "react"
import { Redirect } from "react-router-dom";

import emailpic from "./assets/email.jpeg";

import "./styles/Login.css"
import { Link } from "react-router-dom"
import { render } from "react-dom";

export default class Login extends React.Component<{}, { [key: string]: any }> {
    constructor(props: Readonly<{}>){
        super(props)
        let loggedIn= false
        this.state={
            username : '',
            password : '',
            loggedIn
        }
        this.onChange=this.onChange.bind(this)
        this.submitForm=this.submitForm.bind(this)
    }


    onChange(e: { target: { name: any; value: any; }; }){
        this.setState({
            [e.target.name]: e.target.value
        })
    }
    
    submitForm(e: { preventDefault: () => void; }){
        e.preventDefault()
        const { username , password } =this.state
        if(username === "admin" && password === "admin123"){
            this.setState({
                loggedIn: true
            })
        }

    }
    render() {
        if(this.state.loggedIn){
            return <Redirect to= "/Homej" />
        }
    return (
        <div>
            
            <div className="main">
                <div className="sub-main">
                    <div>
                        
                        <form onSubmit={this.submitForm}>
                            <h1 className="card-title">Enter Admin credentials</h1>
                            <div>
                                <img src={emailpic} alt="email" className="email" />
                                <input
                                    type="text"
                                    placeholder="                     Enter username"
                                    name="username"
                                    value={this.state.username}
                                    onChange={this.onChange} />
                            </div>
                            <div>
                                
                                <input
                                    type="password"
                                    placeholder="                      Enter password"
                                    name="password"

                                    
                                    value={this.state.password}
                                    onChange={this.onChange} />
                            </div>
                            <div className="login-button">
                                <button className="btn btn">Login</button>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
            
        </div>

    )
    
    }
}

