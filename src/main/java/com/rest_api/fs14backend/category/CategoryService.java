package com.rest_api.fs14backend.category;

import com.rest_api.fs14backend.book.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {
  @Autowired
  private CategoryRepository categoryRepository;

  @Autowired
  private BookMapper bookMapper;

  public Category createOne(Category category) {
    return categoryRepository.save(category);
  }
  public List<Category> getCategories () {
    return categoryRepository.findAll();
  }
  public void deleteOne (UUID id) {
    categoryRepository.deleteById(id);
  }
  public Category findById(UUID categoryId) {
    return categoryRepository.findById(categoryId).orElse(null);
  }
}
