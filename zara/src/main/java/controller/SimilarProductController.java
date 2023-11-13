/**
 * SimilarProductController.java 
 * 
 * @author Jefferson
 * @date   12 nov 2023 17:50:40
 *
 * Copyright (C) 2023 elAbogado
 *
 * All rights reserved.
 */
package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dto.ProductDetailDTO;
import service.ProductServiceImpl;

/**
 * @author Jefferson
 */
@RestController
@RequestMapping("/product")
public class SimilarProductController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/{productId}/similar")
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<List<ProductDetailDTO>> getSimilarProducts(@PathVariable String productId) {
        List<ProductDetailDTO> similarProducts = productService.getSimilarProductsForCustomer(productId);

        if (similarProducts == null || similarProducts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(similarProducts, HttpStatus.OK);
    }

}
