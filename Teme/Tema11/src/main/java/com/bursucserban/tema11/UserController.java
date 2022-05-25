package com.bursucserban.tema11;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController
{
    private final List<User> users = new ArrayList<>();

    public UserController() {
        users.add(new User(1, "a"));
        users.add(new User(2, "b"));
    }

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable("id") int id)
    {
        return users.stream()
                .filter(user -> user.getId() == id).collect(Collectors.toList()).get(0);
    }

    @GetMapping("/count")
    public int countProducts() {
        return users.size();
    }

    @GetMapping
    public List<User> getUsers() {
        return users;
    }

    @PostMapping
    public int createUser(@RequestParam String name) {
        int id = 1 + users.size();
        users.add(new User(id, name));
        return id;
    }

    @PostMapping(value = "/obj", consumes="application/json")
    public ResponseEntity<String>
    createUser(@RequestBody User user) {
        users.add(user);
        return new ResponseEntity<>(
                "User created successfully ", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(
            @PathVariable int id, @RequestParam String name)
    {
        User user = findById(id);
        if (user == null) {
            return new ResponseEntity<>(
                    "User not found", HttpStatus.NOT_FOUND); //or GONE
        }
        user.setName(name);
        return new ResponseEntity<>(
                "User updated successsfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id)
    {
        User user = findById(id);
        if (user == null) {
            return new ResponseEntity<>(
                    "User not found", HttpStatus.GONE);
        }
        users.remove(user);
        return new ResponseEntity<>("User removed", HttpStatus.OK);
    }




}
