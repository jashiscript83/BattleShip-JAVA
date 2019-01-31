package com.example.salvo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

@Entity
public class Game {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;


    private Date date = new Date();;

    @OneToMany(mappedBy="game", fetch=FetchType.EAGER)
    private Set<GamePlayer> gamePlayers = new LinkedHashSet<>();

    public Set<Score> getScores() {
        return scores;
    }

    public void setScores(Set<Score> scores) {
        this.scores = scores;
    }

    @OneToMany(mappedBy="game", fetch=FetchType.EAGER)
    private Set<Score> scores ;


    public void addGameplayer(GamePlayer gamePlayer) {
        gamePlayer.setGame(this);

        this.gamePlayers.add(gamePlayer);

    }

    public Game(){


    }



    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date= date;
    }

    @JsonIgnore
    public Set<GamePlayer> getGamePlayers() {
        return gamePlayers;
    }

    public void setGamePlayers(Set<GamePlayer> gamePlayers) {
        this.gamePlayers = gamePlayers;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }


    public List<Player> getPlayers() {
        return this.gamePlayers.stream().map(gp -> gp.getPlayer()).collect(toList());
    }

}
