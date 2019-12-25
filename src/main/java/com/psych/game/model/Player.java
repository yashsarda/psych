package com.psych.game.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.List;


@Entity
@Table(name = "players")
public class Player extends Auditable {

    @Getter
    @Setter
    @NotBlank
    private String name;

    @Getter
    @Setter
    @URL
    private String psychFaceURL;

    @Getter
    @Setter
    @URL
    private String picURL;

    @Getter
    @Setter
    @OneToOne
    private Stats stats;

    // mapped by attribute tells that the Game table's players attribute is maintaining the data
    // so need to create a table for this to avoid duplication of data
    @Getter
    @Setter
    @ManyToMany(mappedBy = "players")
    private List<Game> games;

}
