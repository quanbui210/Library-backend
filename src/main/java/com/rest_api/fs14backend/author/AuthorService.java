package com.rest_api.fs14backend.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AuthorService {
  @Autowired
  private AuthorRepository authorRepository;
//  private final AuthorMapper authorMapper;
  public List<Author> getAllAuthors() {
    List<Author> authors = authorRepository.findAll();
//  return authorMapper.toAuthorDTOList(authors);
    return authors;
  }
  public Author getAuthorById (UUID id) {
    return authorRepository.findAuthorById(id);
  }
  public void addAuthor(Author newAuthor) {
    List<Author> authorList = authorRepository.findAll();
    for (Author author : authorList) {
      if (newAuthor.getName().equals(author.getName())) {
        throw new IllegalStateException("Author " + newAuthor.getName() +  " already exist");
      } else {
        authorRepository.save(newAuthor);
      }
    }
  }

}
