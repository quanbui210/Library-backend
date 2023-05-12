package com.rest_api.fs14backend.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {
  @Autowired
  private CategoryRepository categoryRepository;

  public Category createOne(Category category) {
    return categoryRepository.save(category);
  }
  public List<Category> getCategories () {
    return categoryRepository.findAll();
  }

  public Category findById(UUID categoryId) {
    return categoryRepository.findById(categoryId).orElse(null);
  }
}
