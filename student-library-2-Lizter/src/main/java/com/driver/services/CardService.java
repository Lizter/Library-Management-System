package com.driver.services;

import com.driver.repositories.CardRepository;
import com.driver.models.Card;
import com.driver.models.CardStatus;
import com.driver.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository3;

    public Card createAndReturn(Student student){
        Card card = new Card();
        card.setStudent(student);
        student.setCard(card);

        cardRepository3.save(card);
        return card;
    }

    public void deactivateCard(int student_id){
        cardRepository3.deactivateCard(student_id, CardStatus.DEACTIVATED.toString());
    }
}