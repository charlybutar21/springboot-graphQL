package com.charly.springbootgraphql.service;

import com.charly.springbootgraphql.dto.ProductInput;
import com.charly.springbootgraphql.entity.Product;
import com.charly.springbootgraphql.exception.ResourceNotFoundException;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductInput input);
    Product updateProduct(Long id, ProductInput input);
    Product getProductById(Long id) throws ResourceNotFoundException;
    List<Product> getAllProducts();
    void deleteProduct(Long id);
}
