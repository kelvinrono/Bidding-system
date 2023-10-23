package com.bidding.platform.models;

import com.bidding.platform.services.ProductStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "products")
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(name = "starting_price")
    private BigDecimal startingPrice;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    private String description;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;

}
