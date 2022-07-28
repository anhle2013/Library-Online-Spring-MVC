package com.cg.model;

import com.cg.model.dto.GenreDTO;
import com.cg.model.dto.PublisherDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "publishers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "publisher")
    private Set<Book> books;

    public PublisherDTO toPublisherDTO() {
        return new PublisherDTO()
                .setId(id)
                .setName(name);
    }
}
