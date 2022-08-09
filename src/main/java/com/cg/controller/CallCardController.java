package com.cg.controller;

import com.cg.model.*;
import com.cg.service.book.IBookService;
import com.cg.service.callCard.ICallCardService;
import com.cg.service.callCardDetail.ICallCardDetailService;
import com.cg.service.role.IRoleService;
import com.cg.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.*;

@Controller
@RequestMapping("/cards")
public class CallCardController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private ICallCardService callCardService;

    @Autowired
    private ICallCardDetailService callCardDetailService;

    @Autowired
    private IBookService bookService;

    @ModelAttribute("bookList")
    public HashSet<Long> setupCard() {
        return new HashSet<>();
    }

    @GetMapping("")
    public ModelAndView showCallCardListPage (){
        ModelAndView modelAndView = new ModelAndView("/admin/cards/list");
        Iterable<CallCard> callCards = callCardService.findAll();
        modelAndView.addObject("callCards", callCards);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateCardPage (@SessionAttribute("bookList") HashSet<Long> bookList){
        ModelAndView modelAndView = new ModelAndView("/admin/cards/create");
        List<User> users = userService.findAllByRole(roleService.findByName("ROLE_USER"));
        List<Book> books = new ArrayList<>();
        for (Long bookId: bookList) {
            Optional<Book> optionalBook = bookService.findById(bookId);
            optionalBook.ifPresent(books::add);
        }
        modelAndView.addObject("users", users);
        modelAndView.addObject("books", books);
        modelAndView.addObject("callCard", new CallCard());
        return modelAndView;
    }

    @GetMapping("/select/{cardId}")
    public ModelAndView showSelectCallCardPage (@PathVariable Long cardId){
        ModelAndView modelAndView = new ModelAndView("/admin/cards/select");
        Optional<CallCard> optionalCallCard = callCardService.findById(cardId);
        if (!optionalCallCard.isPresent())
            modelAndView.addObject("error", "Call card id NOT available!");
        else {
            Iterable<CallCardDetail> callCardDetails = callCardDetailService.findByCallCard(optionalCallCard.get());
            modelAndView.addObject("callCardDetails", callCardDetails);
            modelAndView.addObject("callCard", optionalCallCard.get());
        }
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView doCreateCallCard (@SessionAttribute("bookList") HashSet<Long> bookList, @RequestParam("userId") Long userId, HttpSession session){
        ModelAndView modelAndView = new ModelAndView("/admin/cards/create");
        if (bookList.isEmpty()) {
            modelAndView.addObject("error", "Add book first!");
            return modelAndView;
        }
        CallCard callCard = new CallCard();

        List<Book> books = new ArrayList<>();
        for (Long bookId: bookList) {
            Optional<Book> optionalBook = bookService.findById(bookId);
            optionalBook.ifPresent(books::add);
        }

        Optional<User> optionalUser = userService.findByIdAndRole(userId, roleService.findByName("ROLE_USER"));
        if (!optionalUser.isPresent()) {
            modelAndView.addObject("books", books);
            modelAndView.addObject("error", "User NOT available or CAN NOT borrow book");
            return modelAndView;
        }
        callCard.setUser(optionalUser.get());
        callCardService.save(callCard);

//        Set<CallCardDetail> callCardDetails = new HashSet<>();
        for (Book book: books) {
            CallCardDetail callCardDetail = new CallCardDetail();
            callCardDetail.setCallCard(callCard);
            callCardDetail.setBook(book);
            callCardDetail.setQuantity(1);
            callCardDetail.setTakenDate(LocalDateTime.now());
            callCardDetail.setMaturityDate(callCardDetail.getTakenDate().plusDays(3));
            callCardDetail.setBorrowStatus(EBorrowStatus.BORROWING);
            callCardDetailService.save(callCardDetail);
            book.setAvailable(book.getAvailable() - 1);
            bookService.save(book);
//            callCardDetails.add(callCardDetail);
        }
//        callCard.setCallCardDetails(callCardDetails);
        session.setAttribute("bookList", new HashSet<Long>());
        modelAndView.addObject("success", "Complete borrow book for User: " + optionalUser.get().getUsername());
        return modelAndView;
    }

}
