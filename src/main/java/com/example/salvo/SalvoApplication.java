package com.example.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SalvoApplication {


    public static void main(String[] args) {
        SpringApplication.run(SalvoApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(PlayerRepository repository,GameRepository gamerepository,GamePlayerRepository gameplayerrepository, ShipRepository shipRepository) {
        return (args) -> {
            Player p1 = new Player("j.bauer@ctu.gov");
            repository.save(p1);
            Player p2 = new Player(  "kim_bauer@gmail.com");
            repository.save(p2);
            Player p3 = new Player("t.almeida @ctu.gov");
            repository.save(p3);
            Player p4 = new Player("c.obrian@ctu.gov");
            repository.save(p4);

            Game g1 = new Game();
            gamerepository.save(g1);
            Game g2 = new Game();
            gamerepository.save(g2);
            Game g3 = new Game();
            gamerepository.save(g3);
            Game g4 = new Game();
            gamerepository.save(g4);
            Game g5 = new Game();
            gamerepository.save(g5);
            Game g6 = new Game();
            gamerepository.save(g6);
            Game g7 = new Game();
            gamerepository.save(g7);
            Game g8 = new Game();
            gamerepository.save(g8);

            GamePlayer gp1 = new GamePlayer(g1,p1);
            gameplayerrepository.save(gp1);
            GamePlayer gp2 = new GamePlayer(g1,p3);
            gameplayerrepository.save(gp2);

            GamePlayer gp3 = new GamePlayer(g2,p1);
            gameplayerrepository.save(gp3);
            GamePlayer gp4 = new GamePlayer(g2,p3);
            gameplayerrepository.save(gp4);

            GamePlayer gp5 = new GamePlayer(g3,p3);
            gameplayerrepository.save(gp5);
            GamePlayer gp6 = new GamePlayer(g3,p4);
            gameplayerrepository.save(gp6);

            GamePlayer gp7 = new GamePlayer(g4,p2);
            gameplayerrepository.save(gp7);
            GamePlayer gp8 = new GamePlayer(g4,p1);
            gameplayerrepository.save(gp8);

            GamePlayer gp9 = new GamePlayer(g5,p3);
            gameplayerrepository.save(gp9);
            GamePlayer gp10 = new GamePlayer(g5,p1);
            gameplayerrepository.save(gp10);

            GamePlayer gp11 = new GamePlayer(g6,p2);
            gameplayerrepository.save(gp11);

            GamePlayer gp13 = new GamePlayer(g7,p4);
            gameplayerrepository.save(gp13);

            GamePlayer gp15 = new GamePlayer(g8,p2);
            gameplayerrepository.save(gp15);
            GamePlayer gp16 = new GamePlayer(g8,p4);
            gameplayerrepository.save(gp16);

            List<String> locations1 = Arrays.asList("H2", "H3", "H4");
            List<String> locations2 = Arrays.asList("E1", "F1", "G1");
            List<String> locations3 = Arrays.asList("B4", "B5");
            List<String> locations4 = Arrays.asList("B5", "C5", "D5");
            List<String> locations5 = Arrays.asList("F1", "F2");
            List<String> locations6 = Arrays.asList("B5", "C5", "D5");
            List<String> locations7 = Arrays.asList("C6", "C7");
            List<String> locations8 = Arrays.asList("A2", "A3", "A4");
            List<String> locations9 = Arrays.asList("G6", "H6");
            List<String> locations10 = Arrays.asList("B5", "C5", "D5");
            List<String> locations11 = Arrays.asList("C6", "C7");
            List<String> locations12 = Arrays.asList("A2", "A3", "A4");
            List<String> locations13 = Arrays.asList("G6", "H6");
            List<String> locations14 = Arrays.asList("B5", "C5", "D5");
            List<String> locations15 = Arrays.asList("C6", "C7");
            List<String> locations16 = Arrays.asList("A2", "A3", "A4");
            List<String> locations17 = Arrays.asList("G6", "H6");
            List<String> locations18 = Arrays.asList("B5", "C5", "D5");
            List<String> locations19 = Arrays.asList("C6", "C7");
            List<String> locations20 = Arrays.asList("A2", "A3", "A4");
            List<String> locations21 = Arrays.asList("G6", "H6");
            List<String> locations22 = Arrays.asList("B5", "C5", "D5");
            List<String> locations23 = Arrays.asList("C6", "C7");
            List<String> locations24 = Arrays.asList("B5", "C5", "D5");
            List<String> locations25 = Arrays.asList("C6","C7");
            List<String> locations26 = Arrays.asList("A2", "A3", "A4");
            List<String> locations27 = Arrays.asList("G6", "H6");

            //game 1
            Ship ship1 = new Ship(gp1,locations1,"Destroyer");
            gp1.addShip(ship1);
            shipRepository.save(ship1);

            Ship ship2 = new Ship(gp1,locations2,"Submarine");
            gp1.addShip(ship2);
            shipRepository.save(ship2);

            Ship ship3 = new Ship(gp1,locations3,"Patrol Boat");
            gp1.addShip(ship3);
            shipRepository.save(ship3);

            Ship ship4 = new Ship(gp2,locations4,"Destroyer");
            gp2.addShip(ship4);
            shipRepository.save(ship4);

            Ship ship5 = new Ship(gp2,locations5,"Patrol Boat");
            gp2.addShip(ship5);
            shipRepository.save(ship5);

            //game 2
            Ship ship6 = new Ship(gp3,locations6,"Destroyer");
            gp3.addShip(ship6);
            shipRepository.save(ship6);

            Ship ship7 = new Ship(gp3,locations7,"Patrol Boat");
            gp3.addShip(ship7);
            shipRepository.save(ship7);

            Ship ship8 = new Ship(gp4,locations8,"Submarine");
            gp4.addShip(ship8);
            shipRepository.save(ship8);

            Ship ship9 = new Ship(gp4,locations9,"Patrol Boat");
            gp4.addShip(ship9);
            shipRepository.save(ship9);

            //game3
            Ship ship10 = new Ship(gp5,locations10,"Destroyer");
            gp5.addShip(ship10);
            shipRepository.save(ship10);

            Ship ship11 = new Ship(gp5,locations11,"Patrol Boat");
            gp5.addShip(ship11);
            shipRepository.save(ship11);

            Ship ship12 = new Ship(gp6,locations12,"Submarine");
            gp6.addShip(ship12);
            shipRepository.save(ship12);

            Ship ship13 = new Ship(gp6,locations13,"Patrol Boat");
            gp6.addShip(ship13);
            shipRepository.save(ship13);

            //game4
            Ship ship14 = new Ship(gp7,locations14,"Destroyer");
            gp7.addShip(ship14);
            shipRepository.save(ship14);

            Ship ship15 = new Ship(gp7,locations15,"Patrol Boat");
            gp7.addShip(ship15);
            shipRepository.save(ship15);

            Ship ship16 = new Ship(gp8,locations16,"Submarine");
            gp8.addShip(ship16);
            shipRepository.save(ship16);

            Ship ship17 = new Ship(gp8,locations17,"Patrol Boat");
            gp8.addShip(ship17);
            shipRepository.save(ship17);

            //game5
            Ship ship18 = new Ship(gp9,locations18,"Destroyer");
            gp9.addShip(ship18);
            shipRepository.save(ship18);

            Ship ship19 = new Ship(gp9,locations19,"Patrol Boat");
            gp9.addShip(ship19);
            shipRepository.save(ship19);

            Ship ship20 = new Ship(gp10,locations20,"Submarine");
            gp10.addShip(ship20);
            shipRepository.save(ship20);

            Ship ship21 = new Ship(gp10,locations21,"Patrol Boat");
            gp10.addShip(ship21);
            shipRepository.save(ship21);

            //game6
            Ship ship22 = new Ship(gp11,locations22,"Destroyer");
            gp11.addShip(ship22);
            shipRepository.save(ship22);

            Ship ship23 = new Ship(gp11,locations23,"Patrol Boat");
            gp11.addShip(ship23);
            shipRepository.save(ship23);

            //game8
            Ship ship24 = new Ship(gp15,locations24,"Destroyer");
            gp15.addShip(ship24);
            shipRepository.save(ship24);

            Ship ship25 = new Ship(gp15,locations25,"Patrol Boat");
            gp15.addShip(ship25);
            shipRepository.save(ship25);

            Ship ship26 = new Ship(gp16,locations26,"Submarine");
            gp16.addShip(ship26);
            shipRepository.save(ship26);

            Ship ship27 = new Ship(gp16,locations27,"Patrol Boat");
            gp16.addShip(ship27);
            shipRepository.save(ship27);



        };
    }
}

