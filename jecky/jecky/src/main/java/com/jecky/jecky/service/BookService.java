package com.jecky.jecky.service;

import com.jecky.jecky.model.Address;
import com.jecky.jecky.model.Book;
import com.jecky.jecky.model.BookCategory;
import com.jecky.jecky.model.User;
import com.jecky.jecky.repository.BookCategoryRepository;
import com.jecky.jecky.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService {

    @Autowired
    BookRepository bookrepository;
    @Autowired
    BookCategoryRepository bookcategoryrepository;

    public Map<String, Object> insertBook(Book body) {
        Book book;
        Map<String, Object> resultMap = new HashMap<>();
        try {

            bookrepository.save(body);
            //insert address

            resultMap.put("success", true);
            resultMap.put("message", "berhasil insert book category");
        } catch (Exception e) {
            resultMap.put("success", false);
            resultMap.put("message", "gagal insert book category" + e.getMessage());
        }
        return resultMap;
    }

    public boolean deleteByBookId(int bookId) {
        Book result = bookrepository.findById(bookId);

        if (result != null) {
            try {
                bookrepository.delete(result);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean updateBook(Book body) {
        Book userResult = bookrepository.findById(body.getId());

        if (userResult != null) {
            try {
//
                bookrepository.save(body);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }

    }
    public Map<String, Object> getBookById(int bookId) {
        Book result = bookrepository.findById(bookId);
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

    public List<Book> getAllBookByTitle(String title) {
        return bookrepository.findByTitleContaining(title);
    }

    public List<Book> getAllBookByCategory(int id) {
        return bookrepository.findBycategoryidContaining(id);
    }
}
