package com.cg.model;

import com.cg.model.dto.BookDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    private int quantity;
    private int available = this.quantity;

    private boolean active = true;

    public BookDTO toBookDTO() {
        return new BookDTO()
                .setId(id)
                .setName(name)
                .setAuthor(author.toAuthorDTO())
                .setGenre(genre.toGenreDTO())
                .setPublisher(publisher.toPublisherDTO())
                .setQuantity(quantity)
                .setAvailable(available)
                .setActive(active);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author=" + author +
                ", genre=" + genre +
                ", publisher=" + publisher +
                ", quantity=" + quantity +
                ", available=" + available +
                ", active=" + active +
                '}';
    }
}
