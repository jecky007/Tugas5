package com.jecky.jecky.controler;

import com.jecky.jecky.model.Book;
import com.jecky.jecky.model.BookCategory;
import com.jecky.jecky.repository.BookRepository;
import com.jecky.jecky.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/book")
public class BookController {
    @Autowired
    BookRepository bookRepository;
    BookService bookService;


    @DeleteMapping("/delete")
    Map<String, Object> deleteById(@RequestParam int id) {
        Map<String, Object> result = new HashMap<>();
        if (bookService.deleteByBookId(id)) {
            result.put("success", true);
        } else {
            result.put("success", false);

        }
        return result;
    }

    @PutMapping("/update")
    Map<String, Object> UpdateBook(@RequestBody Book body) {
        Map<String, Object> result = new HashMap<>();
        if (bookService.updateBook(body)) {
            result.put("success", true);
            result.put("mes", "berhasil");
        } else {
            result.put("success", false);
            result.put("mes", "gagal");
        }
        return result;
    }

    @PostMapping("/insert")
    public Map insertBook(@RequestBody Book book) {
        return bookService.insertBook(book);
    }


    @GetMapping("/byTitle")
    public List<Book> getUsersByTitle(@RequestParam(required = false) String title) {
        return bookService.getAllBookByTitle(title);
    }

    @GetMapping("/byCategory")
    public List<Book> getUsersByCategory(@RequestParam(required = false) int id) {
        return bookService.getAllBookByCategory(id);
    }


}
