package com.softserve.academy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.softserve.academy.entity.ItemEntity;


public class ItemDao {

	 private String jdbcURL;
	    private String jdbcUsername;
	    private String jdbcPassword;
	    private Connection jdbcConnection;
	     
	    public ItemDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
	        this.jdbcURL = jdbcURL;
	        this.jdbcUsername = jdbcUsername;
	        this.jdbcPassword = jdbcPassword;
	    }
	     
	    public ItemDao() {
			// TODO Auto-generated constructor stub
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
	
	public boolean insertItem(ItemEntity entity) throws SQLException{
		String sql = "INSERT INTO items"
				+ " (title, description,userlogin) VALUES (?, ?, ?)";
		connect();
		PreparedStatement preparedStatement = jdbcConnection.prepareStatement(sql);
		preparedStatement.setString(1, entity.getTitle());
		preparedStatement.setString(2, entity.getDescription());
		preparedStatement.setString(3, entity.getUserlogin());
		
		boolean rowIn = preparedStatement.executeUpdate()>0;
		preparedStatement.close();
		disconnect();
		return rowIn;
	}
	
	public List<ItemEntity> listAllItems() throws SQLException {
        List<ItemEntity> listItems = new ArrayList<>();
         
        String sql = "SELECT * FROM items";
        
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        
         
        while (resultSet.next()) {
        	Long id = resultSet.getLong("id");
            String title = resultSet.getString("title");
            String description = resultSet.getString("description");
            String userlogin = resultSet.getString("userlogin");
             
            ItemEntity entity = new ItemEntity(id,title, description, userlogin);
            listItems.add(entity);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listItems;
    }
	public List<ItemEntity> getItem(String userlogin) throws SQLException {
		
        String sql = "SELECT * FROM items WHERE userlogin = ?";
        List<ItemEntity> listItems = new ArrayList<>();
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, userlogin);
         
        ResultSet resultSet = statement.executeQuery();
         
        while (resultSet.next()) {
        	Long id = resultSet.getLong("id");
            String title = resultSet.getString("title");
            String description = resultSet.getString("description");
            String userlogins = resultSet.getString("userlogin");
           
             
            ItemEntity  entity = new ItemEntity(id,title, description, userlogins);
            listItems.add(entity);
        }
         
        resultSet.close();
        statement.close();
         
        return listItems;
    }
	
	
public ItemEntity getItemi(Long id) throws SQLException {
		
        String sql = "SELECT * FROM items WHERE id = ?";
        ItemEntity entity =null;
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setLong(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
        	Long ids = resultSet.getLong("id");
            String title = resultSet.getString("title");
            String description = resultSet.getString("description");
            String userlogins = resultSet.getString("userlogin");
           
             
            entity = new ItemEntity(ids,title, description, userlogins);
            
        }
         
        resultSet.close();
        statement.close();
         
        return entity;
    }
	public boolean deleteItem(ItemEntity entity) throws SQLException {
        String sql = "DELETE FROM items where id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setLong	(1, entity.getId());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
	public boolean updateItem(ItemEntity entity) throws SQLException {
        String sql = "UPDATE items SET title = ?, description = ?,userlogin=?";
        sql += " WHERE id = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, entity.getTitle());
        statement.setString(2, entity.getDescription());
        statement.setString(3, entity.getUserlogin());
        statement.setLong(4, entity.getId());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
}
	
	
	