package com.example.librarymanagement.controller;

import com.example.librarymanagement.entity.Book;
import com.example.librarymanagement.entity.Card;
import com.example.librarymanagement.entity.Student;
import com.example.librarymanagement.service.book.IBookService;
import com.example.librarymanagement.service.card.ICardService;
import com.example.librarymanagement.service.student.IStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/card")
public class CardController {
    @Autowired
    private ICardService cardService;
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IBookService bookService;

    @GetMapping("/list")
    public String displayCardList(@RequestParam("book") Optional<String> book,
                                  @RequestParam("student") Optional<String> student,
                                  Model model) {
        String bookSearch, studentSearch;
        bookSearch = (book.isEmpty()) ? "" : book.get();
        studentSearch = (student.isEmpty()) ? "" : student.get();
        List<Card> cardList = (List<Card>) cardService.searchByBookNameOrStudentName(bookSearch, studentSearch);
        model.addAttribute("cardList", cardList);
        return "/card/list";
    }

    @GetMapping("/borrow-list")
    public String displayAvailableCardList(Model model) {
        List<Card> cardList = (List<Card>) cardService.findAvailableCard();
        model.addAttribute("cardList", cardList);
        return "/card/list";
    }

    @GetMapping("/borrow/{id}")
    public String displayBorrowForm(@PathVariable("id") String id, Model model) {
        Book book = bookService.findById(id).isPresent() ? bookService.findById(id).get() : null;
        if (book != null) {
            List<Student> studentList = (List<Student>) studentService.findAll();
            Card card = new Card();
            card.setId(autoGenerateMotelId());
            card.setBook(book);
            model.addAttribute("card", card);
            model.addAttribute("book", book);
            model.addAttribute("studentList", studentList);
            return "/card/borrow";
        }
        return "error";
    }

    @PostMapping("/borrow")
    public String borrowBook(@Valid @ModelAttribute("card") Card card, BindingResult bindingResult, Model model) {
        System.err.println(card);
        if (bindingResult.hasErrors()) {
            System.err.println(bindingResult.getErrorCount());
            System.err.println(bindingResult.getAllErrors());
            List<Student> studentList = (List<Student>) studentService.findAll();
            Book book = (card.getBook());
            model.addAttribute("book", book);
            model.addAttribute("studentList", studentList);
            return "/card/borrow";
        }
        System.err.println("done");
        cardService.save(card);
        Book book = card.getBook();
        book.setQuantity(book.getQuantity() - 1);
        bookService.save(book);
        return "redirect:/book/list";
    }

    @GetMapping("/return/{id}")
    public String returnBook(@PathVariable("id") String id) {
        Card card = cardService.findById(id).isPresent() ? cardService.findById(id).get() : null;
        if (card != null) {
            card.setStatus(true);
            cardService.save(card);

            Book book = card.getBook();
            book.setQuantity(book.getQuantity() + 1);
            bookService.save(book);

            System.err.println("return success: " + id);
        }
        return "redirect:/card/borrow-list";
    }

    private String autoGenerateMotelId() {
        List<Card> cardList = (List<Card>) cardService.findAll();
        if (cardList.size() == 0) return "MS-0001";
        String lastId = cardList.get(cardList.size() - 1).getId();
        String[] split = lastId.split("-");
        int number = Integer.parseInt(split[1]) + 1;
        return (number < 10) ? ("MS-000" + number) : ("MS-00" + number);
    }
}
