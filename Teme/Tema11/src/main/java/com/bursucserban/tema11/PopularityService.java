package com.bursucserban.tema11;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/popularity")


public class PopularityService
{
    private RelationshipController rc = new RelationshipController();

    @GetMapping
    public List<User> getPopularity(@RequestParam int k) {
        List<Relationship> sortedList = rc.getRelations();
        sortedList.stream().sorted((r1,r2) -> Integer.compare(r1.getUserFriends().size(), r2.getUserFriends().size()));
        List<User> popularityList = sortedList.stream().map(relationship -> relationship.getUser()).limit(k).collect(Collectors.toList());
        return popularityList;
    }
}
