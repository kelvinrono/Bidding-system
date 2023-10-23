package com.bidding.platform.services;

import com.bidding.platform.models.Product;
import com.bidding.platform.objects.ProductObject;

import java.util.HashMap;
import java.util.List;

public interface ProductService {
    HashMap saveProduct(ProductObject productObject);
    List<Product> getAllProducts();

    Product getProduct(long id);
}
