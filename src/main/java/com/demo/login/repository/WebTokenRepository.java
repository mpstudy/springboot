package com.demo.login.repository;

import com.demo.login.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.transaction.Transactional;

@Transactional
public class WebTokenRepository implements PersistentTokenRepository{
  @Autowired
  UserRepository userRepository;

  /*@Override
  public void createNewToken(PersistentRememberMeToken token) {

  }

  @Override
  public void updateToken(String series, String tokenValue, Date lastUsed) {
  }

  @Override
  public PersistentRememberMeToken getTokenForSeries(String series) {
    return ...
  }

  @Override
  public void removeUserTokens(String username) {
  }
  */
}
