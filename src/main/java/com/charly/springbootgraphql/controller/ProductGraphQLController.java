package com.charly.springbootgraphql.controller;

import com.charly.springbootgraphql.dto.ProductInput;
import com.charly.springbootgraphql.entity.Product;
import com.charly.springbootgraphql.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class ProductGraphQLController {

    private final ProductService productService;

    @QueryMapping
    public Product getProductById(@Argument Long id) {
        return productService.getProductById(id);
    }

    @QueryMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @MutationMapping
    public Product createProduct(@Argument ProductInput input) {
        return productService.createProduct(input);
    }

    @MutationMapping
    public Product updateProduct(@Argument Long id, @Argument ProductInput input) {
        return productService.updateProduct(id, input);
    }

    @MutationMapping
    public Boolean deleteProduct(@Argument Long id) {
        productService.deleteProduct(id);
        return true;
    }
}
