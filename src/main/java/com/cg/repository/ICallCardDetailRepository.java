package com.cg.repository;


import com.cg.model.Book;
import com.cg.model.CallCard;
import com.cg.model.CallCardDetail;
import com.cg.service.callCardDetail.CallCardDetailService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICallCardDetailRepository extends JpaRepository<CallCardDetail, Long> {

    Optional<CallCardDetail> findByBookAndCallCard(Book book, CallCard callCard);

    Iterable<CallCardDetail> findByCallCard(CallCard callCard);
}
