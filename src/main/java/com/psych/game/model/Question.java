package com.psych.game.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "questions")
public class Question extends Auditable{

    @Getter
    @Setter
    @NotBlank
    private String questionText;

    @Getter
    @Setter
    @NotBlank
    private String correctAnswer;

    @Getter
    @Setter
    @NotNull
    private GameMode gameMode;

    @OneToMany(mappedBy = "question")
    @Getter
    @Setter
    private List<EllenAnswer> ellenAnswers;

}
