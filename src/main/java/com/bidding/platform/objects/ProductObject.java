package com.bidding.platform.objects;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class ProductObject {
    private Long id;

    private String name;

    private BigDecimal startingPrice;

    private LocalDateTime endTime;

    private String description;
}
