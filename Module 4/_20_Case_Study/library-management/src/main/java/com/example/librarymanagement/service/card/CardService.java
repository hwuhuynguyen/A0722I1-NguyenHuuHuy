package com.example.librarymanagement.service.card;

import com.example.librarymanagement.entity.Card;
import com.example.librarymanagement.repository.ICardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardService implements ICardService {
    @Autowired
    private ICardRepository cardRepository;

    @Override
    public Iterable<Card> findAll() {
        return cardRepository.findAll();
    }

    @Override
    public Optional<Card> findById(String id) {
        return cardRepository.findById(id);
    }

    @Override
    public void save(Card card) {
        cardRepository.save(card);
    }

    @Override
    public void removeById(String id) {
        cardRepository.deleteById(id);
    }

    @Override
    public Iterable<Card> findAvailableCard() {
        return cardRepository.findAvailableCard();
    }

    @Override
    public Iterable<Card> searchByBookNameOrStudentName(String book, String student) {
        return cardRepository.searchByBookNameOrStudentName(book, student);
    }
}
