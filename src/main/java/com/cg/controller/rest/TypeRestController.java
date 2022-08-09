package com.cg.controller.rest;

import com.cg.exception.ResourceNotFoundException;
import com.cg.model.Author;
import com.cg.model.Genre;
import com.cg.model.Publisher;
import com.cg.model.dto.BookType;
import com.cg.service.author.IAuthorService;
import com.cg.service.genre.IGenreService;
import com.cg.service.publisher.IPublisherService;
import com.cg.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/types")
public class TypeRestController {
    @Autowired
    private AppUtil appUtil;

    @Autowired
    private IAuthorService authorService;

    @Autowired
    private IGenreService genreService;

    @Autowired
    private IPublisherService publisherService;

    @GetMapping("/{type}")
    public ResponseEntity<?> showTypeTable(@PathVariable String type) {
        List<?> list;
        switch (type) {
            case "authors":
                list = authorService.findAllDTO();
                break;
            case "genres":
                list = genreService.findAllDTO();
                break;
            case "publishers":
                list = publisherService.findAllDTO();
                break;
            default:
                throw new ResourceNotFoundException("NOT found any type: " + type);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/create/{type}")
    public ResponseEntity<?> doCreate(@PathVariable String type, @RequestBody BookType bookType) {
//        if (bindingResult.hasErrors()) {
//            return appUtil.mapErrorToResponse(bindingResult);
//        }
        Boolean exitsName;
        switch (type) {
            case "authors":
//                exitsName = authorService.existsByName(typeDTO.getName());
//                if (exitsName) {
//                    throw new EmailExistsException("This name already exists");
//                }
                Author author = authorService.save(bookType.toAuthor());
                return new ResponseEntity<>(author.toTypeDTO(), HttpStatus.CREATED);
            case "genres":
//                exitsName = genreService.existsByName(typeDTO.getName());
//                if (exitsName) {
//                    throw new EmailExistsException("This name already exists");
//                }
                Genre genre = genreService.save(bookType.toGenre());
                return new ResponseEntity<>(genre.toTypeDTO(), HttpStatus.CREATED);
            case "publishers":
//                exitsName = publisherService.existsByName(typeDTO.getName());
//                if (exitsName) {
//                    throw new EmailExistsException("This name already exists");
//                }
                Publisher publisher = publisherService.save(bookType.toPublisher());
                return new ResponseEntity<>(publisher.toTypeDTO(), HttpStatus.CREATED);
            default:
                throw new ResourceNotFoundException("NOT found any type: " + type);
        }
    }
}
