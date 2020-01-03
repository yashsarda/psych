package com.psych.game.controller;

import com.psych.game.Constants;
import com.psych.game.Pair;
import com.psych.game.Utils;
import com.psych.game.model.GameMode;
import com.psych.game.model.Player;
import com.psych.game.model.Question;
import com.psych.game.repository.PlayerRepository;
import com.psych.game.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.Map;

@RestController
@RequestMapping("/dev")
public class PopulateDB {

    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    QuestionRepository questionRepository;

    @GetMapping("/add-questions-from-files")
    public void addQuestionsFromFile() throws FileNotFoundException {
        questionRepository.deleteAll();
        for(Map.Entry<String, GameMode> entry : Constants.QA_FILES.entrySet()) {
            int questionNumber = 0;
            String fileName = entry.getKey();
            GameMode gameMode = entry.getValue();
            for(Pair<String, String> question_answer : Utils.readQAFile(fileName)) {
                Question q = new Question();
                q.setQuestionText(question_answer.getFirst());
                q.setCorrectAnswer(question_answer.getSecond());
                q.setGameMode(gameMode);
                questionRepository.save(q);
                questionNumber++;
                if (questionNumber > Constants.MAX_QUESTION_TO_READ) {
                    break;
                }
            }
        }
    }

    @GetMapping("/add-dummy-players ")
    public void addDummyPlayers() throws FileNotFoundException {
        playerRepository.deleteAll();
        Player luffy = new Player();
        luffy.setName("Luffy");

        Player robin = new Player();
        robin.setName("Robin");

        playerRepository.save(luffy);
        playerRepository.save(robin);
    }


}
