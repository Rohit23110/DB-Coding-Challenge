import React, {useState, useEffect} from 'react'
import Login from './login';
import {Link, Navigate} from 'react-router-dom';
import {Form, Button, Container} from 'react-bootstrap';
import {registerUser} from "../services/RegistrationService"

function Registration(props) {
    
    const LOCAL_STORAGE_KEY = "Info";

    const [Info, setInfo] = useState({
        name:"",
        email:"",
        password:"",
        role:""
    });

    useEffect(() => {
        const retriveContacts = JSON.parse(localStorage.getItem(LOCAL_STORAGE_KEY));
        if (retriveContacts) setInfo(retriveContacts);
    }, [])

    useEffect(()=>{
        localStorage.setItem(LOCAL_STORAGE_KEY, JSON.stringify(Info))
    },[Info])

    let register = (e) =>{
        e.preventDefault()

        if (!Info.name || !Info.email || !Info.password || !Info.role) {
            alert("Complete all the fields!!!")
            return
        }

        registerUser(Info)
    }

    return (
        <Form onSubmit={register}>
            <div className='main'>
                <div className='sub-main'>
                    <div>
                        <div>
                            <h1>Registration</h1>
                            <div>
                            <Form.Label>Enter your Name</Form.Label>
                            <Form.Control id="name" type="text" placeholder='Enter Name' className='fill' value={Info.name} onChange={(e) => setInfo({...Info, name: e.target.value})}/>
                            </div>
                            <div>
                            <Form.Label>Enter your Email</Form.Label>
                            <Form.Control id="email" type="email" placeholder='Enter Email-id' className='fill' value={Info.email} onChange={(e) => setInfo({...Info, email: e.target.value})}/>
                            </div>
                            <div>
                            <Form.Label>Enter your Password</Form.Label>
                            <Form.Control id="password" type="password" placeholder='Enter New Password' className='fill' value={Info.password} onChange={(e) => setInfo({...Info, password: e.target.value})}/>
                            </div>
                            <div>
                            <Form.Label>Confirm Password</Form.Label>
                            <Form.Control type="password" placeholder='Enter New Password' className='fill' value={Info.password} onChange={(e) => setInfo({...Info, password: e.target.value})}/>
                            </div>
                            <div>
                            <Form.Label>Enter your Role</Form.Label>
                            <Form.Control id="role" type="text" placeholder='Enter Role' className='fill' value={Info.role} onChange={(e) => setInfo({...Info, role: e.target.value})}/>
                            </div>
                            <div>
                                {/* <Link to='/home'> */}
                                    <Button className="mt-3" variant="dark" type="submit">Register</Button>
                                {/* </Link> */}
                            </div>
                            <div>
                                <p>If Account exist then <Link to='/login'>LOGIN</Link></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </Form>
    )
}

export default Registration