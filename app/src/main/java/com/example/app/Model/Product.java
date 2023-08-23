package com.example.app.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID") // Specify the exact column name in the database
    private Long productId;
    @Column(name = "PRODUCT_COST")
    private double productCost;
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @Column(name = "PRODUCT_CATEGORY")
    private String productCategory;
    @Column(name = "PRODUCT_DESCRIPTION")
    private String productDescription;
    @Column(name = "CREATED_TIMESTAMP")
    private LocalDateTime createdTimestamp;

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productCost=" + productCost +
                ", productName='" + productName + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", createdTimestamp=" + createdTimestamp +
                '}';
    }
    // Other attributes and getters/setters
}





