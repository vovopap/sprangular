package com.sprangular.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.sprangular.service.dto.UserDTO;
import com.sprangular.web.rest.util.PaginationUtil;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ali on 5/17/17.
 */

@RestController
@RequestMapping("/api")
public class ProductResource {


    private final ProductService productService;

    @GetMapping("/products")
    @Timed
    public ResponseEntity<List<UserDTO>> getAllProducts(@ApiParam Pageable pageable) {
        final Page<UserDTO> page = userService.getAllManagedUsers(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/users");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

}
