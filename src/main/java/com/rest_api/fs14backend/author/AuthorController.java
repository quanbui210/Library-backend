package com.rest_api.fs14backend.author;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/authors")
public class AuthorController {
  @Autowired
  private final AuthorService authorService;

  public AuthorController(AuthorService authorService) {
    this.authorService = authorService;
  }

  @GetMapping
  public List<Author> getAuthors () {
    return authorService.getAllAuthors();
  }

  @GetMapping("/{id}")
  public Author getAuthorById(@PathVariable  UUID id) {
    return authorService.getAuthorById(id);
  }

  @PostMapping
  public void addAuthor(@RequestBody Author author) {
    authorService.addAuthor(author);
  }

  @DeleteMapping("/{id}")
  public void deleteAuthor (@PathVariable UUID id) {
    authorService.deleteAuthor(id);
  }
}
