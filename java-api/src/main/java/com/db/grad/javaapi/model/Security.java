package com.db.grad.javaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "security")
public class Security {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
    private String ISIN;
    private String CUSIP;
    private String issuer;
    private Date maturitydate;
    private float coupon;
    private String type;
    private long facevalue;
    private String status;

    public Security() {

    }

    public Security(int id, String ISIN, String CUSIP, String issuer, Date maturitydate,
            float coupon, String type, long facevalue, String status) {
        this.id = id;
        this.ISIN = ISIN;
        this.CUSIP = CUSIP;
        this.issuer = issuer;
        this.maturitydate = maturitydate;
        this.coupon = coupon;
        this.type = type;
        this.facevalue = facevalue;
        this.status = status;
    }

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "ISIN", nullable = false)
    public String getISIN() {
        return ISIN;
    }

    public void setISIN(String ISIN) {
        this.ISIN = ISIN;
    }

    @Column(name = "CUSIP", nullable = false)
    public String getCUSIP() {
        return CUSIP;
    }

    public void setCUSIP(String CUSIP) {
        this.CUSIP = CUSIP;
    }

    @Column(name = "issuer", nullable = false)
    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    @Column(name = "maturitydate", nullable = false)
    public Date getMaturitydate() {
        return maturitydate;
    }

    public void setMaturitydate(Date maturitydate) {
        this.maturitydate = maturitydate;
    }

    @Column(name = "coupon", nullable = false)
    public float getCoupon() {
        return coupon;
    }

    public void setCoupon(float coupon) {
        this.coupon = coupon;
    }

    @Column(name = "type", nullable = false)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "facevalue", nullable = false)
    public long getFacevalue() {
        return facevalue;
    }

    public void setFacevalue(long facevalue) {
        this.facevalue = facevalue;
    }

    @Column(name = "status", nullable = false)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}