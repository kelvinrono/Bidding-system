package com.bidding.platform.services;

import com.bidding.platform.models.Product;
import com.bidding.platform.objects.ProductObject;
import com.bidding.platform.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    @Override
    public HashMap saveProduct(ProductObject productObject) {
        HashMap<String, String> response = new HashMap<>();
        try {
            Product existingProduct = productRepository.findByName(productObject.getName());
            if (existingProduct==null){
                Product newProduct = Product.builder()
                        .name(productObject.getName())
                        .endTime(productObject.getEndTime())
                        .description(productObject.getDescription())
                        .startingPrice(productObject.getStartingPrice())
                        .status(ProductStatus.OPEN)
                        .build();
                productRepository.save(newProduct);
                log.info("Product saved successfully....");
                response.put("message", "Product has been saved successfully");
                response.put("status", "200");
            }
            else {
                response.put("message", "Product with that name already exists");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return response;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(long id) {
        Optional<Product> existingProduct = productRepository.findById(id);
        return existingProduct.orElseThrow(()-> new IllegalArgumentException("User does not exist!"));
    }
}
