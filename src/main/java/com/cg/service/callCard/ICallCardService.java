package com.cg.service.callCard;

import com.cg.model.CallCard;
import com.cg.model.User;
import com.cg.service.IGeneralService;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ICallCardService extends IGeneralService<CallCard> {

    Boolean existsByUserAndActiveIsTrue(User user);

    Optional<CallCard> findByUserAndActiveIsFalse(User user);

    CallCard getByUserAndActiveIsFalse(@Param("userId") Long userId);
}
