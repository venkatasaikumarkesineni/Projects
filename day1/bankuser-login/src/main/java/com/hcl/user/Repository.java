package com.hcl.user;

import org.springframework.data.repository.CrudRepository;

@org.springframework.stereotype.Repository
public interface Repository extends CrudRepository<User, Integer>{
  public User getUserByuser(String user);
}
