package com.sprangular.service;

import com.sprangular.config.Constants;
import com.sprangular.domain.Authority;
import com.sprangular.domain.Product;
import com.sprangular.domain.User;
import com.sprangular.repository.ProductRepository;
import com.sprangular.security.AuthoritiesConstants;
import com.sprangular.service.dto.ProductDTO;
import com.sprangular.service.dto.UserDTO;
import com.sprangular.service.util.RandomUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created by ali on 5/17/17.
 */
@Service
@Transactional
public class ProductService {
    private final ProductRepository productRepository;
    private final Logger log = LoggerFactory.getLogger(ProductService.class);

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(String name, String category, Double price,
                                 byte[] image, Boolean isActivated) {

        Product newProduct = new Product();
        newProduct.setpName(name);
        newProduct.setPrice(price);
        newProduct.setCategory(category);
        newProduct.setImage(image);
        newProduct.setActivated(isActivated);
        productRepository.save(newProduct);
        return newProduct;
    }

    public Product createProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setpName(productDTO.getName());
        product.setCategory(productDTO.getCategory());
        product.setPrice(product.getPrice());
        product.setImage(productDTO.getImage());
        product.setActivated(true);
        productRepository.save(product);
        log.debug("Created Information for Product: {}", product);
        return product;
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable).map(ProductDTO::new);
    }

    public void deleteProduct(Long id) {
        productRepository.delete(productRepository.findOneById(id));

    }

    public Optional<ProductDTO> findProduct(Product productDTO) {
        return Optional.of(productRepository
            .findOne(productDTO.getId()))
            .map(product -> {
                product.setId(product.getId());
                product.setpName(productDTO.getpName());
                product.setCategory(productDTO.getCategory());
                product.setImage(productDTO.getImage());
                product.setActivated(productDTO.isActivated());
                log.debug("Changed Information for User: {}", product);
                return product;
            })
            .map(ProductDTO::new);
    }

    public Optional<ProductDTO> updateProduct(ProductDTO productDTO) {
        return Optional.of(productRepository
            .findOne(productDTO.getId()))
            .map(product -> {
                product.setpName(productDTO.getName());
                product.setCategory(productDTO.getCategory());
                product.setPrice(productDTO.getPrice());
                product.setActivated(productDTO.isActivated());
                product.setImage(productDTO.getImage());
                log.debug("Changed Information for User: {}", product);
                return product;
            })
            .map(ProductDTO::new);
    }
}
