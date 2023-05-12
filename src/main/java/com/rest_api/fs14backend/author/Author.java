package com.rest_api.fs14backend.author;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rest_api.fs14backend.book.Book;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "author")
@Data
@NoArgsConstructor
public class Author {
  @Id
  @GeneratedValue
  @UuidGenerator
  private UUID id;

  @Column(nullable = false, unique = true)
  private String name;

  @Column(nullable = true)
  private String description;

  @OneToMany(mappedBy = "author")
  @JsonIgnoreProperties("author")
  private List<Book> books = new ArrayList<>();

  public Author(String name, String description) {
    this.name = name;
    this.description = description;
  }

}

