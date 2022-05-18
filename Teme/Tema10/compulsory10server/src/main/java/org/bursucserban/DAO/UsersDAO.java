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



public class UsersDAO {

    public void create(String name) throws SQLException {
        Connection con = Database.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select user_id from users where user_id=(select count(*) from users)");

        int lastID=0;
        while(rs.next())
        {
            lastID=rs.getInt(1);
        }

        try (PreparedStatement pstmt = con
                .prepareStatement("insert into users(user_id,username) values (?,?)")) {
            pstmt.setInt(1, lastID+1);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
        }
        Database.getConnection().commit();
    }

    public List<User> findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select user_id,username from users where username='" + name + "'")) {
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
             ResultSet rs = stmt.executeQuery("select user_id,username from users where user_id='" + id + "'")) {
            List<User> result =  new ArrayList<>();

            while (rs.next())
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
             ResultSet rs = stmt.executeQuery("select * from users")) {
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