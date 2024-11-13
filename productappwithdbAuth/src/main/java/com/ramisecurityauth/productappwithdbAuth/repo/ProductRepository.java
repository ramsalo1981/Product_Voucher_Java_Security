package com.ramisecurityauth.productappwithdbAuth.repo;

import com.ramisecurityauth.productappwithdbAuth.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
