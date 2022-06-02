package com.example.springbootbook.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

// refer to User.java for annotation explanations
@Data
@Entity
@Table(name="userActivity")
public class UserActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    // use fetch type lazy for performance
    // if use eager fetch type, will keep fetching from user table everytime userActivity table is used(not efficient)
    // in lazy mode, if we don't specify the user -> it does not fetch the user table
    @ManyToOne(fetch = FetchType.LAZY)
    // to create foreign key automatically,
    // we can use relation between user and userActivity classes
    // map with user table directly with JoinColumn
    // use user_id on userActivity table to join with id column of user table
    // not insertable and not updatable because we only use this to create foreign key relations
    @JoinColumn(name="user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;

    @Column(name="book_id", nullable = false)
    private Long bookId;
    // many to 1 relation as book can be borrowed/returned many times
    // specify in lazy mode for performance
    @ManyToOne(fetch = FetchType.LAZY)
    // map to user table directly with joincolumn
    // use this relation only to create foreign key relation,
    // so column does not need to be insertable or updatable
    @JoinColumn(name = "book_id",referencedColumnName = "id", insertable = false, updatable = false)
    private Book book;

    @Enumerated(EnumType.STRING)
    @Column(name="activity_type", nullable = false)
    private UserActivityType userActivityType;

    // for logging
    @Column(name = "activity_time", nullable = false)
    private LocalDateTime activityTime;

}