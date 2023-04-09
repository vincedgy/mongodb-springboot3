package com.vincedgy.mongodbserver;

import com.vincedgy.mongodbserver.models.User;
import com.vincedgy.mongodbserver.services.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Log
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UsersController {
    @Autowired
    private UsersService usersService;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody User user) {
        log.info("save");
        return ResponseEntity.ok(usersService.save(user).getId());
    }

    @PatchMapping
    public ResponseEntity<String> update(@RequestBody User user) {
        log.info("update");
        return ResponseEntity.ok(usersService.save(user).getId());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("delete");
        usersService.delete(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        log.info("getUser");
        return usersService.getUserById(id).get();
    }


    @GetMapping
    public List<User> getAllUsers() {
        log.info("getAllUsers");
        return usersService.getAllUsers();
    }

    @GetMapping(params = "lastname")
    public List<User> getUsersByLastName(@RequestParam("lastname") String lastName) {
        log.info("getUsersByLastName");
        return usersService.getAllUsersByName(lastName);
    }

    @GetMapping(params = "email")
    public Optional<User> getUsersByEmail(@RequestParam("email") String email) {
        log.info("getUsersByEmail");
        return usersService.getUserByEmail(email);
    }
}
