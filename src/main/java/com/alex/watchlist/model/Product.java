package com.alex.watchlist.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import java.sql.Date;

@Entity
@Table(name = "watchlist")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "product_name")
    private String product_name;

    @Column(name = "product_url")
    private String url;

    @Column(name = "original_price")
    private Double original_price;

    @Column(name = "added_date")
    private Date added_date;

    public Product(String product_name, String product_url, Double original_price) {
        this.product_name = product_name;
        this.url = product_url;
        this.original_price = original_price;
        long millis = System.currentTimeMillis();
        this.added_date = new Date(millis);
    }

    public Product() {
        long millis = System.currentTimeMillis();
        this.added_date = new Date(millis);
    }

    public String getProductName() {
        return product_name;
    }
    public Date getAddedDate(){
        return added_date;
    }

    public String getProductUrl() {
        return url;
    }

    public Double getPrice() {
        return original_price;
    }

    public Integer getId() {
        return id;
    }

    public void setProductName(String product_name) {
        this.product_name = product_name;
    }

    public void setProductUrl(String product_url) {
        this.url = product_url;
    }

    public void setPrice(Double original_price) {
        this.original_price = original_price;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
