package org.bursucserban.DAO;

import org.bursucserban.Database;
import org.bursucserban.Entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FriendsDAO {

    public void create(int id1, int id2) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con
                .prepareStatement("insert into friends(user_id,friend_id) values (?,?)")) {
            pstmt.setInt(1, id1);
            pstmt.setInt(2, id2);
            pstmt.executeUpdate();
        }

        Database.getConnection().commit();

        try (PreparedStatement pstmt = con
                .prepareStatement("insert into friends(user_id,friend_id) values (?,?)")) {
            pstmt.setInt(1, id2);
            pstmt.setInt(2, id1);
            pstmt.executeUpdate();
        }

        Database.getConnection().commit();
    }

    public List<User> findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select user_id, username from users where user_id=(select friend_id from friends where user_id=(select user_id from users where username='" + name + "'))")) {
            List<User> result = new ArrayList<>();

            while(rs.next())
            {
                User user = new User(rs.getInt(1),rs.getString(2));
                result.add(user);
            }

            return result;
        }
    }

    public List<User> findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select user_id, username from users where user_id = (select friend_id from friends where user_id='" + id + "')")) {
            List<User> result =  new ArrayList<>();

            while(rs.next())
            {
                User user = new User(rs.getInt(1),rs.getString(2));
                result.add(user);
            }

            return result;
        }

    }

    public List<User> findAll() throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from friends")) {
            List<User> result =  new ArrayList<>();

            while (rs.next())
            {
                User user = new User(rs.getInt(1),rs.getString(2));
                result.add(user);
            }

            return result;
        }
    }
}
