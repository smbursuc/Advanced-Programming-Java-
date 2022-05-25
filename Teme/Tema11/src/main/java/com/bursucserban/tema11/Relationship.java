package com.bursucserban.tema11;

import java.util.ArrayList;
import java.util.List;

public class Relationship
{
    private User user;
    private List<User> userFriends;

    public Relationship(User user)
    {
        this.user = user;
        userFriends = new ArrayList<>();
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public List<User> getUserFriends()
    {
        return userFriends;
    }

    public void setUserFriends(List<User> userFriends)
    {
        this.userFriends = userFriends;
    }
}
