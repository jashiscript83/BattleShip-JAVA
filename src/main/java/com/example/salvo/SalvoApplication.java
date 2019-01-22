package com.example.salvo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SalvoApplication {


    public static void main(String[] args) {
        SpringApplication.run(SalvoApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(PlayerRepository repository,GameRepository gamerepository,
                                      GamePlayerRepository gameplayerrepository, ShipRepository shipRepository,
                                      SalvoRepository salvoRepository, ScoreRepository scoreRepository) {
        return (args) -> {
            Player p1 = new Player("j.bauer@ctu.gov", "AA");
            repository.save(p1);
            Player p2 = new Player("kim_bauer@gmail.com","BB");
            repository.save(p2);
            Player p3 = new Player("t.almeida @ctu.gov","CC");
            repository.save(p3);
            Player p4 = new Player("c.obrian@ctu.gov","DD");
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

            //salvoLocations
            List<String> salvoLocations1 = Arrays.asList("B4", "B5", "B6");
            List<String> salvoLocations2 = Arrays.asList("E1", "H3", "A2");
            List<String> salvoLocations3 = Arrays.asList("B5", "D5", "C7");
            List<String> salvoLocations4 = Arrays.asList("C5", "C6");
            List<String> salvoLocations5 = Arrays.asList("H1", "H2", "H3");
            List<String> salvoLocations6 = Arrays.asList("E1", "F2", "G3");
            List<String> salvoLocations7 = Arrays.asList("B5", "C6", "H1");
            List<String> salvoLocations8 = Arrays.asList("C5", "C7", "D5");
            List<String> salvoLocations9 = Arrays.asList("B5", "B6", "C7");
            List<String> salvoLocations10 = Arrays.asList("C6", "D6", "E6");
            List<String> salvoLocations11 = Arrays.asList("H1", "H8");
            List<String> salvoLocations12 = Arrays.asList("B5", "C5", "F1");
            List<String> salvoLocations13 = Arrays.asList("F2", "D5");
            List<String> salvoLocations14 = Arrays.asList("A2", "A4", "G6");
            List<String> salvoLocations15= Arrays.asList("A3", "H6");
            List<String> salvoLocations16 = Arrays.asList("G6", "H6", "A4");
            List<String> salvoLocations17 = Arrays.asList("A2", "A3", "D8");
            List<String> salvoLocations18 = Arrays.asList("A3", "A4", "F7");
            List<String> salvoLocations19 = Arrays.asList("A2", "G6", "H6");
            List<String> salvoLocations20 = Arrays.asList("A1", "A2", "A3");
            List<String> salvoLocations21 = Arrays.asList("G6", "G7", "G8");

            //salvos

            //game1.salvos
            Salvo salvo1 = new Salvo(gp1,salvoLocations12,1);
            gp1.addSalvo(salvo1);
            salvoRepository.save(salvo1);
            Salvo salvo2 = new Salvo(gp2,salvoLocations1,1);
            gp2.addSalvo(salvo2);
            salvoRepository.save(salvo2);

            Salvo salvo3 = new Salvo(gp1,salvoLocations13,2);
            gp1.addSalvo(salvo3);
            salvoRepository.save(salvo3);
            Salvo salvo4 = new Salvo(gp2,salvoLocations2,2);
            gp2.addSalvo(salvo4);
            salvoRepository.save(salvo4);

            //game2.salvos
            Salvo salvo5 = new Salvo(gp3,salvoLocations14,1);
            gp3.addSalvo(salvo5);
            salvoRepository.save(salvo5);
            Salvo salvo6 = new Salvo(gp4,salvoLocations3,1);
            gp4.addSalvo(salvo6);
            salvoRepository.save(salvo6);


            Salvo salvo7 = new Salvo(gp3,salvoLocations15,2);
            gp3.addSalvo(salvo7);
            salvoRepository.save(salvo7);
            Salvo salvo8 = new Salvo(gp4,salvoLocations4,2);
            gp4.addSalvo(salvo8);
            salvoRepository.save(salvo8);

            //game3.salvos
            Salvo salvo9 = new Salvo(gp5,salvoLocations16,1);
            gp5.addSalvo(salvo9);
            salvoRepository.save(salvo9);
            Salvo salvo10 = new Salvo(gp6,salvoLocations5,1);
            gp6.addSalvo(salvo10);
            salvoRepository.save(salvo10);

            Salvo salvo11 = new Salvo(gp5,salvoLocations17,2);
            gp5.addSalvo(salvo11);
            salvoRepository.save(salvo11);
            Salvo salvo12 = new Salvo(gp6,salvoLocations6,2);
            gp6.addSalvo(salvo12);
            salvoRepository.save(salvo12);

            //game4.salvos
            Salvo salvo13 = new Salvo(gp7,salvoLocations18,1);
            gp7.addSalvo(salvo13);
            salvoRepository.save(salvo13);
            Salvo salvo14 = new Salvo(gp8,salvoLocations7,1);
            gp8.addSalvo(salvo14);
            salvoRepository.save(salvo14);

            Salvo salvo15 = new Salvo(gp7,salvoLocations19,2);
            gp7.addSalvo(salvo15);
            salvoRepository.save(salvo15);
            Salvo salvo16 = new Salvo(gp8,salvoLocations8,2);
            gp8.addSalvo(salvo16);
            salvoRepository.save(salvo16);

            //game5.salvos

            Salvo salvo17 = new Salvo(gp9,salvoLocations20,1);
            gp9.addSalvo(salvo17);
            salvoRepository.save(salvo17);
            Salvo salvo18 = new Salvo(gp10,salvoLocations9,1);
            gp10.addSalvo(salvo18);
            salvoRepository.save(salvo18);

            Salvo salvo19 = new Salvo(gp9,salvoLocations21,2);
            gp9.addSalvo(salvo19);
            salvoRepository.save(salvo19);
            Salvo salvo20 = new Salvo(gp10,salvoLocations10,2);
            gp10.addSalvo(salvo20);
            salvoRepository.save(salvo20);



            Salvo salvo21 = new Salvo(gp10,salvoLocations11,3);
            gp10.addSalvo(salvo21);
            salvoRepository.save(salvo21);

            //scores

            //score game1

            Score score1  = new Score( g1,p1,1.0);
            p1.addScore(score1);
            scoreRepository.save(score1);

            Score score2  = new Score( g1,p4,0.0);
            p4.addScore(score2);
            scoreRepository.save(score2);

           //score game2

            Score score3  = new Score( g2,p1,0.5);
            p1.addScore(score3);
            scoreRepository.save(score3);

            Score score4  = new Score( g2,p4,0.5);
            p4.addScore(score4);
            scoreRepository.save(score4);

            //score game3


            Score score5  = new Score( g3,p4,1.0);
            p4.addScore(score5);
            scoreRepository.save(score5);

            Score score6  = new Score( g3,p3,0.0);
            p3.addScore(score6);
            scoreRepository.save(score6);

            //score game4

            Score score7  = new Score( g4,p4,0.5);
            p4.addScore(score7);
            scoreRepository.save(score7);

            Score score8  = new Score( g4,p1,0.5);
            p1.addScore(score8);
            scoreRepository.save(score8);






        };
    }
}

@Configuration
class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userName-> {
            Player player = playerRepository.findByUserName(userName);
            if (player != null) {
                return new User(player.getUserName(), player.getPassword(),
                        AuthorityUtils.createAuthorityList("USER"));
            } else {
                throw new UsernameNotFoundException("Unknown user: " + userName);
            }
        });

    }
}


@Configuration
@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/web/games.html").permitAll()
                .antMatchers("/api/games").permitAll()
                .antMatchers("/web/games.js").permitAll()

//                .antMatchers("/**").hasAuthority("USER")
                .and()
                .formLogin()
                .usernameParameter("userName")
                .passwordParameter("password")
                .loginPage("/api/login");

        http.logout().logoutUrl("/api/logout");
        // turn off checking for CSRF tokens
        http.csrf().disable();

        // if user is not authenticated, just send an authentication failure response
        http.exceptionHandling().authenticationEntryPoint((req, res, exc) -> res.sendError(HttpServletResponse.SC_UNAUTHORIZED));

        // if login is successful, just clear the flags asking for authentication
        http.formLogin().successHandler((req, res, auth) -> clearAuthenticationAttributes(req));

        // if login fails, just send an authentication failure response
        http.formLogin().failureHandler((req, res, exc) -> res.sendError(HttpServletResponse.SC_UNAUTHORIZED));

        // if logout is successful, just send a success response
        http.logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());
    }

    private void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        }

    }

}
