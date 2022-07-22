package com.example.shopbanhang.model;

import java.math.BigDecimal;
import java.util.List;

public class Product {
    private int id;
    private String type;
    private String name;
    private String gender;
    private String price;
    private double rating;
    private int ratingCounter;
    private String brand;
    private String description;
    private String color;
    private String specification;
    private String size;
    private String image;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public BigDecimal getPrice() {
        double price = Double.parseDouble(this.price.replace("$", ""));
        return BigDecimal.valueOf(price);
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public BigDecimal getRating() {
        return BigDecimal.valueOf(rating);
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getRatingCounter() {
        return ratingCounter;
    }

    public void setRatingCounter(int ratingCounter) {
        this.ratingCounter = ratingCounter;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", price='" + price + '\'' +
                ", rating='" + rating + '\'' +
                ", brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", color='" + color + '\'' +
                ", specification='" + specification + '\'' +
                ", size='" + size + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
