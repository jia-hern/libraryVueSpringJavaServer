package com.example.springbootbook.service;

import com.example.springbootbook.model.UserActivity;
import com.example.springbootbook.repository.projection.BookBorrowed;

import java.util.List;

public interface UserActivityService {
    // save user activity
    UserActivity saveUserActivity(UserActivity userActivity);

    // user activity of the user
    List<BookBorrowed> findUserActivityOfUser(Long userId);

    // user activity of all users
    List<BookBorrowed> findUserActivityOfAllUsers();
}
