package com.example.librarymanagement.service.card;

import com.example.librarymanagement.entity.Card;
import com.example.librarymanagement.service.IGeneralService;

public interface ICardService extends IGeneralService<Card> {
    Iterable<Card> findAvailableCard();
    Iterable<Card> searchByBookNameOrStudentName(String book, String student);
}
