package com.cg.model.dto;

import com.cg.model.Author;
import com.cg.model.Genre;
import com.cg.model.Publisher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class BookType {
    private Long id;

    private String name;

    public Author toAuthor() {
        return new Author()
                .setId(id)
                .setName(name);
    }

    public Genre toGenre() {
        return new Genre()
                .setId(id)
                .setName(name);
    }

    public Publisher toPublisher() {
        return new Publisher()
                .setId(id)
                .setName(name);
    }
}