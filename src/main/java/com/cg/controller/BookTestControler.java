package com.cg.controller;

import com.cg.model.dto.BookDTO;
import com.cg.service.book.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class BookTestControler {
    @Autowired
    private IBookService bookService;

//    @PostMapping("/books/create")
//    public ModelAndView doCreate(@ModelAttribute BookDTO bookDTO) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/admin/books/create");
//        bookService.save(bookDTO.toBook());
//        return modelAndView;
//    }
}
