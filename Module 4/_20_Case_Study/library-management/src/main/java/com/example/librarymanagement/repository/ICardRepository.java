package com.example.librarymanagement.repository;

import com.example.librarymanagement.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICardRepository extends JpaRepository<Card, String> {
    @Query("select c from Card c where c.status = false")
    Iterable<Card> findAvailableCard();

    @Query("select c from Card c where lower(c.book.name) like lower(concat('%', :book, '%')) and lower(c.student.name) like lower(concat('%', :student, '%')) ")
    Iterable<Card> searchByBookNameOrStudentName(String book, String student);
}
