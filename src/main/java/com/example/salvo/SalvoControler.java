package com.example.salvo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class SalvoControler {

    @Autowired
    private GameRepository gamerepo;
    @Autowired
    private  GamePlayerRepository gamePlayerRepository;

    @Autowired
    private  ShipRepository shipRepository;

    @RequestMapping("/games")
    public List<Object> getAllGames(){


        return gamerepo.findAll().stream()
                                    .map(g -> makeGameDTO2(g))
                .collect(Collectors.toList());
    }

    private  Map<String, Object>makeScoresDTO(Set<Score>scores){
        Map<String,Object> DTO = new HashMap<>();

        DTO.put("scores",scores.stream().map(score->makeScoreDTO(score)).collect(Collectors.toList()));
        return  DTO;
    }
    private  Map<String,Object> makeScoreDTO(Score score){
        Map<String,Object> DTO  = new HashMap<>();
        DTO.put("player",score.getPlayer().getUserName());

        DTO.put("score",score.getScore());
        return DTO;

    }


    @RequestMapping("/game_view/{id}")
  public  Map<String, Object>makeNewRouteDTO(@PathVariable Long id) {
        GamePlayer gamePlayer = gamePlayerRepository.findById(id).orElse(null);
        Set<Ship> ships = gamePlayer.getShips();
        Set<Salvo> salvos = gamePlayer.getSalvos();
        Game game = gamePlayer.getGame();
        Set<GamePlayer> gamePlayers = gamePlayer.getGame().getGamePlayers();

        Map<String,Object> DTO  = new HashMap<>();
        DTO.put("id Game-Player", gamePlayer.getId());
        DTO.put("game", makeGameDTO(gamePlayer.getGame()));
        DTO.put("ships", ships.stream().map(ship -> makeShipDTO(ship)).collect(Collectors.toList()) );
        DTO.put("salvos", gamePlayers.stream().map(gp-> makeSalvosDTO(gp.getSalvos())).collect(Collectors.toList()));
        return DTO;

    }


    private Map<String,Object> makeSalvosDTO(Set<Salvo> salvos ){
        Map<String,Object> DTO  = new HashMap<>();
        DTO.put("salvos", salvos.stream().map(salvo-> makeSalvoDTO(salvo)).collect(Collectors.toList()) );
        return DTO;
    }

    private Map<String,Object> makeSalvoDTO(Salvo salvo){
        Map<String,Object> DTO  = new HashMap<>();
DTO.put("GamePlayerId", salvo.getGamePlayer().getId());
        DTO.put("Turn", salvo.getTurn());
        DTO.put("salvoLocations", salvo.getSalvoLocations());

        return DTO;
    }

    private Map<String,Object> makeShipDTO(Ship ship){
        Map<String,Object> DTO  = new HashMap<>();
        DTO.put("shipStyle", ship.getShipStyle());
        DTO.put("locations", ship.getLocations());

        return DTO;
    }

    private Map<String,Object> makeGameDTO2(Game game){
        Map<String,Object> DTO  = new HashMap<>();


        DTO.put("id", game.getId());
        DTO.put("date", game.getDate());
        DTO.put("gamePlayers",game.getGamePlayers().stream()
                                                    .map(gp ->makeGamePlayerDTO(gp)).collect(Collectors.toList()));
        DTO.put("scores", game.getScores().stream().map(score -> makeScoreDTO(score)).collect(Collectors.toList()));

        return DTO;
    }
    private Map<String,Object> makeGameDTO(Game game){
        Map<String,Object> DTO  = new HashMap<>();

        DTO.put("id", game.getId());
        DTO.put("date", game.getDate());
        DTO.put("gamePlayers",game.getGamePlayers().stream()
                .map(gp ->makeGamePlayerDTO(gp)).collect(Collectors.toList()));

        return DTO;
    }

    private Map<String,Object> makeGamePlayerDTO(GamePlayer gamePlayer){
        Map<String,Object> DTO  = new HashMap<>();


        DTO.put("Id", gamePlayer.getId());
        DTO.put("Player",makePlayerDTO(gamePlayer.getPlayer()));
        return DTO;
    }

    private Map<String,Object> makePlayerDTO(Player player){
        Map<String,Object> DTO  = new HashMap<>();

        DTO.put("id", player.getId());
        DTO.put("email", player.getUserName());
        return DTO;
    }

//
//@RequestMapping("/game_view/nn")
// private   Map<String, Object>makeNewRouteDTO(Game game){
//    Map<String,Object> DTO  = new HashMap<>();
//    DTO.put("id", game.getId());
//    DTO.put("gamePlayers",game.getGamePlayers().stream()
//            .map(gp ->makeGamePlayerDTO(gp)).collect(Collectors.toList()));
//    return  DTO;
//};
}