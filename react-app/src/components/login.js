import React, {useState} from 'react';
   import {Form, Button, Container} from 'react-bootstrap';
   import {Link} from 'react-router-dom';
   import {loginUser} from "../services/LoginService"
const Login = () => {

    const [userCredentials, setUserCredentials] = useState({
        email:"",
        password:""
    })

    let login = (e) => {
        e.preventDefault();
        let user = loginUser(userCredentials);
    }

    return (
        <div>
            <Container className="justify-content-center mt-5 pt-5">
            <h1>Login</h1>
            <Form style={{width:"27%",marginLeft:"36%"}} onSubmit={login}>
                <Form.Group >
                    <Form.Label>Enter your email</Form.Label>
                    <Form.Control id="email" type="email" placeholder="Enter your email" value={userCredentials.email} onChange={(e) => setUserCredentials({...userCredentials, email: e.target.value})}/>
                </Form.Group>
                <Form.Group >
                    <Form.Label>Enter your password</Form.Label>
                    <Form.Control id="password" type="password" placeholder="Enter your password" value={userCredentials.password} onChange={(e) => setUserCredentials({...userCredentials, password: e.target.value})} />
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
