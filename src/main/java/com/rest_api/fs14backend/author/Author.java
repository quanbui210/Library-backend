package com.rest_api.fs14backend.author;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rest_api.fs14backend.book.Book;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "author")
@Getter
@Setter
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
  @Column(nullable = true)
  private String imgUrl;

  @OneToMany(mappedBy = "author")
  @JsonIgnoreProperties({"category", "author"})
  private List<Book> books = new ArrayList<>();

  public Author(String name, String description, String imgUrl) {
    this.name = name;
    this.description = description;
    this.imgUrl = imgUrl;
  }

}

