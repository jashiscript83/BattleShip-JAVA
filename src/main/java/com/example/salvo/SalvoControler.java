package com.example.salvo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class SalvoControler {
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private GameRepository gamerepo;
    @Autowired
    private GamePlayerRepository gamePlayerRepository;

    @Autowired
    private ShipRepository shipRepository;


    @RequestMapping("/games")
    public Map<String, Object> getAllGames(Authentication authentication) {

        Map<String, Object> DTO = new LinkedHashMap<>();


        DTO.put("games", gamerepo.findAll().stream().map(g -> makeGameDTO2(g)).collect(Collectors.toList()));

        if (authentication == null) {
            DTO.put("User", null);
        } else {
            DTO.put("User", getCurrentUser(authentication).getUserName());

        }
        return DTO;
    }

    private Map<String, Object> makeScoresDTO(Set<Score> scores) {
        Map<String, Object> DTO = new LinkedHashMap<>();

        DTO.put("scores", scores.stream().map(score -> makeScoreDTO(score)).collect(Collectors.toList()));
        return DTO;
    }

    private Map<String, Object> makeScoreDTO(Score score) {
        Map<String, Object> DTO = new LinkedHashMap<>();
        DTO.put("player", score.getPlayer().getUserName());

        DTO.put("score", score.getScore());
        return DTO;

    }


    @RequestMapping("/game_view/{id}")
    public Map<String, Object> makeNewRouteDTO(@PathVariable Long id) {
        GamePlayer gamePlayer = gamePlayerRepository.findOne(id);
        Set<Ship> ships = gamePlayer.getShips();
        Set<Salvo> salvos = gamePlayer.getSalvos();
        Game game = gamePlayer.getGame();
        Set<GamePlayer> gamePlayers = gamePlayer.getGame().getGamePlayers();

        Map<String, Object> DTO = new LinkedHashMap<>();
        DTO.put("id Game-Player", gamePlayer.getId());
        DTO.put("game", makeGameDTO(gamePlayer.getGame()));
        DTO.put("ships", ships.stream().map(ship -> makeShipDTO(ship)).collect(Collectors.toList()));
        DTO.put("salvos", gamePlayers.stream().map(gp -> makeSalvosDTO(gp.getSalvos())).collect(Collectors.toList()));
        return DTO;

    }
//    public List<Player> getAll(Authentication authentication) {
//        return PlayerRepository.(authentication.getName());
//    }

    private Map<String, Object> makePlayerDTO(Player player) {
        Map<String, Object> DTO = new LinkedHashMap<>();

        DTO.put("id", player.getId());
        DTO.put("email", player.getUserName());
//        DTO.put("name", player.getUserName());
        return DTO;
    }


    private Map<String, Object> makeSalvosDTO(Set<Salvo> salvos) {
        Map<String, Object> DTO = new LinkedHashMap<>();
        DTO.put("salvos", salvos.stream().map(salvo -> makeSalvoDTO(salvo)).collect(Collectors.toList()));
        return DTO;
    }

    private Map<String, Object> makeSalvoDTO(Salvo salvo) {
        Map<String, Object> DTO = new LinkedHashMap<>();
        DTO.put("GamePlayerId", salvo.getGamePlayer().getId());
        DTO.put("Turn", salvo.getTurn());
        DTO.put("salvoLocations", salvo.getSalvoLocations());

        return DTO;
    }

    private Map<String, Object> makeShipDTO(Ship ship) {
        Map<String, Object> DTO = new LinkedHashMap<>();
        DTO.put("shipStyle", ship.getShipStyle());
        DTO.put("locations", ship.getLocations());

        return DTO;
    }

    private Map<String, Object> makeGameDTO2(Game game) {
        Map<String, Object> DTO = new LinkedHashMap<>();


        DTO.put("id", game.getId());
        DTO.put("date", game.getDate());
        DTO.put("gamePlayers", game.getGamePlayers().stream()
                .map(gp -> makeGamePlayerDTO(gp)).collect(Collectors.toList()));

        DTO.put("scores", game.getScores().stream().map(score -> makeScoreDTO(score)).collect(Collectors.toList()));

        return DTO;
    }

    private Map<String, Object> makeGameDTO(Game game) {
        Map<String, Object> DTO = new LinkedHashMap<>();

        DTO.put("id", game.getId());
        DTO.put("date", game.getDate());
        DTO.put("gamePlayers", game.getGamePlayers().stream()
                .map(gp -> makeGamePlayerDTO(gp)).collect(Collectors.toList()));

        return DTO;
    }

    private boolean isGuest(Authentication authentication) {
        return authentication == null || authentication instanceof AnonymousAuthenticationToken;
    }

    private Player getCurrentUser(Authentication authentication) {
        return playerRepository.findByUserName(authentication.getName());

    }

    private Map<String, Object> makeGamePlayerDTO(GamePlayer gamePlayer) {
        Map<String, Object> DTO = new LinkedHashMap<>();


        DTO.put("Id", gamePlayer.getId());
        DTO.put("Player", makePlayerDTO(gamePlayer.getPlayer()));
        return DTO;
    }




    @RequestMapping(path = "/players", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> createUser(@RequestParam String userName, @RequestParam String password) {


        if (userName.isEmpty() || password.isEmpty() ) {
            return new ResponseEntity<>(makeMap("error ", "empty fields"), HttpStatus.FORBIDDEN);
        }
        Player player = playerRepository.findByUserName(userName);
        if (player != null) {
            return new ResponseEntity<>(makeMap("error 409", "Username already exists"), HttpStatus.CONFLICT);
        }
        Player newPlayer = playerRepository.save(new Player(userName,password));
        return new ResponseEntity<>(makeMap("id", newPlayer.getId()) , HttpStatus.CREATED);
    }

    private Map<String, Object> makeMap(String key, Object value) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put(key, value);
        return map;
    }

}













//    @RequestMapping(path = "/players", method = RequestMethod.POST)
//    public ResponseEntity<Map<String, Object>> createPlayer(@RequestParam String player) {
//
//        if (player.isEmpty() ) {
//            return new ResponseEntity<>(makeMap("Error 201", "No name"), HttpStatus.FORBIDDEN);
//        }
//
//        if (player !=  null) {
//            return new ResponseEntity<>(makeMap("Error 403", "Username already exists"), HttpStatus.CONFLICT);
//        }
//
//        Player newPlayer =hgh ;
//        return new ResponseEntity<>(makeMap("id", newPlayer.getId()), HttpStatus.CREATED);
//    }
//
//    private Map<String, Object> makeMap(String key, Object value) {
//        Map<String, Object> map = new HashMap<>();
//        map.put(key, value);
//        return map;
//    }
//
//
//
//}