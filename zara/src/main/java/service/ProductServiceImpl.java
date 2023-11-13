/**
 * ProductServiceImpl.java 
 * 
 * @author Jefferson
 * @date   12 nov 2023 17:50:59
 *
 * Copyright (C) 2023 elAbogado
 *
 * All rights reserved.
 */
package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dto.ProductDetailDTO;
import dto.SimilarProductDTO;

/**
 * @author Jefferson
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private RestTemplate restTemplate;

    private final String similarIdsEndpoint;
    private final String productDetailEndpoint;

    public ProductServiceImpl(
            RestTemplate restTemplate,
            @Value("${similars.api.url}") String similarIdsEndpoint,
            @Value("${product.api.url}") String productDetailEndpoint) {
        this.restTemplate = restTemplate;
        this.similarIdsEndpoint = similarIdsEndpoint;
        this.productDetailEndpoint = productDetailEndpoint;
    }

    @Override
    public SimilarProductDTO getSimilarProducts(String productId) {
        ResponseEntity<List<String>> response = restTemplate.exchange(similarIdsEndpoint, HttpMethod.GET, null,
            new ParameterizedTypeReference<List<String>>() {}, productId);

        List<String> similarProductIds = response.getBody();

        SimilarProductDTO similarProductDTO = new SimilarProductDTO(similarProductIds);
        return similarProductDTO;
    }

    @Override
    public ProductDetailDTO getProductDetails(String id) {
        ResponseEntity<ProductDetailDTO> response = restTemplate.getForEntity(productDetailEndpoint, ProductDetailDTO.class,
            id);

        return response.getBody();
    }

    @Override
    public List<ProductDetailDTO> getSimilarProductsForCustomer(String productId) {
        SimilarProductDTO similarProductDTO = getSimilarProducts(productId);
        List<String> similarProductIds = similarProductDTO.getSimilarProducts();

        List<ProductDetailDTO> similarProducts = new ArrayList<>();

        for (String id : similarProductIds) {
            ProductDetailDTO productDetailDTO = getProductDetails(id);
            similarProducts.add(productDetailDTO);
        }

        return similarProducts;
    }

}
