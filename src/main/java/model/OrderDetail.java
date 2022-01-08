package model;

import java.sql.Date;

public class OrderDetail {
    int id;
    int dateNumber;
    int idProduct;
    int orderId;
    Date dateStart;
    Date dateEnd;

    public OrderDetail(int id, int dateNumber, int idProduct, int orderId, Date dateStart, Date dateEnd) {
        this.id = id;
        this.dateNumber = dateNumber;
        this.idProduct = idProduct;
        this.orderId = orderId;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public OrderDetail() {
    }

    public OrderDetail(int dateNumber, int idProduct, int orderId, Date dateStart) {
        this.dateNumber = dateNumber;
        this.idProduct = idProduct;
        this.orderId = orderId;
        this.dateStart = dateStart;
    }

    public OrderDetail(int dateNumber, int idProduct, int orderId) {
        this.dateNumber = dateNumber;
        this.idProduct = idProduct;
        this.orderId = orderId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDateNumber() {
        return dateNumber;
    }

    public void setDateNumber(int dateNumber) {
        this.dateNumber = dateNumber;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }
}
