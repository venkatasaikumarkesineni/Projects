package com.hcl.client;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Students, Integer> {
	List<Students> findByStdid(int stdid);

}
