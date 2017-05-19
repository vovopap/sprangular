package com.sprangular.repository;

import com.sprangular.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;


public interface ProductRepository extends JpaRepository<Product, Long> {
    /*  *//* Optional<Product> findOneByActivationKey(String activationKey);
*/
    List<Product> findAllByActivatedIsFalse(Instant dateTime);

    Page<Product> findAll(Pageable pageable);

    Optional<Product> findOneBypName(String name);

    Product findOneById(Long id);


/*
    Optional<Product> findOneByCategory(String category);
*/
}
