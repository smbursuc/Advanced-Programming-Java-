package com.bursucserban.tema11;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/relations")
public class RelationshipController
{
    private final List<Relationship> relations = new ArrayList<>();
    private UserController uc = new UserController();
    public RelationshipController() {
        for(User user : uc.getUsers())
        {
            relations.add(new Relationship(user));
        }
    }

    @GetMapping(value = "/{id}")
    public Relationship findById(@PathVariable("id") int id)
    {
        return relations.stream()
                .filter(relationship -> relationship.getUser().getId() == id).collect(Collectors.toList()).get(0);
    }

    @GetMapping
    public List<Relationship> getRelations() {
        return relations;
    }

    @PostMapping
    public int createRelation(@RequestParam String user,@RequestParam String friend) {
        boolean found = true;
        for(User usr : uc.getUsers())
        {
            if(usr.getName()==user)
                found=true;
        }
        if(!found)
        {
            return 0;
        }
        for(Relationship relationship : relations)
        {
            if(relationship.getUser().getName().equals(user))
            {
                relationship.getUserFriends().add(uc.getUsers().stream().filter(usr -> usr.getName().equals(friend)).collect(Collectors.toList()).get(0));
            }
        }
        return 1;
    }

    @PostMapping(value = "/obj", consumes="application/json")
    public ResponseEntity<String>
    createRelation(@RequestBody Relationship relationship) {
        relations.add(relationship);
        return new ResponseEntity<>(
                "Relationship created successfully ", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateRelation(
            @PathVariable int id, @RequestParam String friend)
    {
        Relationship relationship = findById(id);
        if (relationship == null) {
            return new ResponseEntity<>(
                    "Relationship not found", HttpStatus.NOT_FOUND); //or GONE
        }
        relationship.getUserFriends().add(uc.getUsers().stream().filter(user -> user.getName().equals(friend)).collect(Collectors.toList()).get(0));
        return new ResponseEntity<>(
                "Relationship updated successsfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteRelationship(@PathVariable int id, @RequestParam String friend)
    {
        Relationship relationship = findById(id);
        if (relationship == null) {
            return new ResponseEntity<>(
                    "Relationship not found", HttpStatus.GONE);
        }
        relationship.getUserFriends().removeIf(user -> user.getName().equals(friend));
        return new ResponseEntity<>("Relationship removed", HttpStatus.OK);
    }




}