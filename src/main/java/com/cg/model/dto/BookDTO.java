package com.cg.model.dto;

import com.cg.model.Author;
import com.cg.model.Book;
import com.cg.model.Genre;
import com.cg.model.Publisher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class BookDTO {

    private Long id;

    @NotBlank(message = "Book name must be required")
    private String name;

    private AuthorDTO author;

    private GenreDTO genre;

    private PublisherDTO publisher;

    private int quantity;
    private int available;

    private boolean active;

    public BookDTO(Long id, String name, Author author, Genre genre, Publisher publisher, int quantity, int available, boolean active) {
        this.id = id;
        this.name = name;
        this.author = author.toAuthorDTO();
        this.genre = genre.toGenreDTO();
        this.publisher = publisher.toPublisherDTO();
        this.quantity = quantity;
        this.available = available;
        this.active = active;
    }

    public Book toBook() {
        return new Book()
                .setId(id)
                .setName(name)
                .setAuthor(author.toAuthor())
                .setGenre(genre.toGenre())
                .setPublisher(publisher.toPublisher())
                .setQuantity(quantity)
                .setAvailable(available)
                .setActive(active);
    }

    @Override
    public String toString() {
        return "BookDTO{" +
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
