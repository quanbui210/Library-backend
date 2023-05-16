package com.rest_api.fs14backend.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {
  @Autowired
  private CategoryService categoryService;

  @DeleteMapping("/{id}")
  public void deleteOne (@PathVariable UUID id) {
    categoryService.deleteOne(id);
  }
  @PostMapping
  public Category createOne(@RequestBody Category category) {
    return categoryService.createOne(category);
  }

  @GetMapping
  public List<Category> getCategories() {
    return categoryService.getCategories();
  }
}
