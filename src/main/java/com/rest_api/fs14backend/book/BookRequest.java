package com.rest_api.fs14backend.book;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class BookRequest {
  private String title;
  private String description;
  private UUID authorId;
  private UUID categoryId;

}