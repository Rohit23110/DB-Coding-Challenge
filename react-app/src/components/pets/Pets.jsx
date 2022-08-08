import React, { useState, useEffect } from "react";
import { findPets } from "../../services/PetServices";
import styles from "./Pets.module.scss";

export const Pets = () => {
    const [pets, setPets] = useState([]);

    useEffect(() => {
    findPets()
            .then(({data}) => {
            setPets(data);
            });
    }, []);
  return (
    <>
        { pets.map(pet => 
        <div className={styles.pets}>
            <div>ID: {pet.id}</div>
            <div>Issuer: {pet.issuer} </div>
            <div>Maturity Date: {pet.maturitydate}</div>
            <div>Coupon: {pet.coupon}</div>
            <div>Type: {pet.type}</div>
            <div>Face Value: {pet.facevalue}</div>
            <div>Status: {pet.status}</div>
            <div>CUSIP: {pet.cusip}</div>
            <div>ISIN: {pet.isin}</div>
        </div>) 
        }
    </>
  )
};
