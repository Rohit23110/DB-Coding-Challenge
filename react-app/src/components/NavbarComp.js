import React, { Component } from "react";
import { Navbar, Nav } from "react-bootstrap";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import { Books } from "./Books";
import { MaturedBonds } from "./MaturedBonds";
import "../App.css";

export default class NavbarComp extends Component {
  render() {
    return (
        <div>
          <Navbar bg="dark" variant={"dark"} expand="lg" className="navbar">
            <Navbar.Brand href="/">Bonds Universe</Navbar.Brand>
            <Navbar.Toggle aria-controls="basic-navbar-nav" />
            <Navbar.Collapse id="basic-navbar-nav">
              <Nav className="me-auto">
                <Nav.Link as={Books} to={"/Books"}>Books</Nav.Link>
                <Nav.Link as={MaturedBonds} to={"/MaturedBonds"}>Matured Bonds</Nav.Link>
              </Nav>
            </Navbar.Collapse>
          </Navbar>
        </div>
    );
  }
}
