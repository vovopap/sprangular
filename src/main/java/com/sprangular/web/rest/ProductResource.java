package com.sprangular.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.sprangular.config.Constants;
import com.sprangular.domain.Product;
import com.sprangular.domain.User;
import com.sprangular.repository.ProductRepository;
import com.sprangular.security.AuthoritiesConstants;
import com.sprangular.service.ProductService;
import com.sprangular.service.dto.ProductDTO;
import com.sprangular.service.dto.UserDTO;
import com.sprangular.web.rest.util.HeaderUtil;
import com.sprangular.web.rest.util.PaginationUtil;
import com.sprangular.web.rest.vm.ManagedProductVm;
import com.sprangular.web.rest.vm.ManagedUserVM;
import io.github.jhipster.web.util.ResponseUtil;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * Created by ali on 5/17/17.
 */

@RestController
@RequestMapping("/api")

public class ProductResource {
    private final ProductService productService;
    private final ProductRepository productRepository;
    private static final String ENTITY_NAME = "productManagement";

    public ProductResource(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    @Timed
    public ResponseEntity<List<ProductDTO>> getAllProducts(@ApiParam Pageable pageable) {
        final Page<ProductDTO> page = productService.getAllProducts(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/products");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    @PostMapping("/create")
    @Timed
    public ResponseEntity createProduct(@RequestBody ManagedProductVm managedProductVm) {
        HttpHeaders textPlainHeaders = new HttpHeaders();
        textPlainHeaders.setContentType(MediaType.TEXT_PLAIN);

        return productRepository.findOneBypName(managedProductVm.getName().toLowerCase())
            .map(product -> new ResponseEntity<>("This product has already been inserted", textPlainHeaders, HttpStatus.BAD_REQUEST))
            .orElseGet(() -> {
                Product product =
                    productService.createProduct(managedProductVm.getName(), managedProductVm.getCategory(),
                        managedProductVm.getPrice(), managedProductVm.getImage(), managedProductVm.isActivated());
                return new ResponseEntity<>(HttpStatus.CREATED);
            });
    }

    @DeleteMapping("/delete")
    @Timed
    public ResponseEntity<Void> deleteUser(@RequestParam Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().headers(HeaderUtil.createAlert("A user is deleted with identifier " + 10, " ")).build();
    }

    @GetMapping("/product")
    @Timed
    public ResponseEntity<ProductDTO> updateUser(@RequestParam Long id) {

        Product existingProduct = productRepository.findOneById(id);

        Optional<ProductDTO> updatedUser = productService.findProduct(existingProduct);

        return ResponseUtil.wrapOrNotFound(updatedUser,
            HeaderUtil.createAlert("A user is updated with identifier " + existingProduct.getpName(), existingProduct.getCategory()));
    }

    @PutMapping("/update/{id}")
    @Timed
    @Secured(AuthoritiesConstants.ADMIN)
    public ResponseEntity<ProductDTO> updateUser(@PathVariable Long id, @Valid @RequestBody ManagedProductVm managedProductVm) {

        Optional<ProductDTO> updatedProduct = productService.updateProduct(managedProductVm);

        return ResponseUtil.wrapOrNotFound(updatedProduct,
            HeaderUtil.createAlert("A user is updated with identifier " + managedProductVm.getName(), managedProductVm.getImage().toString()));
    }

//    @PostMapping(value = "/product-image-upload")
//    public void uploadImage(@RequestPart(name = "uploadFile") MultipartFile uploadFile, HttpServletRequest request) {
//
//        if (!uploadFile.isEmpty()) {
//            try {
//                String uploadsDir = "../../webapp/content/uploaded";
//                String realPathtoUploads = request.getServletContext().getRealPath(uploadsDir);
//                if (!new File(realPathtoUploads).exists()) {
//                    new File(realPathtoUploads).mkdir();
//                }
//
//                String orgName = uploadFile.getOriginalFilename();
//                String filePath = realPathtoUploads + orgName;
//                File dest = new File(filePath);
//                uploadFile
//                uploadFile.transferTo(dest);
//
//                System.out.println("Hello");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
