package com.rest_api.fs14backend.book;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface BookMapper {
  @Mapping(source = "book.author.name", target = "authorName")
  @Mapping(source = "book.category.name", target = "categoryName")
  @Mapping(source = "book.category.id", target = "categoryId")
  @Mapping(source = "book.author.id", target = "authorId")
  BookResponse toBookResponse(Book book);

  @Mapping(source = "book.author.name", target = "authorName")
  @Mapping(source = "book.category.name", target = "categoryName")
  @Mapping(source = "book.category.id", target = "categoryId")
  @Mapping(source = "book.author.id", target = "authorId")
  List<BookResponse> toListBookResponse(List<Book> bookList);

  Book toBookEntity(BookRequest bookRequest);
}