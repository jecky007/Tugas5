package com.exercises.tugas1.service;

import com.exercises.tugas1.Repository.UserRepository;
import com.exercises.tugas1.model.Handphone;
import com.exercises.tugas1.model.User;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository repo;

    public List<User> getAllUser() {return repo.findAll();}

    public User findByUsername(String username) {
        User result = repo.findByUsername(username);
        return result;
    }

    public User findByuserId(int id){
        return repo.findById(id);
    }


    public boolean hapusData(int id) {
        User result = repo.findById(id);
        if (result != null) {
            try {
                repo.delete(result);
                return true;
            } catch (Exception E) {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean updateUser(User body) {
        User result = repo.findById(body.getId());
        if(result !=null) {
            try {
                repo.save(body);
                return true;
            } catch (Exception E) {
                return false;
            }
        }else{
            return false;
            }
        }




    }













