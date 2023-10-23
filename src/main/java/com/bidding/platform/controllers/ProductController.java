package com.bidding.platform.controllers;

import com.bidding.platform.models.Product;
import com.bidding.platform.objects.ProductObject;
import com.bidding.platform.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/product")
public class ProductController {
    private final ProductService productService;
    @PostMapping("/save-product")
    public HashMap saveProduct(@RequestBody ProductObject productObject){
        return productService.saveProduct(productObject);
    }
    @GetMapping("/get-all-products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/get-product/{id}")
    public Product getProduct(@PathVariable("id") long id){
        return productService.getProduct(id);
    }
}
