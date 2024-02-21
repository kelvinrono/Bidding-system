package com.bidding.platform.services;

import com.bidding.platform.objects.CategoryObject;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashMap;


public interface CategoryService {
    HashMap saveCategory(CategoryObject categoryObject);
}
