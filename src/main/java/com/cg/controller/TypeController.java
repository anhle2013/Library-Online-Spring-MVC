package com.cg.controller;

import com.cg.model.dto.BookDTO;
import com.cg.service.author.IAuthorService;
import com.cg.service.genre.IGenreService;
import com.cg.service.publisher.IPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/types")
public class TypeController {
    @Autowired
    private IAuthorService authorService;

    @Autowired
    private IGenreService genreService;

    @Autowired
    private IPublisherService publisherService;


    @GetMapping
    public ModelAndView showTypePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/types/list");

        return modelAndView;
    }
}
