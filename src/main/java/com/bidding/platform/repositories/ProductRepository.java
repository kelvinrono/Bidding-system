package com.bidding.platform.repositories;

import com.bidding.platform.models.Product;
import com.bidding.platform.services.ProductService;
import com.bidding.platform.services.ProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String name);
    List<Product> findByEndTimeBeforeAndStatusEquals(LocalDateTime time, ProductStatus status);
    Product findByEndTimeBefore(LocalDateTime time);
}
