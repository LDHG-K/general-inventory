package com.inventory.generalinventory.domain.gateways;

import com.inventory.generalinventory.domain.models.Category;

import java.util.List;

public interface ICategoryService { 
    List<Category> getAllCategories();

    Object addCategory(Category category);

    Object updateCategory(Category category);

    Object deleteCategory(Long id);
}
