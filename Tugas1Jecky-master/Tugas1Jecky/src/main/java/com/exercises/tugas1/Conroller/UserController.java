package com.exercises.tugas1.Conroller;

import com.exercises.tugas1.Repository.UserRepository;
import com.exercises.tugas1.model.Handphone;
import com.exercises.tugas1.model.Login;
import com.exercises.tugas1.model.User;
import com.exercises.tugas1.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
// menampilkan data
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserService service;


    @GetMapping("")
    public List<User> all() {
        return userRepository.findAll();
    }

    @GetMapping("getByUsername")
        // menampilkan nama satuan
    User findByUsername(@RequestParam String username) {
        User result = userRepository.findByUsername(username);
        return result;
    }

//@PreAuthorize("isAuthenticated()")
    //@PreAuthorize("hasAnyAuthority('admin')")
//   @PreAuthorize("hasAnyAuthority('admin','user','guest')")

    @PostMapping("login")
    // untuk masuk ke data
    public Map<String, Object> loginUser(@RequestBody Login body) {
        System.out.println(body.toString());
        Map<String, Object> resultMap = new HashMap<>();
        User result = userRepository.findByUsername(body.getUsername());
        if (result != null) {
            boolean isMatch = passwordEncoder.matches(body.getPassword(),
                    result.getPassword());
            if (isMatch) {
                String token = Jwts.builder()
                        .setSubject(body.getUsername())
                        .claim("role", result.getRoles())
                        .signWith(SignatureAlgorithm.HS256, "6v9y$B&E")
                        .setIssuedAt(new Date(System.currentTimeMillis()))
                        .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                        .compact();

                resultMap.put("success", true);
                resultMap.put("record", result);
                resultMap.put("token", token);
            } else {
                resultMap.put("success", false);
            }
            return resultMap;
        }

        System.out.println("user ada");

        return resultMap;
    }

    @DeleteMapping("hapus")
    //untuk hapus data
    public Map<String, Object> deleteUsers(@RequestParam int id) {
        Map<String, Object> result = new HashMap<>();
        if (service.hapusData(id)) {
            result.put("succes", true);
        } else {
            result.put("succes", false);
        }
        return result;
    }

    @PostMapping("/insert")
    //untuk menambhakan data
    public User insertUser(@RequestBody User userBody) {
        String hashedPassword = passwordEncoder.encode(userBody.getPassword());
        userBody.setPassword(hashedPassword);


        User result = userRepository.save(userBody);
        return result;
    }

    @PutMapping("update")
    //untuk mengedit data yg akan dirubah
    public Map<String, Object> updateUser(@RequestBody User body) {
        System.out.println("body : " + body.toString());
        Map<String, Object> result = new HashMap<>();

        String password = passwordEncoder.encode(body.getPassword());
        body.setPassword(password);

        if (service.updateUser(body)) {
            result.put("success", true);
            result.put("message", "berhasil teredit");
        } else {
            result.put("success", false);
            result.put("message", "gagal teredit");
        }
        return result;
    }

//    public String getUserAuthenticated() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentPrincipalName = authentication.getName();
//        return currentPrincipalName;
//    }
//    private void update (@RequestBody Handphone body){
//
//    }


}





