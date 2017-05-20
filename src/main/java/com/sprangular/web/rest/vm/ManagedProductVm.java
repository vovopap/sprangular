package com.sprangular.web.rest.vm;

import com.sprangular.service.dto.ProductDTO;

import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.Set;

/**
 * Created by ali on 5/18/17.
 */
public class ManagedProductVm extends ProductDTO {

    public ManagedProductVm() {
        // Empty constructor needed for Jackson.
    }

    public ManagedProductVm(Long id, String name, String category, Double price, boolean activated, byte[] image) {
        super(id, name, category, price, activated, image);
    }

    @Override
    public String toString() {
        return "ManagedUserVM{" +
            "} " + super.toString();
    }
}
