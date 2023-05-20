package com.rest_api.fs14backend.checkout;

import com.rest_api.fs14backend.book.Book;
import com.rest_api.fs14backend.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "checkout")
@Getter
@Setter
@NoArgsConstructor
public class Checkout {
  @Id
  @GeneratedValue
  @UuidGenerator
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "book_id")
  private Book book;
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
  @Column(nullable = true)
  private LocalDate borrowedDate;
  @Column(nullable = true)
  private LocalDate returnedDate;
  @Column(nullable = true)
  private boolean isReturned;
}
