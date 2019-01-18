package com.example.salvo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;


@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")

    private long id;

    @JsonIgnore
    public Set<Score> getScores() {
        return scores;
    }


    @OneToMany(mappedBy="player", fetch=FetchType.EAGER)
    private Set<GamePlayer> gamePlayers ;

    @OneToMany(mappedBy="player", fetch=FetchType.EAGER)
    private Set<Score> scores =  new LinkedHashSet<>();

    public void setScores(Set<Score> scores) {
        this.scores= scores;
    }

    public void addGamePlayer(GamePlayer gameplayer) {
        gameplayer.setPlayer(this);
        this.gamePlayers.add(gameplayer);
    }

    public void addScore(Score score) {
        score.setPlayer(this);
        this.scores.add(score);
    }

        private String userName;

        public Player() { }

        public Player(String email) {

            this.userName = email;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<GamePlayer> getGamePlayers() {
        return gamePlayers;
    }

    public void setGamePlayers(Set<GamePlayer> gamePlayers) {
        this.gamePlayers = gamePlayers;
    }

    @JsonIgnore
    public List<Game> getGames() {
        return this.gamePlayers.stream().map(gp -> gp.getGame()).collect(toList());
    }

}

