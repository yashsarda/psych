package com.psych.game.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "games")
public class Game extends Auditable{

    @Getter
    @Setter
    @NotNull
    private int numRounds = 0;

    @Getter
    @Setter
    private int currentRound = 0;

    /**
     * for a map hibernate will create a structure like this
     * table name_:- game_player_stats
     * game_id, player_id, stat_id
     * ....     .....       .....
     * ....     .....       .....
     *
     * game_id and player_id will be PK
     */
    @Getter
    @Setter
    @ManyToMany
    private Map<Player, Stats> playerStats;


    @ManyToMany
    @Getter
    @Setter
    private List<Player> players;

    @Getter
    @Setter
    @NotNull
    private GameMode gameMode;

    @Getter
    @Setter
    @NotNull
    private GameStatus gameStatus = GameStatus.JOINING;

    @ManyToOne
    @NotNull
    @Getter
    @Setter
    private Player leader;

    @OneToMany(mappedBy = "game")
    @Getter
    @Setter
    private List<Round> rounds;


}
