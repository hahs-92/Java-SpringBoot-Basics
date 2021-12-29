package com.fundaments.springboot.fundaments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fundaments.springboot.fundaments.entity.User;
import org.springframework.stereotype.Repository;

//JpaRepository recibe La entidad(User) y el tipo del id
//esta interfas nos tiene varios metodos como findAll()
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
