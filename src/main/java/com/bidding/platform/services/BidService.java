package com.bidding.platform.services;

import com.bidding.platform.models.Bid;
import com.bidding.platform.objects.BidObject;

import java.util.HashMap;
import java.util.List;

public interface BidService {
    HashMap placeBid(BidObject bidObject);
    List<Bid> getMyBids(long id);
    List<Bid> getAllBids();
    HashMap cancelBid(long id);
    HashMap bidAgain(BidObject bidObject);
}
