import React, { Component } from "react";
import { Navbar, Nav } from "react-bootstrap";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import { Dashboard } from "./Dashboard";
import { Books } from "./Books";
import { MaturedBonds } from "./MaturedBonds";
import BondDetails from "./BondDetails";
import "../App.css";

export default class NavbarComp extends Component {
  render() {
    return (
      <Router>
        <div>
          <Navbar bg="dark" variant={"dark"} expand="lg" className="navbar">
            <Navbar.Brand href="/">Bonds Universe</Navbar.Brand>
            <Navbar.Toggle aria-controls="basic-navbar-nav" />
            <Navbar.Collapse id="basic-navbar-nav">
              <Nav className="me-auto">
                <Nav.Link as={Link} to={"/Books"}>
                  Books
                </Nav.Link>
                <Nav.Link as={Link} to={"/MaturedBonds"}>
                  Matured Bonds
                </Nav.Link>
              </Nav>
            </Navbar.Collapse>
          </Navbar>
        </div>
        <div>
          <Routes>
            <Route path="/" element={<Dashboard />} />
            <Route path="/Books" element={<Books />} />
            <Route path="/MaturedBonds" element={<MaturedBonds />} />
            <Route path="/BondDetails" element={<BondDetails />} />
          </Routes>
        </div>
      </Router>
    );
  }
}
