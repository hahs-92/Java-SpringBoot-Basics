package com.fundaments.springboot.fundaments.controller;

import com.fundaments.springboot.fundaments.caseuse.CreateUser;
import com.fundaments.springboot.fundaments.caseuse.DeleteUser;
import com.fundaments.springboot.fundaments.caseuse.GetUser;
import com.fundaments.springboot.fundaments.caseuse.UpdateUser;
import com.fundaments.springboot.fundaments.entity.User;
import com.fundaments.springboot.fundaments.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    private UserRepository userRepository;

    public UserRestController(
            GetUser getUser,
            CreateUser createUser,
            DeleteUser deleteUser,
            UpdateUser updateUser,
            UserRepository userRepository
    ) {
        this.getUser = getUser;
        this.createUser = createUser;
        this.deleteUser = deleteUser;
        this.updateUser = updateUser;
        this.userRepository = userRepository;
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


    //PAGINACION
    /*
        JpaRepository extiende de PagingAndSortingRepository, la cual nos permite hacer paginacion
     */
    /*
    @GetMapping("/pageable")
    List<User> getUserPageable(@RequestParam int page, @RequestParam int size) {
        return userRepository.findAll(PageRequest.of(page, size)).getContent();
    }
    */

    //otra forma de hacer paginacion
    @GetMapping("/pageable")
    Page<User> getAlls(@PageableDefault(size = 5, page = 0)Pageable pageable) {
        Page<User>listUsers = userRepository.findAll(pageable);
        return listUsers;
    }


}
