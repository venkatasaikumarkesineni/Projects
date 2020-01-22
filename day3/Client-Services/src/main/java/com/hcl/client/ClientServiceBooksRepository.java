package com.hcl.client;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClientServiceBooksRepository extends JpaRepository<Books, Integer>{
	List<Books> findByNo(int no);
	List<Books> findByBookid(String bookid);
	@Transactional
	@Modifying
	@Query(value = "UPDATE Books b SET b.availablebooks = :availablebooks WHERE b.id = :no")
	int UpdateBooks(@Param("no") int no, @Param("availablebooks") int availablebooks);
	
	
	@Transactional
	@Modifying
    @Query(value = "UPDATE Books e SET e.availablebooks = :availablebooks WHERE e.bookid = :bookid")
	int AddReturnBooksToExisting(@Param("bookid") String bookid,@Param("availablebooks") int availablebooks);
}
