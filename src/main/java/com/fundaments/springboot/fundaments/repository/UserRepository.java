package com.fundaments.springboot.fundaments.repository;

import java.util.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import com.fundaments.springboot.fundaments.entity.User;
import org.springframework.data.jpa.repository.Query;
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
}
