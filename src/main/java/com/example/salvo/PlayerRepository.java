package com.example.salvo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

public interface PlayerRepository extends JpaRepository<Player,Long> {

//    List<Player> findByUserName(String UserName, String password );


    Player findByUserName(@Param("userName") String userName);


}

