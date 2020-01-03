package com.psych.game;

import com.psych.game.model.GameMode;

import java.util.HashMap;
import java.util.Map;

public class Constants {

    public static final int MAX_QUESTION_LENGTH = 1000;
    public static final int MAX_ROUNDS = 1000;
    public static final int MAX_ANSWER_LENGTH = 1000;
    public static final int MAX_QUESTION_TO_READ = 100;
    public static final Map<String, GameMode> QA_FILES = new HashMap<>();

    static {
        QA_FILES.put("qa_facts.txt,", GameMode.IS_THIS_A_FACT);
        QA_FILES.put("qa_unscramble.txt", GameMode.UNSCRAMBLE);
        QA_FILES.put("qa_word_up.txt", GameMode.WORD_UP);
    }


}
