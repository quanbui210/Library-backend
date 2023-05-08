package com.rest_api.fs14backend.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
  Optional<Book> findBookByISBN(Long isbn);
}
