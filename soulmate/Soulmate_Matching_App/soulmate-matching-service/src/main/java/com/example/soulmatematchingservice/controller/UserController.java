package com.example.soulmatematchingservice.controller;

import com.example.soulmatematchingservice.domain.User;
import com.example.soulmatematchingservice.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v3")
public class UserController {
    private final UserServices userServices;

    @Autowired
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }


    // http://localhost:6789/api/v3/find
    @GetMapping("/find")
    public ResponseEntity<?> get() {
        return new ResponseEntity<>(userServices.getUser(), HttpStatus.OK);
    }

    // http://localhost:6789/api/v3/interested/
    @GetMapping("/interested/{id}")
    public ResponseEntity<?> getLiked(@PathVariable String id) {
        System.out.println("AAAAAAAAAAAAAA  "+id);
        return new ResponseEntity<>(userServices.getInterested(id), HttpStatus.OK);
    }

    // http://localhost:6789/api/v3/like
    @PostMapping("/like")
    public ResponseEntity<?> like(@RequestBody List<String> values) {
        System.out.println(values.get(0));
        System.out.println(values.get(1));
        return new ResponseEntity<>(userServices.liked(values.get(0), values.get(1)), HttpStatus.OK);
    }
}
