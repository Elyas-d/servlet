package com.web;

public class DatabaseConnector {
    private java.sql.Connection connection;
    private final String url;
    private final String username;
    private final String password;

    public DatabaseConnector (String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void connect() throws java.sql.SQLException,java.lang.ClassNotFoundException   {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = java.sql.DriverManager.getConnection(url, username, password);
        connection.setAutoCommit(true);
    }

    public void disconnect() throws java.sql.SQLException{
        if (connection != null) {
            connection.close();
        }
    }
    public void insertSignUpInfo(String name, String email, String department) throws java.sql.SQLException {
        String query = "INSERT INTO users (name, email, department) VALUES (?,?,?)";
        java.sql.PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1,name);
        stmt.setString(2,email);
        stmt.setString(3,department);
        stmt.executeUpdate();
    }
    public void deleteUser(String name)throws java.sql.SQLException {
        String query = "delete from users where name = ?";
        java.sql.PreparedStatement stmt=connection.prepareStatement(query);
        stmt.setString(1, name);
        stmt.executeUpdate();
    }
    public void updateUserInfo(String name,String newname)throws java.sql.SQLException{
    
        String query ="update table users set name= ? where name= ?";
        java.sql.PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, newname);
        stmt.setString(2, name);
    }
    public java.sql.ResultSet listUsers()throws java.sql.SQLException{
        String query = "select * from users";
        java.sql.PreparedStatement stmt = connection.prepareStatement(query);
        return stmt.executeQuery(query);
    }
}