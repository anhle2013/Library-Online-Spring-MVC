package com.cg.model.dto;

import com.cg.model.*;
import com.cg.service.book.IBookService;
import com.cg.service.callCard.ICallCardService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.time.LocalDateTime;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class CallCardDetailDTO {


    private Long id;
    private Long callCardId;
    private Long bookId;
    private int quantity;
    private LocalDateTime takenDate;
    private LocalDateTime maturityDate;
    private LocalDateTime returnDate;
    private EBorrowStatus borrowStatus;

    public CallCardDetail toCallCardDetail(Book book, CallCard callCard) {

        return new CallCardDetail()
                .setBook(book)
                .setCallCard(callCard)
                .setQuantity(1)
                .setTakenDate(LocalDateTime.now())
                .setMaturityDate(LocalDateTime.now().plusDays(3))
                .setBorrowStatus(EBorrowStatus.BORROWING);
    }


}
