package com.fundaments.springboot.fundaments.controller;

import com.fundaments.springboot.fundaments.caseuse.CreateUser;
import com.fundaments.springboot.fundaments.caseuse.DeleteUser;
import com.fundaments.springboot.fundaments.caseuse.GetUser;
import com.fundaments.springboot.fundaments.caseuse.UpdateUser;
import com.fundaments.springboot.fundaments.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //hereda de @Controller y los metodos que creemos se formateen a JSON
@RequestMapping("/api/users")//ruta http://localhost:8081/app/api/users/
public class UserRestController {
    //casos de uso
    private GetUser getUser;
    private CreateUser createUser;
    private DeleteUser deleteUser;
    private UpdateUser updateUser;


    public UserRestController(
            GetUser getUser,
            CreateUser createUser,
            DeleteUser deleteUser,
            UpdateUser updateUser
    ) {
        this.getUser = getUser;
        this.createUser = createUser;
        this.deleteUser = deleteUser;
        this.updateUser = updateUser;
    }

    @GetMapping("/") //ruta
    List<User> get() {
        return getUser.getAll();
    }

    @PostMapping("/")
    ResponseEntity<User> newUser(@RequestBody User newUser) {
        return new ResponseEntity<>(createUser.save(newUser), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity deleteUser(@PathVariable Long id) {
        deleteUser.remove(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id) {
        return  new ResponseEntity<>(updateUser.update(user, id), HttpStatus.OK);
    }

}
