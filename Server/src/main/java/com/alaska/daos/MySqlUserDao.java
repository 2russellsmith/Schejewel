package com.alaska.daos;

import com.alaska.models.User;
import com.alaska.utils.exceptions.UserNotFoundException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

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
    public User readUser(String email) throws UserNotFoundException{
        String sql = "SELECT * FROM user WHERE email = ?";
        User user = new User();

        try (Connection connection = datasource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();

            if(rs.next()){
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setCompanyId(rs.getInt("company_id"));
            }else{
                throw new UserNotFoundException("The user " + email + " was not found");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return user;
    }

    @Override
    public Set<String> readUserRoles(User user) {
        String sql = "SELECT description FROM user_privileges up, privilege p WHERE up.privilege_id = p.id AND up.user_id = ?";
        Set<String> roles = new HashSet<>();

        try (Connection connection = datasource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, user.getId());
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                roles.add(rs.getString("description"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return roles;
    }
}
