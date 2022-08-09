import React, { useState, useEffect } from "react";
import Table from "react-bootstrap/Table";
import { Input } from "antd";
import { findBonds } from "../services/DashboardServices";
import "bootstrap/dist/css/bootstrap.min.css";
import "react-bootstrap-table-next/dist/react-bootstrap-table2.min.css";
import { Link } from "react-router-dom";
import { useTableSearch } from "../search/useTableSearch";
import Container from "react-bootstrap/Container";
import NavbarComp from './NavbarComp';

export const Dashboard = () => {
  const [searchVal, setSearchVal] = useState(null);

  const { filteredData } = useTableSearch({
    searchVal,
    retrieve: findBonds,
  });

  return (
    <div>
    <NavbarComp />
    <Container>
      <p className="h3 text-left mt-3 mb-3">All Bonds</p>
      <div
        className="d-flex justify-content-center mb-3"
        style={{
          width: "100%",
          height: "0.2rem",
          backgroundImage: "linear-gradient(to right, #212529, #2C3034)",
          borderBottomLeftRadius: "8px",
          borderBottomRightRadius: "8px",
          justifyContent: "center",
        }}
      ></div>
      <Input
        onChange={(e) => setSearchVal(e.target.value)}
        placeholder="Search for Bonds"
        enterButton
        style={{ width: 300, textAlign: "center" }}
      />
      <div>
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
              <th>ID</th>
              <th>ISIN</th>
              <th>CUSIP</th>
              <th>Issuer</th>
              <th>Maturity Date</th>
              <th>Coupon</th>
              <th>Type</th>
              <th>Face Value</th>
              <th>Status</th>
              <th>More Details</th>
            </tr>
          </thead>
          <tbody>
            {filteredData.map((bond) => (
              <tr key={bond.id} style={{ cursor: "pointer" }}>
                <td>{bond.id}</td>
                <td>{bond.isin} </td>
                <td>{bond.cusip}</td>
                <td>{bond.issuer}</td>
                <td>{bond.maturitydate}</td>
                <td>{bond.coupon}</td>
                <td>{bond.type}</td>
                <td>{bond.facevalue}</td>
                <td>{bond.status}</td>
                <td>
                  <Link to="/BondDetails" state={{ bond: bond }}>
                    View
                  </Link>
                </td>
              </tr>
            ))}
          </tbody>
        </Table>
      </div>
    </Container>
    </div>
  );
};
