package com.cg.controller.rest;

import com.cg.exception.ResourceNotFoundException;
import com.cg.model.CallCardDetail;
import com.cg.service.callCardDetail.ICallCardDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/cards")
public class CallCardRestController {
    @Autowired
    private ICallCardDetailService callCardDetailService;

    @PutMapping("/select/{callCardId}")
    public ResponseEntity<?> doUpdateStatus(@PathVariable Long callCardId) {
        Optional<CallCardDetail> optionalCallCardDetail = callCardDetailService.findById(callCardId);
        if (!optionalCallCardDetail.isPresent()) {
            throw new ResourceNotFoundException("Card Detail ID NOT available");
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
