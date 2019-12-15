package com.hcl.client;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public interface BooksHistoryRepository extends JpaRepository<BooksHistory, Integer> {
	List<BooksHistory> findByStdid(int stdid);
	@Async
	@Query("SELECT b FROM BooksHistory b WHERE b.stdid=:stdid and b.bookid=:bookid")
    Optional<BooksHistory> findByBookidStdid(int stdid, String bookid);
	@Async
	@Transactional
	@Modifying
	@Query("delete from BooksHistory b WHERE b.stdid=:stdid and b.bookid=:bookid")
	public void deleteOneByOne(@Param("stdid")int stdid,@Param("bookid")String bookid);
	
	
}
