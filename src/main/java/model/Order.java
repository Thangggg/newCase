package model;

public class Order {
    int id;
    int userId;
    int totalPrice;
    String status;

    public Order() {
    }

    public Order(int id, int userId, int totalPrice, String status) {
        this.id = id;
        this.userId = userId;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public Order(int userId, int totalPrice, String status) {
        this.userId = userId;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public Order(int userId, int totalPrice) {
        this.userId = userId;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
