package com.example.springbootbook.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

// refer to User.java for annotation explanations
@Data
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name="description", nullable = false, length = 1000)
    private String description;

    @Column(name="quantity", nullable = false, length = 100)
    private Integer quantity;

    @Column(name="create_time", nullable = false)
    private LocalDateTime createTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "book_type", nullable = false)
    private BookType bookType;

    // can set up relation between userActivity and book to be bi-directional
    // lazy for performance
    // need to specify mappedBy -> name has to match book variable declared in Book.java
    // @OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
    // private Set<UserActivity> userActivity;
}