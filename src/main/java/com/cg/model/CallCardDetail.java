package com.cg.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "call_card_details")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
    private LocalDateTime maturityDate = takenDate.plusSeconds(30);

    @UpdateTimestamp
    @Column(name = "return_date")
    private LocalDateTime returnDate;

    private BorrowStatus status;
}
