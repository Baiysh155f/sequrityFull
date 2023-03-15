package peaksoft.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.dto.BookResponse;
import peaksoft.entity.Book;

import java.util.List;

/**
 * sequrityFull
 * 2023
 * macbook_pro
 **/
@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book,Long> {
    @Query("select new peaksoft.dto.BookResponse(b.id,b.author,b.name,b.price) from Book b" )
    List<BookResponse> getAllBook();
}
