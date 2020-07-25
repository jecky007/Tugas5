package com.jecky.tugas5.service;

import com.jecky.tugas5.model.User;
import com.jecky.tugas5.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public List<User> getAllUser(Integer pageNo, String sortKey){
        int noOfRecord = 2;
        Pageable page = PageRequest.of(pageNo, noOfRecord, Sort.by(sortKey));
        Page<User> pagedResult = userRepository.findAll(page);
        return pagedResult.getContent();
    }

    public boolean Delete(String id) {
        User result = userRepository.deleteByid(id);
        if (result != null) {
            try {
                userRepository.delete(result);
                return true;
            } catch (Exception e) {
                return false;
            }

        } else {
            return false;
        }
    }


    public boolean updateUser(User body) {
        Optional<User> userResult = userRepository.findById(body.getId());

        if (userResult != null) {
            try {
//
                userRepository.save(body);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }

    }


    public Map<String, Object> insert(User user) {
        Map<String, Object>result = new HashMap<>();
        try {
            userRepository.save(user);
            result.put("success",true);
            result.put("mes","berhasil");
        }catch (Exception e){
            result.put("success",false);
            result.put("mes","gagal");
        }
        return result;
    }

}
