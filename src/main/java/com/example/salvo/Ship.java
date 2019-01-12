package com.example.salvo;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="gamePlayer_id")
    private GamePlayer gamePlayer;


    private String shipStyle;

    @ElementCollection
    @Column(name="locations")
    private List<String> locations = new ArrayList<>();

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public Ship(){
}

    public Ship(GamePlayer gamePlayer, List<String>locations, String shipStyle ){

        this.gamePlayer = gamePlayer;
        this.locations = locations;
        this.shipStyle = shipStyle;
    }



    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }


    public String getShipStyle() {
        return shipStyle;
    }

    public void setShipStyle(String shipStyle) {
        this.shipStyle = shipStyle;
    }

    public GamePlayer getGamePlayer() {
        return gamePlayer;
    }

    public void setGamePlayer(GamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }
}


