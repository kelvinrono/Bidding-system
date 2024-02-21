package com.bidding.platform.repositories;

import com.bidding.platform.models.Bid;
import com.bidding.platform.models.Product;
import com.bidding.platform.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BidRepository extends JpaRepository<Bid, Long> {
    Bid findByProductAndUser(Product product, User user);

    List<Bid> findAllByUser_Id(long id);
}
