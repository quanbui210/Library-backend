package com.rest_api.fs14backend.category;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rest_api.fs14backend.book.Book;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity(name = "category")
@Table(name = "category")
@Getter
@Setter
@NoArgsConstructor
public class Category {
  @Id
  @GeneratedValue
  @UuidGenerator
  private UUID id;

  @Column(unique = true, nullable = false)
  private String name;


  @OneToMany(mappedBy = "category")
  @JsonIgnoreProperties({"category", "author"})
  private List<Book> books;

  public Category(String name) {
    this.name = name;
  }
}
