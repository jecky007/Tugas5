package com.exercises.tugas1.Repository;

import com.exercises.tugas1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findById(int id);

    User findByUsername(String username);
}
