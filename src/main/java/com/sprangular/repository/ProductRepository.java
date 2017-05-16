package com.sprangular.repository;

import com.sprangular.domain.Product;
import com.sprangular.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;


public interface ProductRepository extends JpaRepository<Product, Long> {
    /*  *//* Optional<Product> findOneByActivationKey(String activationKey);
*/
    List<Product> findAllByActivatedIsFalseAndCreatedDateBefore(Instant dateTime);

    Optional<User> findOneByPrice(Double price);


/*
    Optional<Product> findOneByCategory(String category);
*/
}
