package com.charly.springbootgraphql.service.impl;

import com.charly.springbootgraphql.dto.ProductInput;
import com.charly.springbootgraphql.entity.Product;
import com.charly.springbootgraphql.exception.ResourceNotFoundException;
import com.charly.springbootgraphql.repository.ProductRepository;
import com.charly.springbootgraphql.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    @Override
    public Product createProduct(ProductInput input) {
        Product product = new Product();
        product.setName(input.getName());
        product.setDescription(input.getDescription());
        product.setPrice(input.getPrice());
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, ProductInput input) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        product.setName(input.getName());
        product.setDescription(input.getDescription());
        product.setPrice(input.getPrice());
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) throws ResourceNotFoundException {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product not found");
        }
        productRepository.deleteById(id);
    }
}
