import React from "react";
import '../signup.css'

function SignUp() {
    return (

        <div className="sParent">
            <div className="center">
                
                <h1>Sign Up</h1>

                <form>
                    <div className="txt_field">
                        <input type="text" />
                        <label>Name</label>
                    </div>
                    <div className="txt_field">
                        <input type="text" />
                        <label>Email</label>
                    </div>
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
        </div>
    )
}

export default SignUp