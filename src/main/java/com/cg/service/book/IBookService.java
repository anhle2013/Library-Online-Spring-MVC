package com.cg.service.book;

import com.cg.model.Book;
import com.cg.model.dto.BookDTO;
import com.cg.service.IGeneralService;

import java.util.List;

public interface IBookService extends IGeneralService<Book> {
    List<BookDTO> findAllBookDTO();
}
