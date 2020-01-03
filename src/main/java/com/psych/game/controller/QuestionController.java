package com.psych.game.controller;

import com.psych.game.model.Question;
import com.psych.game.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/questions")
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @GetMapping("/questions/{id}")
    public Question getAllQuestions(@PathVariable(value = "id") Long id) throws Exception {
        return questionRepository.findById(id).orElseThrow(() -> new Exception());
    }
}
