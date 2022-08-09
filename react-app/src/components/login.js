import React from 'react';
   import {Form, Button, Container} from 'react-bootstrap';
   import {Link} from 'react-router-dom';
   import {loginUser} from "../services/LoginService"
const Login = () => {

    let loginUser = (e) => {
        e.preventDefault()
        let user = loginUser({
            'email':e.target.getElementById("email").value,
            'password':e.target.getElementById("password").value
        });
    }

    return (
        <div>
            <Container className="justify-content-center mt-5 pt-5">
            <h1>Login</h1>
            <Form style={{width:"27%",marginLeft:"36%"}} onSubmit={loginUser}>
                <Form.Group >
                    <Form.Label>Enter your email</Form.Label>
                    <Form.Control id="email" type="email" placeholder="Enter your email" />
                </Form.Group>
                <Form.Group >
                    <Form.Label>Enter your password</Form.Label>
                    <Form.Control id="password" type="password" placeholder="Enter your password" />
                </Form.Group>
                <Button className="mt-3" variant="dark" type="submit" >Submit</Button>
                <div className='reg-link'>
                    <p>New User? Create New Account <Link to='/Registration'>REGISTER</Link></p>
                </div>
            </Form>
            </Container>
        </div>
    )
}

export default Login;
