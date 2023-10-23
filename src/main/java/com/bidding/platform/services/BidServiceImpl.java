package com.bidding.platform.services;

import com.bidding.platform.models.Bid;
import com.bidding.platform.models.Product;
import com.bidding.platform.models.User;
import com.bidding.platform.objects.BidObject;
import com.bidding.platform.repositories.BidRepository;
import com.bidding.platform.repositories.ProductRepository;
import com.bidding.platform.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.swing.table.TableRowSorter;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BidServiceImpl implements BidService {
    private final BidRepository bidRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;


    @Override
    public HashMap placeBid(BidObject bidObject) {
        HashMap<String, String> response = new HashMap<>();
        try {
            User user = userRepository.findById(bidObject.getUser()).orElseThrow(()-> new IllegalArgumentException("User does not exist"));
            Product product = productRepository.findById(bidObject.getProduct()).orElseThrow(()-> new IllegalArgumentException("Product does not exist"));
            Bid existingBid = bidRepository.findByProductAndUser(product, user);
//            Product expiredBid = productRepository.fin
            if(existingBid==null){
                Bid newBid = Bid.builder()
                        .bidPrice(bidObject.getBidPrice())
                        .status(BidStatus.ACTIVE)
                        .bidPrice(bidObject.getBidPrice())
                        .product(product)
                        .user(user)
                        .build();
                bidRepository.save(newBid);
                response.put("message", "bid placed successfully. You will be notified on your status when the bid is closed!");
                response.put("status", "200");
            }
            else {
                    response.put("message", "You have already placed this bid");
            }
        }catch (Exception e){
            e.printStackTrace();
            response.put("Message", "Ooops! Something went wrong!");
        }
        return response;
    }

    @Override
    public List<Bid> getMyBids(long id) {
        try {
            return bidRepository.findByUser_Id(id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Bid> getAllBids() {
        try {
            return bidRepository.findAll();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public HashMap cancelBid(long id) {
        HashMap<String, String> response = new HashMap<>();
        try {
            Optional<Bid> existingBid = bidRepository.findById(id);
            existingBid.ifPresent(bid -> bid.setStatus(BidStatus.CANCELLED));
            bidRepository.save(existingBid.get());
            response.put("message", "You have successfully cancelled this bid");
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public HashMap bidAgain(BidObject bidObject) {
        HashMap<String, String> response = new HashMap<>();

        try {
            User user = userRepository.findById(bidObject.getUser()).orElseThrow(()-> new IllegalArgumentException("User does not exist"));
            Product product = productRepository.findById(bidObject.getUser()).orElseThrow(()-> new IllegalArgumentException("Product does not exist"));

            Bid existingBid = bidRepository.findByProductAndUser(product, user);

            if(existingBid!=null){
                existingBid.setBidPrice(bidObject.getBidPrice());
                response.put("message", "You have successfully placed a bid");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            response.put("message", "Oops! Something went wrong");
        }
        return response;

    }

    @Transactional
    public void closeExpiredBids(){
        System.out.println("SCHEDULER RUNNING");
     List<Product> products = productRepository.findByEndTimeBeforeAndStatusEquals(LocalDateTime.now(), ProductStatus.OPEN);
     for (Product product: products){
         product.setStatus(ProductStatus.CLOSED);
         productRepository.save(product);
     }
    }

    @Scheduled(fixedRate = 5000)
    public void scheduleCloseExpiredBids(){
        closeExpiredBids();
    }
}
