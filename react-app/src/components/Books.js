import React, { useState, useEffect } from "react";
import Table from "react-bootstrap/Table";
import Card from "react-bootstrap/Card";
import Container from "react-bootstrap/Container";
import { findTradesforBook } from "../services/BookService";
import "../App.css";

export const Books = () => {
  const [tradeList, setTradeList] = useState([]);

  useEffect(() => {
    findTradesforBook(1).then(({ data }) => {
      setTradeList(data);
    });
  }, []);

  let removeClickEffect = () => {
    document.getElementById("government-bond").style.backgroundColor = "#fff";
    document.getElementById("government-bond").style.boxShadow = "none";
    document.getElementById("corporate-bond").style.backgroundColor = "#fff";
    document.getElementById("corporate-bond").style.boxShadow = "none";
    document.getElementById("municipal-bond").style.backgroundColor = "#fff";
    document.getElementById("municipal-bond").style.boxShadow = "none";
  };

  if (tradeList.length === 0) {
    return <div>Loading...</div>;
  }
  return (
    <div>
      <Container>
        <p className="h3 text-left mt-3">Books</p>
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
        <div className="books-row">
          <div>
            <Card
              className="mt-5"
              id="government-bond"
              style={{
                width: "18rem",
                height: "15rem",
                cursor: "pointer",
              }}
              onClick={(event) => {
                console.log(event.target.style);
                removeClickEffect();
                document.getElementById("government-bond").style.boxShadow =
                  "0 8px 16px 0 rgba(0, 0, 0, 0.2)";
                document.getElementById(
                  "government-bond"
                ).style.backgroundColor = "#f5f5f5";
                findTradesforBook(1).then(({ data }) => {
                  setTradeList(data);
                });
              }}
            >
              <Card.Body>
                <Card.Title>Government Bonds</Card.Title>
                <Card.Subtitle className="mb-2 text-muted">
                  Savings Bond, Treasury Obligations, Treasury
                </Card.Subtitle>
                <Card.Text>
                  It acknowledges the Government's debt obligation. Such
                  securities are short term or long term.
                </Card.Text>
              </Card.Body>
            </Card>
          </div>
          <div>
            <Card
              className="mt-5"
              id="corporate-bond"
              style={{ width: "18rem", height: "15rem", cursor: "pointer" }}
              onClick={(event) => {
                console.log(event.target.style);
                removeClickEffect();
                document.getElementById("corporate-bond").style.boxShadow =
                  "0 8px 16px 0 rgba(0, 0, 0, 0.2)";
                document.getElementById(
                  "corporate-bond"
                ).style.backgroundColor = "#f5f5f5";
                findTradesforBook(2).then(({ data }) => {
                  setTradeList(data);
                });
              }}
            >
              <Card.Body>
                <Card.Title>Corporate Bonds</Card.Title>
                <Card.Subtitle className="mb-2 text-muted">
                  Junk Bond
                </Card.Subtitle>
                <Card.Text>
                  Corporate bonds are debt securities that public and private
                  companies issue to raise funds and serve their various
                  business purposes.
                </Card.Text>
              </Card.Body>
            </Card>
          </div>
          <div>
            <Card
              className="mt-5"
              id="municipal-bond"
              style={{ width: "18rem", height: "15rem", cursor: "pointer" }}
              onClick={(event) => {
                console.log(event.target.style);
                removeClickEffect();
                document.getElementById("municipal-bond").style.boxShadow =
                  "0 8px 16px 0 rgba(0, 0, 0, 0.2)";
                document.getElementById(
                  "municipal-bond"
                ).style.backgroundColor = "#f5f5f5";
                findTradesforBook(3).then(({ data }) => {
                  setTradeList(data);
                });
              }}
            >
              <Card.Body>
                <Card.Title>Municipal Bonds</Card.Title>
                <Card.Subtitle className="mb-2 text-muted">
                  Also known as "Munis"
                </Card.Subtitle>
                <Card.Text>
                  Municipal securities are bonds issued by states, cities,
                  counties and other governmental entities to raise money to
                  build roads, schools and other projects.
                </Card.Text>
              </Card.Body>
            </Card>
          </div>
        </div>
        <Table
          striped
          bordered
          hover
          size="xl"
          variant="dark"
          className="container mt-5"
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
            {tradeList.map((trade) => (
              <tr key={trade.id}>
                <td>{trade.quantity}</td>
                <td>{trade.status}</td>
                <td>{trade.price}</td>
                <td>{trade.buysell === false ? "Sell" : "Buy"}</td>
                <td>{trade.tradedate}</td>
                <td>{trade.settlementdate}</td>
              </tr>
            ))}
          </tbody>
        </Table>
      </Container>
    </div>
  );
};
