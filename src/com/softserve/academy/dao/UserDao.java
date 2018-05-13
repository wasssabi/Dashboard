package com.softserve.academy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.softserve.academy.entity.UserEntity;


public class UserDao {

	
	
	 private String jdbcURL;
	    private String jdbcUsername;
	    private String jdbcPassword;
	    private Connection jdbcConnection;
	   
	    
	public UserDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
			super();
			this.jdbcURL = jdbcURL;
			this.jdbcUsername = jdbcUsername;
			this.jdbcPassword = jdbcPassword;
			
		}

	protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
     
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

	public UserDao() {	}

	public boolean checkUser(String login,String password) throws SQLException{
		boolean st = false;
		try {
		String sql = "SELECT * from users where login=? and password=?";
		connect();
		PreparedStatement preparedStatement = jdbcConnection.prepareStatement(sql);
		preparedStatement.setString(1, login);
		preparedStatement.setString(2, password);
		ResultSet resultSet = preparedStatement.executeQuery();
		st=resultSet.next();}
		catch (Exception e) {
			e.printStackTrace();
		}
		return st;
	}
	
	public boolean addUser(UserEntity entity) throws SQLException{
		
	
		String sql = "insert into users(login,password) values (?, ?);";
		connect();
		PreparedStatement preparedStatement = jdbcConnection.prepareStatement(sql);
		preparedStatement.setString(1, entity.getLogin());
		preparedStatement.setString(2, entity.getPasswd());
		
		boolean rowIn = preparedStatement.executeUpdate()>0;
		preparedStatement.close();
		disconnect();
		return rowIn;
	}
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	