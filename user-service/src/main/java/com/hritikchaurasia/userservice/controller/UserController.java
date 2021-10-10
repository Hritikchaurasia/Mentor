package com.hritikchaurasia.userservice.controller;


import com.hritikchaurasia.userservice.Repository.UserRepository;
import com.hritikchaurasia.userservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;


@RestController
@RequestMapping("/user")
@ResponseBody
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/signup")
    public ResponseEntity<Map<String, String>> signUp(@RequestBody User user){

        Optional<User> isUserExist = userRepository.checkUserExist(user.getEmail());
        Map<String, String> body = new HashMap<>();
        if(isUserExist.isEmpty()){
            try {
                userRepository.insert(user);
                body.put("message", "signup complete");
                return  ResponseEntity.status(200).body(body);
            }catch (Exception e){
                body.put("message", "signup fail");
                return  ResponseEntity.status(500).body(body);
            }
        }

        body.put("message", "user already exist");
        return ResponseEntity.status(400).body(body);

    }


    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String , String> data ){

        Optional<User> user = userRepository.checkUserExist(data.get("email"));
        Map<String, String> body = new HashMap<>();
        System.out.println(data.get("email"));
        if(user.isEmpty()){
            body.put("message", "user does not exist! please signup");
            return  ResponseEntity.status(400).body(body);
        }
        if(Objects.equals(user.get().getPassword(), data.get("password"))){
            body.put("message", "login complete");
            return  ResponseEntity.status(200).body(body);
        }
        body.put("message", "please provide valid password");
        return ResponseEntity.status(402).body(body);

    }


}
