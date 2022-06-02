package com.example.springbootbook.service;

import com.example.springbootbook.model.UserActivity;
import com.example.springbootbook.repository.UserActivityRepository;
import com.example.springbootbook.repository.projection.BookBorrowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

// mark with service annotation to indicate that it holds the
// business logic / service layer -> contains business logic operations for user activity
@Service
public class UserActivityServiceImpl implements UserActivityService {
    // use Autowired for dependency injection
    // use it to change the constructor
    // call userActivity Repository later
    @Autowired
    private final UserActivityRepository userActivityRepository;

    public UserActivityServiceImpl(UserActivityRepository userActivityRepository) {
        this.userActivityRepository = userActivityRepository;
    }

    @Override
    // save a user activity
    public UserActivity saveUserActivity(UserActivity userActivity) {
        // describe/set properties of a user activity
        userActivity.setActivityTime(LocalDateTime.now());
        // save the user activity
        return userActivityRepository.save(userActivity);
    }

    @Override
    // find all user activity of a user
    public List<BookBorrowed> findUserActivityOfUser(Long userId) {
        // use the method in user activity repository
        return userActivityRepository.findAllActivitiesOfUser(userId);
    }

    @Override
    // find all user activity of all users
    public List<BookBorrowed> findUserActivityOfAllUsers() {
        return  userActivityRepository.findAllActivitiesOfAllUsers();
    }
}
