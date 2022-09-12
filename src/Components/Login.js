import React from "react";
import '../Login.css'


function Login() {
    return (
        <div className="center">

            <h1>Login</h1>

            <form>
                <div className="txt_field">
                    <input type="text" />
                    <label>Username</label>
                </div>
                <div className="txt_field">
                    <input type="password" />
                    <label>Password</label>
                </div>
                <div className="submitField">
                    <input type="submit" value="Login" />
                </div>
            </form>


            
        </div>
    )
}

export default Login