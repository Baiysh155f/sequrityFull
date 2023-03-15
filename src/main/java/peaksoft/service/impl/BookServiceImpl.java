package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import peaksoft.dto.BookRequest;
import peaksoft.dto.BookResponse;
import peaksoft.entity.Book;
import peaksoft.repository.BookRepository;
import peaksoft.service.BookService;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * sequrityFull
 * 2023
 * macbook_pro
 **/
@Service
@Transactional
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookResponse saveBook(BookRequest bookRequest) {
        Book book = new Book();
        book.setPrice(bookRequest.price());
        book.setName(bookRequest.name());
        book.setAuthor(bookRequest.author());
        bookRepository.save(book);
        return new BookResponse(book.getId(),book.getAuthor(),book.getName(),book.getPrice());
    }

    @Override
    public List<BookResponse> getAllBook() {
        return bookRepository.getAllBook();
    }

    @Override
    public BookResponse getBookById(Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new NoSuchElementException("nor found my exception!!!"));
        return new BookResponse(book.getId(),book.getAuthor(),book.getName(),book.getPrice());
    }

    @Override
    public BookResponse updateBook(Long id, BookRequest bookRequest) {
        Book book1 = bookRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("nor found my exception!!!"));
        book1.setName(bookRequest.name());
        book1.setName(bookRequest.author());
        book1.setPrice(bookRequest.price());
        bookRepository.save(book1);
        return new BookResponse(book1.getId(),book1.getAuthor(),book1.getName(),book1.getPrice());
    }

    @Override
    public String deleteBook(Long id) {
       bookRepository.deleteById(id);
       return "with id = "+id+" deleted...";
    }
}
