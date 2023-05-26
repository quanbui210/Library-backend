package com.rest_api.fs14backend.book;

import com.rest_api.fs14backend.author.Author;
import com.rest_api.fs14backend.category.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
public class Book {
  @Id
  @Column(name = "id")
  @UuidGenerator
  private UUID id;

  @Column(unique = true)
  private long ISBN;

  @Column(nullable = true)
  private String title;

  @Column(nullable = true)
  private LocalDate publishedDate;

  @Column(nullable = true)
  private String description;

  @Enumerated(EnumType.STRING)
  private Status status;

  @Column(nullable = true)
  private String publishers;

  @Column(nullable = true)
  private String imageUrl;

  @ManyToOne(optional = true)
  @JoinColumn(name = "author_id")
  private Author author;

  @Column
  private int quantity;
  @ManyToOne(optional = true)
  @JoinColumn(name = "category_id")
  private Category category;

  public Book(long ISBN,
              String title,
              LocalDate publishedDate,
              String description,
              Status status,
              String publishers,
              Category category,
              Author author,
              String imageUrl
  ) {
    this.ISBN = ISBN;
    this.title = title;
    this.publishedDate = publishedDate;
    this.description = description;
    this.status = status;
    this.publishers = publishers;
    this.category = category;
    this.author = author;
    this.imageUrl = imageUrl;
    this.quantity = quantity;
  }

  public enum Status {
    BORROWED,
    AVAILABLE
  }
}


