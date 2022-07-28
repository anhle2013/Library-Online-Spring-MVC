package com.cg.controller.rest;

import com.cg.model.dto.BookDTO;
import com.cg.service.book.IBookService;
import com.cg.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookRestController {
    @Autowired
    private AppUtil appUtil;

    @Autowired
    private IBookService bookService;

    @GetMapping
    public ResponseEntity<?> getAllBookDTOs() {

        List<BookDTO> bookDTOList = bookService.findAllBookDTO();
        System.out.println(bookDTOList);

//        List<CustomerDTO> customerDTOS = new ArrayList<>();
//
//        for (Customer customer : customers) {
//            customerDTOS.add(customer.toCustomerDTO());
//        }

        return new ResponseEntity<>(bookDTOList, HttpStatus.OK);
    }
}
