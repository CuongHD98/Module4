package com.example.shopshoe.model;

import javax.persistence.*;

@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Order order;
    @ManyToOne
    private ProductDetail productDetail;
    private int quantity_buy;

    public OrderDetail() {
    }

    public OrderDetail(int id, Order order, ProductDetail productDetail, int quantity_buy) {
        this.id = id;
        this.order = order;
        this.productDetail = productDetail;
        this.quantity_buy = quantity_buy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public ProductDetail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }

    public int getQuantity_buy() {
        return quantity_buy;
    }

    public void setQuantity_buy(int quantity_buy) {
        this.quantity_buy = quantity_buy;
    }
}
