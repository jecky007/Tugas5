package com.jecky.tugas5.repository;

import com.jecky.tugas5.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
Optional<User>findById(String Id);
    User findByUsername(String username);

    User deleteByid(String id);
}
