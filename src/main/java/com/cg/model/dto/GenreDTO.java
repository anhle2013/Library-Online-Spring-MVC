package com.cg.model.dto;

import com.cg.model.Genre;
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
public class GenreDTO {
    private Long id;

    private String name;

    public Genre toGenre() {
        return new Genre()
                .setId(id)
                .setName(name);
    }
}
