import React from "react";
import '../Login.css'
import {useState} from 'react';

function Login() {

    const [state, setState] = React.useState({
        username: "", 
        password: ""
      }); 

      function handleChange(event) {
        const value = event.target.value;
        setState({
          ...state,
          [event.target.name]: value,
        });
      }



    return (

        <div className="lParent">
            <div className="center">

                <h1>Login</h1>

                <form>
                    <div className="txt_field">
                        <input type="text" name="username" value={state.username} onChange={handleChange}/>
                        <label>Username</label>
                    </div>
                    <div className="txt_field">
                        <input type="password"  name="password" value={state.password} onChange={handleChange}/>
                        <label>Password</label>
                    </div>
                    <div className="submitField">
                        <input type="submit" value="Login"/>
                    </div>
                </form>     
            </div>
        </div>
    )
}

export default Login