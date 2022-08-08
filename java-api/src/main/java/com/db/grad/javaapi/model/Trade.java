package com.db.grad.javaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "trade")
public class Trade {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
    private int bookid;
    private int userid;
    private int counterpartyid;
    private int securityid;
    private int quantity;
    private String status;
    private int price;
    private boolean buysell;
    private Date tradedate;
    private Date settlementdate;

    public Trade() {

    }

    public Trade(int id, int bookid, int userid, int counterpartyid, int securityid, int quantity, String status,
            int price, Boolean buysell, Date tradedate,
            Date settlementdate) {
        this.id = id;
        this.bookid = bookid;
        this.userid = userid;
        this.counterpartyid = counterpartyid;
        this.securityid = securityid;
        this.quantity = quantity;
        this.status = status;
        this.price = price;
        this.buysell = buysell;
        this.tradedate = tradedate;
        this.settlementdate = settlementdate;

    }

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "bookid", nullable = false)
    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    @Column(name = "userid", nullable = false)
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Column(name = "counterpartyid", nullable = false)
    public int getCounterpartyid() {
        return counterpartyid;
    }

    public void setCounterpartyid(int counterpartyid) {
        this.counterpartyid = counterpartyid;
    }

    @Column(name = "securityid", nullable = false)
    public int getSecurityid() {
        return securityid;
    }

    public void setSecurityid(int securityid) {
        this.securityid = securityid;
    }

    @Column(name = "quantity", nullable = false)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Column(name = "status", nullable = false)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "price", nullable = false)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Column(name = "buysell", nullable = false)
    public boolean getBuysell() {
        return buysell;
    }

    public void setBuysell(boolean buysell) {
        this.buysell = buysell;
    }

    @Column(name = "tradedate", nullable = false)
    public Date getTradedate() {
        return tradedate;
    }

    public void setTradedate(Date tradedate) {
        this.tradedate = tradedate;
    }

    @Column(name = "settlementdate", nullable = false)
    public Date getSettlementdate() {
        return settlementdate;
    }

    public void setSettlementdate(Date settlementdate) {
        this.settlementdate = settlementdate;
    }

}