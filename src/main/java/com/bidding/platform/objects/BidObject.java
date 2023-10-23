package com.bidding.platform.objects;

import com.bidding.platform.models.Product;
import com.bidding.platform.models.User;
import com.bidding.platform.services.BidStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class BidObject {

    private Long user;

    private Long product;
    private BigDecimal bidPrice;
    private String status;
}
