import React, { useState, useEffect } from "react";
import { useLocation } from "react-router-dom";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import { findTradesforBond } from "../services/BookService";
import Table from "react-bootstrap/Table";
import NavbarComp from './NavbarComp';

const BondDetails = () => {
  const location = useLocation();
  const { bond } = location.state;
  const [tradeList, setTradeList] = useState([]);

  useEffect(() => {
    findTradesforBond(bond.id).then(({ data }) => {
      setTradeList(data);
    });
  }, []);

  return (
    <>
      <NavbarComp />
      <p className="h3 text-left mt-3">Bond Details</p>
      <Container>
        <div
          style={{
            width: "100%",
            height: "0.2rem",
            backgroundImage: "linear-gradient(to right, #212529, #2C3034)",
            borderBottomLeftRadius: "8px",
            borderBottomRightRadius: "8px",
          }}
        ></div>
        <Row className="mt-3">
          <Col>
            <strong>Issuer</strong>
          </Col>
          <Col>
            <strong>Maturity Date</strong>
          </Col>
          <Col>
            <strong>Coupon</strong>
          </Col>
          <Col>
            <strong>CUSIP</strong>
          </Col>
        </Row>
        <Row className="mt-2">
          <Col>{bond.issuer}</Col>
          <Col>{bond.maturitydate}</Col>
          <Col>{bond.coupon}</Col>
          <Col>{bond.cusip}</Col>
        </Row>
        <Row className="mt-2">
          <Col>
            <strong>Type</strong>
          </Col>
          <Col>
            <strong>Face Value</strong>
          </Col>
          <Col>
            <strong>Status</strong>
          </Col>
          <Col>
            <strong>ISIN</strong>
          </Col>
        </Row>
        <Row className="mt-2">
          <Col>{bond.type}</Col>
          <Col>{bond.facevalue}</Col>
          <Col>{bond.status}</Col>
          <Col>{bond.isin}</Col>
        </Row>
        <p className="h3 text-left mt-5">Trades</p>
        <div
          className="d-flex justify-content-center"
          style={{
            width: "100%",
            height: "0.2rem",
            backgroundImage: "linear-gradient(to right, #212529, #2C3034)",
            borderBottomLeftRadius: "8px",
            borderBottomRightRadius: "8px",
            justifyContent: "center",
          }}
        ></div>
        <Table
          striped
          bordered
          hover
          size="xl"
          variant="dark"
          className="container mt-3"
          border="2"
        >
          <thead>
            <tr>
              <th>Quantity</th>
              <th>Status</th>
              <th>Price</th>
              <th>BuySell</th>
              <th>Trade Date</th>
              <th>Settlement Date</th>
            </tr>
          </thead>
          <tbody>
            {tradeList.length == 0 ? (
              <div>Loading Trades...</div>
            ) : (
              tradeList.map((trade) => (
                <tr key={trade.id}>
                  <td>{trade.quantity}</td>
                  <td>{trade.status}</td>
                  <td>{trade.price}</td>
                  <td>{trade.buysell === false ? "Sell" : "Buy"}</td>
                  <td>{trade.tradedate}</td>
                  <td>{trade.settlementdate}</td>
                </tr>
              ))
            )}
          </tbody>
        </Table>
      </Container>
    </>
  );
};

export default BondDetails;
