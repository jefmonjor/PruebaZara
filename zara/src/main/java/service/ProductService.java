/**
 * ProductService.java 
 * 
 * @author Jefferson
 * @date   12 nov 2023 17:51:12
 *
 * Copyright (C) 2023 elAbogado
 *
 * All rights reserved.
 */
package service;

import java.util.List;

import dto.ProductDetailDTO;
import dto.SimilarProductDTO;

/**
 * @author Jefferson
 */
public interface ProductService {

    SimilarProductDTO getSimilarProducts(String productId);

    ProductDetailDTO getProductDetails(String id);

    List<ProductDetailDTO> getSimilarProductsForCustomer(String productId);
}
