package com.alaska.daos;

import com.alaska.models.Message;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySqlExampleDao implements ExampleDao {
    private DataSource datasource;

    public MySqlExampleDao(){
        try{
            Context context = new InitialContext();
            this.datasource = (DataSource)context.lookup("java:comp/env/jdbc/mysql");
        }catch(NamingException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Message readMessage() {
        Message message = new Message();
        String sql = "SELECT * FROM example";

        try (Connection connection = datasource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                message.setHeader(resultSet.getString("header"));
                message.setBody(resultSet.getString("body"));
                message.setPage(resultSet.getInt("page"));
            }

        }catch(SQLException e){
            throw new RuntimeException(e);
        }

        return message;
    }
}
