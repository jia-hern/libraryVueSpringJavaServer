package com.example.springbootbook.controller;

import com.example.springbootbook.model.UserActivity;
import com.example.springbootbook.security.UserPrincipal;
import com.example.springbootbook.service.UserActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

// @RestController because class is a rest controller,
// so it will have accessible endpoints with the rest api
@RestController
// @RequestMapping to add pre path for all methods under user activity controller
@RequestMapping("api/userActivity")//pre-path
public class UserActivityController {
    // @Autowired for dependency injection in spring
    @Autowired
    private UserActivityService userActivityService;

    // save user activity method
    @PostMapping //api/userActivity
    // not defined so will just be api/userActivity
    // use ResponseEntity for response encapsulation
    // use @RequestBody to reach form data of request
    public ResponseEntity<?> saveUserActivity(@RequestBody UserActivity userActivity){
        return new ResponseEntity<>(userActivityService.saveUserActivity(userActivity), HttpStatus.CREATED);
    }
    // get all user activity of user method
    @GetMapping //api/userActivity
    // not defined so will just be api/userActivity
    // use @AuthenticationPrincipal to get authentication of user
    public ResponseEntity<?> getAllUserActivityOfUser(@AuthenticationPrincipal UserPrincipal userPrincipal){
        // return the body with ok http status,
        // and use the userPrincipal to get the user authentication
        return ResponseEntity.ok(userActivityService.findUserActivityOfUser(userPrincipal.getId()));
//        return new ResponseEntity<>(userActivityService.findUserActivityOfUser(userPrincipal.getId()), HttpStatus.OK);
    }
    // get all user activity of all users method
    @GetMapping("all") //api/userActivity/all
    public ResponseEntity<?> getAllUserActivityOfAllUsers(){
        return ResponseEntity.ok(userActivityService.findUserActivityOfAllUsers());
//        return new ResponseEntity<>(userActivityService.findUserActivityOfAllUsers(), HttpStatus.OK);
    }
}