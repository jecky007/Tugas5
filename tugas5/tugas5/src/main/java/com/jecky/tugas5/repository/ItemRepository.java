package com.jecky.tugas5.repository;

import com.jecky.tugas5.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {
    Optional<Item> findById(String Id);

    Item deleteByid(String id);
}
