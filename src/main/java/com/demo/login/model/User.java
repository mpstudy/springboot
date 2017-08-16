package com.demo.login.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {
  private Long id;
  private String username;
  private String password;
  private String passwordConfirm;
  private String nickname;
  private int role;
  private String token;
  private Date expired;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Transient
  public String getPasswordConfirm() {
    return passwordConfirm;
  }

  public void setPasswordConfirm(String passwordConfirm) {
    this.passwordConfirm = passwordConfirm;
  }

  public int getRole() {
    return role;
  }

  public void setRole(int role) {
    this.role = role;
  }

  public String getNickname() { return nickname; }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getToken() { return token; }

  public void setToken(String token) {
    this.token = token;
  }

  public Date getExpired() { return expired; }

  public void setExpired(Date expired) {
    this.expired = expired;
  }
}
