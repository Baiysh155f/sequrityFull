package peaksoft.service;

import peaksoft.dto.BookRequest;
import peaksoft.dto.BookResponse;
import peaksoft.entity.Book;

import java.util.List;

/**
 * sequrityFull
 * 2023
 * macbook_pro
 **/
public interface BookService {
    BookResponse saveBook(BookRequest request);
    List<BookResponse> getAllBook();
    BookResponse getBookById(Long bookId);
    BookResponse updateBook(Long id, BookRequest bookRequest);

    String deleteBook(Long id);
}
