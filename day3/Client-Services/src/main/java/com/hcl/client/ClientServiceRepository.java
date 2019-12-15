package com.hcl.client;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientServiceRepository extends CrudRepository<Login, Integer>{
List<Login> findByUsername(String username);
}
