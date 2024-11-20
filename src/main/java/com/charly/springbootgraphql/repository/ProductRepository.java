package com.charly.springbootgraphql.repository;

import com.charly.springbootgraphql.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
