package com.cg.model.dto;

import com.cg.model.Author;
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
public class AuthorDTO {
    private Long id;

    private String name;

    public Author toAuthor() {
        return new Author()
                .setId(id)
                .setName(name);
    }
}
