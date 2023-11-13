/**
 * ProductDetailDTO.java 
 * 
 * @author Jefferson
 * @date   12 nov 2023 17:50:11
 *
 * Copyright (C) 2023 elAbogado
 *
 * All rights reserved.
 */
package dto;

import java.io.Serializable;

/**
 * @author Jefferson
 */
public class ProductDetailDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private Double price;
    private Boolean availability;

    public ProductDetailDTO() {
    }

    public ProductDetailDTO(String id, String name, Double price, Boolean availability) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.availability = availability;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }
}
