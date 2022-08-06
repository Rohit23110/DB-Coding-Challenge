package com.db.grad.javaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "trade")
public class Trade {

    @Id
    private int id;
    private int bookId;
    private int userId;
    private int counterpartyId;
    private int securityId;
    private int quantity;
    private String status;
    private int price;
    private boolean buySell;
    private Date tradeDate;
    private Date settlementDate;

    public Trade() {

    }

    public Trade(int id, int bookId, int userId, int counterpartyId, int securityId, int quantity, String status,
            int price, Boolean buySell, Date tradeDate,
            Date settlementDate) {
        this.id = id;
        this.bookId = bookId;
        this.userId = userId;
        this.counterpartyId = counterpartyId;
        this.securityId = securityId;
        this.quantity = quantity;
        this.status = status;
        this.price = price;
        this.buySell = buySell;
        this.tradeDate = tradeDate;
        this.settlementDate = settlementDate;

    }

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "bookId", nullable = false)
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Column(name = "userId", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "counterpartyId", nullable = false)
    public int getCounterpartyId() {
        return counterpartyId;
    }

    public void setCounterpartyId(int counterpartyId) {
        this.counterpartyId = counterpartyId;
    }

    @Column(name = "securityId", nullable = false)
    public int getSecurityId() {
        return securityId;
    }

    public void setSecurityId(int securityId) {
        this.securityId = securityId;
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

    @Column(name = "buySell", nullable = false)
    public boolean getBuySell() {
        return buySell;
    }

    public void setbuySell(boolean buySell) {
        this.buySell = buySell;
    }

    @Column(name = "tradeDate", nullable = false)
    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }

    @Column(name = "settlementDate", nullable = false)
    public Date getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }

}