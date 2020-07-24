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
   @Autowired
    BookService bookService;
    @GetMapping("")
    List<Book> getAllBook(){
        return bookRepository.findAll();
    }

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
public Map<String,Object> addNewBook(@RequestBody Book body){
    Map<String ,Object> result = new HashMap<>();
    if (bookService.saveBook(body)){
        result.put("success", true);
        result.put("message","book berhasil ditambahkan");
    }else {
        result.put("successs",false);
        result.put("message","book gagal ditambahkan");
    }
    return result;
}


//    @GetMapping("/byTitle")
//    public List<Book> getUsersByTitle(@RequestParam(required = false) String title) {
//        return bookService.getAllBookByTitle(title);
//    }
//
//    @GetMapping("/byCategory")
//    public List<Book> getUsersByCategory(@RequestParam(required = false) int id) {
//        return bookService.getAllBookByCategory(id);
//    }


}
