package com.jecky.jecky.repository;

import com.jecky.jecky.model.BookCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Integer> {
    BookCategory findById(int id);
    Page<BookCategory> findByNameContaining(String search, Pageable pageable);
}
