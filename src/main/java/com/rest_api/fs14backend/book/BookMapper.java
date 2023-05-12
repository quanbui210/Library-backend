package com.rest_api.fs14backend.book;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
  @Mapping(source = "book.author.name", target = "authorName")
  @Mapping(source = "book.category.name", target = "categoryName")
  BookResponse toBookResponse(Book book);

  @Mapping(source = "book.author.name", target = "authorName")
  @Mapping(source = "book.category.name", target = "categoryName")
  List<BookResponse> toListBookResponse(List<Book> bookList);

  Book toBookEntity(BookRequest bookRequest);
}