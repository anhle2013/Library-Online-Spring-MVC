package com.cg.model;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "call_card_details")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class CallCardDetail{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "call_card_id")
    private CallCard callCard;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private int quantity;

    @CreationTimestamp
    @Column(name = "taken_date")
    private LocalDateTime takenDate;

    @Column(name = "maturity_date")
    private LocalDateTime maturityDate;

    @Column(name = "return_date")
    private LocalDateTime returnDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "borrow_status", length = 25)
    private EBorrowStatus borrowStatus;

}
