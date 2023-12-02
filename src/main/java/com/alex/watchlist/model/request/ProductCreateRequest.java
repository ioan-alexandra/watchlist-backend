package com.alex.watchlist.model.request;
import lombok.Data;

import java.sql.Date;

@Data
public class ProductCreateRequest {
    private String product_name;
    private String product_url;
    private Double original_price;

    public String getProductName() {
        return product_name;
    }

    public String getProductUrl() {
        return product_url;
    }

    public Double getPrice() {
        return original_price;
    }
}
