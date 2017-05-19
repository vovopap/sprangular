package com.sprangular.service.dto;

import com.sprangular.domain.Product;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

/**
 * Created by ali on 5/17/17.
 */
public class ProductDTO {
    private Long id;

    @Size(max = 50)
    private String name;

    @Size(max = 100)
    private String category;
    @NotNull
    private Double price;

    @Size(max = 256)
    private String imageUrl;

    private boolean activated = false;

    public ProductDTO() {
        // Empty constructor needed for MapStruct.
    }

    public ProductDTO(Product product) {
        this(product.getId(), product.getpName(), product.getCategory(), product.getPrice(),
            product.isActivated(), product.getImageUrl());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public ProductDTO(Long id, String name, String category, Double price,
                      boolean activated, String imageUrl) {

        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.activated = activated;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Double getPrice() {
        return price;
    }

    public boolean isActivated() {
        return activated;
    }



    @Override
    public String toString() {
        return "UserDTO{" +
            "Name='" + name + '\'' +
            ", Category ='" + category + '\'' +
            ", Price ='" + price + '\'' +
            ", imageUrl='" + imageUrl + '\'' +
            ", activated=" + activated + "}";
    }
}
