package com.rest_api.fs14backend.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class BookRequest {
  public UUID id;
  private long ISBN;
  private String title;
  private LocalDate publishedDate;
  private String description;
  private Book.Status status;
  private String publishers;
  private UUID authorId;
  private UUID categoryId;

}