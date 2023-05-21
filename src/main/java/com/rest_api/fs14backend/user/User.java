package com.rest_api.fs14backend.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rest_api.fs14backend.checkout.Checkout;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity(name = "user")
@Table(name = "customer")
@Data
@NoArgsConstructor
public class User {
  @Id
  @GeneratedValue
  @UuidGenerator
  private UUID id;

  @Column(unique = true)
  private String username;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String password;

  @Column
  @OneToMany
  private List<Checkout> checkoutList;

  public User(String username, String password){
    this.username = username;
    this.password = password;
  }
}
