/**
 * SimilarProductDTO.java 
 * 
 * @author Jefferson
 * @date   12 nov 2023 17:49:37
 *
 * Copyright (C) 2023 elAbogado
 *
 * All rights reserved.
 */
package dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author Jefferson
 */
public class SimilarProductDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<String> similarProducts;

    public SimilarProductDTO() {
    }

    public SimilarProductDTO(List<String> similarProducts) {
        this.similarProducts = similarProducts;
    }

    public List<String> getSimilarProducts() {
        return similarProducts;
    }

    public void setSimilarProducts(List<String> similarProducts) {
        this.similarProducts = similarProducts;
    }
}
