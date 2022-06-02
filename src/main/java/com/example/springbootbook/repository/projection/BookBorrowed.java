package com.example.springbootbook.repository.projection;

import com.example.springbootbook.model.BookType;
import com.example.springbootbook.model.UserActivityType;

import java.time.LocalDateTime;

public interface BookBorrowed {
    String getName();
    BookType getType();
    UserActivityType getUserActivityType();
    Integer getQuantity();
    LocalDateTime getActivityTime();
}
