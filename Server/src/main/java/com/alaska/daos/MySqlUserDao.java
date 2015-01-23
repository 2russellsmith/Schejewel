package com.alaska.daos;

import com.alaska.models.User;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySqlUserDao implements UserDao {
    private DataSource datasource;

    public MySqlUserDao(){
        try{
            Context context = new InitialContext();
            this.datasource = (DataSource)context.lookup("java:comp/env/jdbc/mysql");
        }catch(NamingException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public User createUser(User user) {
        String sql = "INSERT INTO users(email, password) values(?,?)";

        try (Connection connection = datasource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return user;
    }

    @Override
    public ArrayList<User> readUsers() {
        String sql = "SELECT * FROM users";
        ArrayList<User> users = new ArrayList<>();

        try (Connection connection = datasource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                User user = new User();
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }
}
