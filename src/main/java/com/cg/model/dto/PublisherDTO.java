package com.cg.model.dto;

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
public class PublisherDTO {
    private Long id;

    private String name;

    public Publisher toPublisher() {
        return new Publisher()
                .setId(id)
                .setName(name);
    }
}
