package com.hcl.client;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientServiceRepository extends CrudRepository<Login, Integer>{
Optional<Login> findByUsername(String username);
}
