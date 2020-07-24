package com.jecky.jecky.service;

import com.jecky.jecky.model.BookCategory;
import com.jecky.jecky.repository.BookCategoryRepository;
import com.jecky.jecky.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookCategoryService {

    @Autowired
    BookCategoryRepository bookcategoryrepository;

    @Autowired
    BookRepository bookrepository;

    public Map<String, Object> insertBookCategory(BookCategory body) {
        BookCategory bookCategory;
        Map<String, Object> resultMap = new HashMap<>();
        try {

            bookcategoryrepository.save(body);
            //insert address

            resultMap.put("success", true);
            resultMap.put("message", "berhasil insert book category");
        } catch (Exception e) {
            resultMap.put("success", false);
            resultMap.put("message", "gagal insert book category" + e.getMessage());
        }
        return resultMap;
    }


    public boolean deleteByBookCategory(int categoryId) {
        BookCategory result = bookcategoryrepository.findById(categoryId);

        if (result != null) {
            try {
                bookcategoryrepository.delete(result);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean updateBookCategory(BookCategory body) {

        BookCategory result = bookcategoryrepository.findById(body.getId());
        Map<String, Object> resultMap = new HashMap<>();

        if (result != null) {
            try {
                bookcategoryrepository.save(body);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }



    }
    public Map<String, Object> getBookCategoryById(int categoryId) {
        BookCategory result = bookcategoryrepository.findById(categoryId);
        Map<String, Object> resultMap = new HashMap<>();
        if (result != null) {
            resultMap.put("success", true);
            resultMap.put("record", result);
        } else {
            resultMap.put("success", false);
            resultMap.put("message", "data address tidak di temukan");
        }
        return resultMap;
    }
    public List<BookCategory> findAll() {
        return bookcategoryrepository.findAll();
    }

}
