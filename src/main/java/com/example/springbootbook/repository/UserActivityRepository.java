package com.example.springbootbook.repository;

import com.example.springbootbook.model.UserActivity;
import com.example.springbootbook.repository.projection.BookBorrowed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

// use UserRepository for notes
public interface UserActivityRepository extends JpaRepository<UserActivity, Long> {
    @Query("select "+
            "b.name as name, b.bookType as type, b.quantity as quantity, " +
            "a.userActivityType as userActivityType, a.activityTime as activityTime "+
            "from UserActivity a left join Book b on b.id = a.bookId "+
            "where a.userId = :userId")
    List<BookBorrowed> findAllActivitiesOfUser(@Param("userId") Long userId);

    @Query("select "+
            "b.name as name, b.bookType as type, b.quantity as quantity, " +
            "a.userActivityType as userActivityType, a.activityTime as activityTime "+
            "from UserActivity a left join Book b on b.id = a.bookId")
    List<BookBorrowed> findAllActivitiesOfAllUsers();
}
