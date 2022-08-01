package com.cg.model.dto;

import com.cg.model.Author;
import com.cg.model.Book;
import com.cg.model.Genre;
import com.cg.model.Publisher;
import com.cg.service.author.IAuthorService;
import com.cg.service.genre.IGenreService;
import com.cg.service.publisher.IPublisherService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class BookDTO {
    private Long id;

    private String name;

//    private AuthorDTO author;
    private Author author;

    private Genre genre;

    private Publisher publisher;

    private int quantity;
    private int available;

    private boolean active;


    public Book toBook() {
        return new Book()
                .setId(id)
                .setName(name)
                .setAuthor(author)
                .setGenre(genre)
                .setPublisher(publisher)
                .setQuantity(quantity)
                .setAvailable(available);
    }


}
