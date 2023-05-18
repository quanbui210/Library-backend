package com.rest_api.fs14backend.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    authorRepository.save(newAuthor);
  }
  public void deleteAuthor (UUID id) {
    authorRepository.deleteById(id);
  }

  @Transactional
  public Author editAuthor (UUID id, Author editedAuthor) {
    Author authorToEdit = authorRepository.findAuthorById(id);
    authorToEdit.setDescription(editedAuthor.getDescription());
    authorToEdit.setName(editedAuthor.getName());
    authorToEdit.setImgUrl(editedAuthor.getImgUrl());
    return authorToEdit;
  }
}
