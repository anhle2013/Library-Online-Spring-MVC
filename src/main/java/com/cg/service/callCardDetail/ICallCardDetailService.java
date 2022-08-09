package com.cg.service.callCardDetail;

import com.cg.model.Book;
import com.cg.model.CallCard;
import com.cg.model.CallCardDetail;
import com.cg.service.IGeneralService;

import java.util.Collection;
import java.util.Optional;

public interface ICallCardDetailService extends IGeneralService<CallCardDetail> {

    Optional<CallCardDetail> findByBookAndCallCard(Book book, CallCard callCard);

    Iterable<CallCardDetail> findByCallCard(CallCard callCard);

}
