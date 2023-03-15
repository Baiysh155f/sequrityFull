package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * sequrityFull
 * 2023
 * macbook_pro
 **/
@Entity
@Table(name = "books")
@Setter
@Getter
@NoArgsConstructor
public class Book {
    @Id
    @SequenceGenerator(name = "book_id_gen",sequenceName = "book-id_seq",allocationSize = 1)
    @GeneratedValue(generator = "book_id_gen",strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String author;
    private int price;

    public Book(String name, String author, int price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }
}
