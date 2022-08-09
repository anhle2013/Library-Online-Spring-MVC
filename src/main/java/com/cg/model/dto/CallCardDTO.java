package com.cg.model.dto;

import com.cg.model.Book;
import com.cg.model.CallCard;
import com.cg.model.CallCardDetail;
import com.cg.model.User;
import com.cg.service.user.IUserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class CallCardDTO {

    private Long id;

    private Set<CallCardDetailDTO> callCardDetailDTOs;

    private Long userId;

    public CallCard toCallCard(User user, Set<CallCardDetail> callCardDetails) {
        return new CallCard()
                .setId(id)
                .setUser(user);
//                .setCallCardDetails(callCardDetails);
    }

//    public Set<CallCardDetail> toCallCardDetail(Set<CallCardDetailDTO> callCardDetailDTOS, Book book, CallCard callCard) {
//        Set<CallCardDetail> callCardDetails = new HashSet<>();
//        for (CallCardDetailDTO callCardDetailDTO: callCardDetailDTOS)
//            callCardDetails.add(callCardDetailDTO.toCallCardDetail(book, callCard));
//        return callCardDetails;
//    }
}
