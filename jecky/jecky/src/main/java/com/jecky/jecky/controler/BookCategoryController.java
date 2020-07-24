package com.jecky.jecky.controler;


import com.jecky.jecky.model.BookCategory;
import com.jecky.jecky.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/bookcategory")
public class BookCategoryController {

    @Autowired
    BookCategoryService bookCategoryService;
    @GetMapping("")
    List<BookCategory> getAllBookCategory(){
        return bookCategoryService.findAll();
    }

    @DeleteMapping("/delete")
    Map<String, Object> deleteById(@RequestParam int id) {
        Map<String, Object> result = new HashMap<>();
        if (bookCategoryService.deleteByBookCategory(id)) {
            result.put("success", true);
        } else {
            result.put("success", false);

        }
        return result;
    }
    @PutMapping("/update")
    Map<String, Object> UpdateBookCategory(@RequestBody BookCategory body) {
        Map<String, Object> result = new HashMap<>();
        if (bookCategoryService.updateBookCategory(body)) {
            result.put("success", true);
            result.put("mes", "berhasil");
        } else {
            result.put("success", false);
            result.put("mes", "gagal");
        }
        return result;
    }

    @PostMapping("/insert")
    public Map insertBookCategory(@RequestBody BookCategory bookCategory) {
        return bookCategoryService.insertBookCategory(bookCategory);
    }



}
