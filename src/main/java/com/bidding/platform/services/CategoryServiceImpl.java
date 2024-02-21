package com.bidding.platform.services;

import com.bidding.platform.models.Category;
import com.bidding.platform.objects.CategoryObject;
import com.bidding.platform.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@AllArgsConstructor
@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;


    @Override
    public HashMap saveCategory(CategoryObject categoryObject) {
        HashMap<String, Object> response = new HashMap<>();
        try {
            Category newCategory = Category.builder()
                    .name(categoryObject.getName())
                    .build();
            categoryRepository.save(newCategory);
            log.info("...Category has been saved Successfully");
            response.put("message", "Category saved successfully");
            response.put("status", true);
        }
        catch (Exception e){
            e.printStackTrace();
            log.error("An error occurred:::"+e.getMessage());
            response.put("message", "Something went wrong");
            response.put("status", false);
        }

        return response;
    }
}
