package com.alex.watchlist.model;

import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name = "users_watchlist")
public class Watchlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "added_on")
    private Date added_date;

    @Column(name = "added_price")
    private Double original_price;

    public Watchlist(Integer user_id, Integer product_id, Double original_price, Date added_date) {
        this.userId = user_id;
        this.productId = product_id;
        this.original_price = original_price;
        this.added_date = added_date;
    }

    public Watchlist() {
        long millis = System.currentTimeMillis();
        this.added_date = new Date(millis);
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public Double getPrice() {
        return original_price;
    }

    public Integer getId() {
        return id;
    }

    public void setUserId(Integer user_id) {
        this.userId = user_id;
    }

    public void setProductId(Integer product_id) {
        this.productId = product_id;
    }

    public void setPrice(Double original_price) {
        this.original_price = original_price;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
