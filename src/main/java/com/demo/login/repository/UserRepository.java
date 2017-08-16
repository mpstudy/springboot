package com.demo.login.repository;

import com.demo.login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
  @Query("SELECT u FROM User u WHERE username = :username")
  User findByUsername(@Param("username") String username);

  @Modifying
  @Transactional
  @Query(value = "UPDATE User u SET u.password = :password WHERE u.username = :username")
  void updatePassword(@Param("password") String password, @Param("username") String username);

  @Modifying
  @Transactional
  @Query(value = "UPDATE User u SET u.token = :token, u.expired = DATE_ADD(NOW(), INTERVAL 1 HOUR) WHERE u.username = :username", nativeQuery = true)
  void updateToken(@Param("token") String token, @Param("username") String username);
}
