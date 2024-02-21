package com.bidding.platform.controllers;

import com.bidding.platform.models.Bid;
import com.bidding.platform.objects.BidObject;
import com.bidding.platform.services.BidService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/v1/bids")
@AllArgsConstructor
public class BidController {
    private final BidService bidService;

    @PostMapping("/place-bid")
    public HashMap placeBid(@RequestBody BidObject bidObject){
        return bidService.placeBid(bidObject);
    }
    @PatchMapping("/cancel-bid/{id}")
    public HashMap cancelBid(@PathVariable("id") long id){
        return bidService.cancelBid(id);
    }
    @GetMapping("/get-my-bids/{id}")
    public HashMap getmyBids(@PathVariable("id") long id){
        return bidService.getMyBids(id);
    }
}
