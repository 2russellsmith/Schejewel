package com.alaska.daos;

import com.alaska.models.User;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
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
        String sql = "INSERT INTO user(name, email, password, company_id) values(?,?,?,?)";

        try (Connection connection = datasource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getCompanyId());
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();
            if(rs.next()){
                user.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return user;
    }

    @Override
    public User readUser(User user) {
        String sql = "SELECT * FROM user WHERE email = ?";
        User dbUser = new User();

        try (Connection connection = datasource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, user.getEmail());
            ResultSet rs = statement.executeQuery();

            if(rs.next()){
                dbUser.setId(rs.getInt("id"));
                dbUser.setName(rs.getString("name"));
                dbUser.setEmail(rs.getString("email"));
                dbUser.setPassword(rs.getString("password"));
                dbUser.setCompanyId(rs.getInt("company_id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return dbUser;
    }

    @Override
    public ArrayList<User> readUsers() {
        String sql = "SELECT * FROM user";
        ArrayList<User> users = new ArrayList<>();

        try (Connection connection = datasource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setCompanyId(rs.getInt("company_id"));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }
}
