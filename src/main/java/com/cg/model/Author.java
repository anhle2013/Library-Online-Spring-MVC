package com.cg.model;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Table(name = "authors")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 30)
    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<Book> books;

//    public AuthorDTO toAuthorDTO() {
//        return new AuthorDTO()
//                .setId(id)
//                .setName(name);
//    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

//    @Override
//    public boolean supports(Class<?> aClass) {
//        return Author.class.isAssignableFrom(aClass);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//
//        Author author = (Author) target;
//        Long id = author.getId();
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id.empty");
//
//    }
}
