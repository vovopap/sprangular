package com.sprangular.service.dto;

import com.sprangular.domain.Product;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.Arrays;

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

    private byte[] image;

    private boolean activated = false;

    public ProductDTO() {
        // Empty constructor needed for MapStruct.
    }

    public ProductDTO(Product product) {
        this(product.getId(), product.getpName(), product.getCategory(), product.getPrice(),
            product.isActivated(), product.getImage());
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

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public ProductDTO(Long id, String name, String category, Double price,
                      boolean activated, byte[] image) {

        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.activated = activated;
        this.image = image;
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

    public byte[] getImage() {
        return image;
    }

    public Double getPrice() {
        return price;
    }

    public boolean isActivated() {
        return activated;
    }


    @Override
    public String toString() {
        return "ProductDTO{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", category='" + category + '\'' +
            ", price=" + price +
            ", image=" + Arrays.toString(image) +
            ", activated=" + activated +
            '}';
    }
}
