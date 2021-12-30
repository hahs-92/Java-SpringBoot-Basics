package com.fundaments.springboot.fundaments.repository;

import java.time.LocalDate;
import java.util.*;

import com.fundaments.springboot.fundaments.dto.UserDto;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import com.fundaments.springboot.fundaments.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//JpaRepository recibe La entidad(User) y el tipo del id
//esta interfas nos tiene varios metodos como findAll()
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //consulta con JQPL
    @Query("SELECT u FROM User u WHERE u.email=?1")
    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.name LIKE ?1%")
    List<User> findAndSort(String name, Sort sort);

    //Query methods
    List<User> findByName(String name);

    Optional<User> findByEmailAndName( String email,String name);

    //con sentencia LIKE
    List<User> findByNameLike(String name);

    //OR sentence
    List<User> findByNameOrEmail(String name, String email);

    //BETWEEN
    List<User> findByBirthDateBetween(LocalDate start, LocalDate end);

    //DESCENDING LIKE
    List<User> findByNameLikeOrderByIdDesc(String name);

    //CONTAINIG
    List<User> findByNameContaining(String name);

    //IGNORECASE
    List<User> findByNameIgnoreCase(String name);


    //JPQL WITH NAMED PARAMS
    @Query("SELECT new com.fundaments.springboot.fundaments.dto.UserDto(u.id, u.name, u.birthDate)" +
            " FROM User u" +
            " WHERE u.birthDate=:dateParam " +
            " AND u.email=:emailParam"
    )
    Optional<UserDto> getAllByBirthDateAndEmail(@Param("dateParam") LocalDate date,
                                                @Param("emailParam") String email
    );

    //MY EXAMPLE WITH JPQL
    @Query("SELECT new com.fundaments.springboot.fundaments.dto.UserDto(u.id, u.name, u.birthDate)" +
            " FROM User u " +
            " WHERE u.name=:nameParam"
    )
    Optional<UserDto> getUserByName(@Param("nameParam") String name);
}
