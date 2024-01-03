package com.yeonjidev.mallapi.repository;

import com.yeonjidev.mallapi.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
