import React from "react";
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Login from "./components/login";
import Registration from './components/Registration';
import {Books} from './components/Books';
import {Dashboard} from './components/Dashboard';
// import MyBonds from './components/MyBonds';
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";

function App() {
  return (
    <Router>
      <div className="App">
        <Routes>
          <Route path="/" element={<Login/>} />
          <Route path="/login" element={<Login/>}/>
          <Route path="/Registration" element={<Registration/>}/>
          <Route path="/Dashboard" element={<Dashboard/>} />
          <Route path='/Books' element={<Books/>} />
          {/* <Route path='/MyBonds' element={<MyBonds/>} /> */}
        </Routes>
      </div>
    </Router>
  );
}

export default App;
