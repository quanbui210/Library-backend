package com.rest_api.fs14backend.checkout;

import com.rest_api.fs14backend.book.Book;
import com.rest_api.fs14backend.user.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "checkout")
@Data
@NoArgsConstructor
public class Checkout {
  @Id
  @GeneratedValue()
  @UuidGenerator
  private UUID id;

  @ManyToOne(fetch = FetchType.LAZY)
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
