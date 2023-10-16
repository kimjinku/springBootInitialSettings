package com.korea.basic1;

import com.korea.basic1.answer.Answer;
import com.korea.basic1.answer.AnswerRepository;
import com.korea.basic1.question.Question;
import com.korea.basic1.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class SbbApplicationTests {

    @Autowired
    private QuestionRepository questionRepository;

    @Transactional
    @Test
    void testJpa() {
        Optional<Question> oq = this.questionRepository.findById(2);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        List<Answer> answerList = q.getAnswerList();

        assertEquals(1, answerList.size());
        assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
    }
}
