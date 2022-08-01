package com.cg.model;

import com.cg.model.dto.BookDTO;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;

@Entity
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class Book extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 50, message = "Name length between 2 to 50 characters")
    private String name;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "author_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Author author;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "genre_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Genre genre;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Publisher publisher;

//    @Pattern(regexp = "\\d", message = "Quantity must be number")
    @NotNull( message = "Enter quantity!")
    @Range(min = 1, max = 99, message = "Quantity must be 1 to 99 books")
    private Integer quantity;
    private Integer available;

    @OneToMany(mappedBy = "book")
    private Collection<CallCardDetail> callCardDetails;

    public BookDTO toBookDTO() {
        return new BookDTO()
                .setId(id)
                .setName(name)
                .setAuthor(author)
                .setGenre(genre)
                .setPublisher(publisher)
                .setQuantity(quantity)
                .setAvailable(available);
    }


}
