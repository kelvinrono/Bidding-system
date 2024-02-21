package com.bidding.platform.controllers;

import com.bidding.platform.objects.CategoryObject;
import com.bidding.platform.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/category")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/save-category")
    public HashMap saveCategory(@RequestBody CategoryObject categoryObject){
        return categoryService.saveCategory(categoryObject);
    }
}
