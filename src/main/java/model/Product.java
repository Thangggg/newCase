package model;

import java.sql.Date;

public class Product {
    int id;
    String nameProduct;
    Date dateUp;
    String status;
    String description;
    int price;
    int idCategory;
    int idPosition;
    String img;
    int quantity;
    int totalPrice;
    int dayNumber;

    public Product() {
    }

    public Product(int id, String nameProduct, int price, String img, int totalPrice, int dayNumber) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = price;
        this.img = img;
        this.totalPrice = totalPrice;
        this.dayNumber = dayNumber;
    }

    public Product(int id, String nameProduct, Date dateUp, String status, String description, int price, int idCategory, int idPosition, String img, int quantity) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.dateUp = dateUp;
        this.status = status;
        this.description = description;
        this.price = price;
        this.idCategory = idCategory;
        this.idPosition = idPosition;
        this.img = img;
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Date getDateUp() {
        return dateUp;
    }

    public void setDateUp(Date dateUp) {
        this.dateUp = dateUp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
