package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.BookRequest;
import peaksoft.dto.BookResponse;
import peaksoft.entity.Book;
import peaksoft.service.BookService;

import java.util.List;

/**
 * sequrityFull
 * 2023
 * macbook_pro
 **/
@RestController
@RequestMapping("api/books")
@RequiredArgsConstructor
public class BookAPI {
    private final BookService bookService;

    @PreAuthorize("hasAnyAuthority('ADMIN','VENDOR','CUSTOMER')")
    @GetMapping
    public List<BookResponse> getAllBooks() {
        return bookService.getAllBook();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public BookResponse saveBook(@RequestBody BookRequest bookRequest) {
        return bookService.saveBook(bookRequest);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','VENDOR','CUSTOMER')")
    @GetMapping("/{id}")
    public BookResponse getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','VENDOR')")
    @PutMapping("/{id}/update")
    public BookResponse updateBook(@PathVariable Long id, @RequestBody BookRequest bookRequest) {
        return bookService.updateBook(id,bookRequest);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','VENDOR')")
    @DeleteMapping("/{id}/delete")
    public String deleteBookById(@PathVariable Long id) {
        return bookService.deleteBook(id);
    }
}
