package com.cg.repository;


import com.cg.model.CallCard;
import com.cg.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICallCardRepository extends JpaRepository<CallCard, Long> {

    Boolean existsByUserAndActiveIsTrue(User user);

    Optional<CallCard> findByUserAndActiveIsFalse(User user);


    @Query("SELECT cc FROM CallCard AS cc WHERE cc.user.id = :userId AND cc.active = false ")
    CallCard getByUserAndActiveIsFalse(@Param("userId") Long userId);

}
