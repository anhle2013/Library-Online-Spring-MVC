package com.cg.model;

import com.cg.model.dto.AuthorDTO;
import com.cg.model.dto.GenreDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "genres")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "genre")
    private Set<Book> books;

    public GenreDTO toGenreDTO() {
        return new GenreDTO()
                .setId(id)
                .setName(name);
    }
}
