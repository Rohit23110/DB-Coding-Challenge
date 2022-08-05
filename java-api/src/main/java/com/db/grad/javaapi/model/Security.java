// package com.db.grad.javaapi.model;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.Id;
// import javax.persistence.Table;
// import java.sql.Timestamp;

// @Entity
// @Table(name = "security")
// public class Security {

//     @Id
//     private int id;
//     private String ISIN;
//     private String CUSIP;
//     private String issuer;
//     private Timestamp maturityDate;
//     private float coupon;
//     private String type;
//     private long faceValue;
//     private String status;

//     public Security() {

//     }

//     public Security(int id, String ISIN, String CUSIP, String issuer, Timestamp maturityDate,
//             float coupon, String type, long faceValue, String status) {
//         this.id = id;
//         this.ISIN = ISIN;
//         this.CUSIP = CUSIP;
//         this.issuer = issuer;
//         this.maturityDate = maturityDate;
//         this.coupon = coupon;
//         this.type = type;
//         this.faceValue = faceValue;
//         this.status = status;
//     }

//     @Id
//     public int getId() {
//         return id;
//     }

//     public void setId(int id) {
//         this.id = id;
//     }

//     @Column(name = "ISIN", nullable = false)
//     public String getISIN() {
//         return ISIN;
//     }

//     public void setISIN(String ISIN) {
//         this.ISIN = ISIN;
//     }

//     @Column(name = "CUSIP", nullable = false)
//     public String getCUSIP() {
//         return CUSIP;
//     }

//     public void setCUSIP(String CUSIP) {
//         this.CUSIP = CUSIP;
//     }

//     @Column(name = "issuer", nullable = false)
//     public String getIssuer() {
//         return issuer;
//     }

//     public void setIssuer(String issuer) {
//         this.issuer = issuer;
//     }

//     @Column(name = "maturityDate", nullable = false)
//     public Timestamp getMaturityDate() {
//         return maturityDate;
//     }

//     public void setMaturityDate(Timestamp maturityDate) {
//         this.maturityDate = maturityDate;
//     }

//     @Column(name = "coupon", nullable = false)
//     public float getCoupon() {
//         return coupon;
//     }

//     public void setCoupon(float coupon) {
//         this.coupon = coupon;
//     }

//     @Column(name = "type", nullable = false)
//     public String getType() {
//         return type;
//     }

//     public void setType(String type) {
//         this.type = type;
//     }

//     @Column(name = "faceValue", nullable = false)
//     public long getFaceValue() {
//         return faceValue;
//     }

//     public void setFaceValue(long faceValue) {
//         this.faceValue = faceValue;
//     }

//     @Column(name = "status", nullable = false)
//     public String getStatus() {
//         return status;
//     }

//     public void setStatus(String status) {
//         this.status = status;
//     }
// }