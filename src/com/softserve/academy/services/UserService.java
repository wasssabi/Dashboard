package com.softserve.academy.services;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.softserve.academy.dao.UserDao;

import com.softserve.academy.entity.UserEntity;
import com.softserve.academy.util.Context;

public class UserService {

	  public static final  String jdbcURL = "jdbc:mysql://localhost:3306/testi";
      public static final String jdbcUsername = "root";
      public static final  String jdbcPassword = "123456";
 
      
	
	
	public void vievNewFromUser(HttpServletRequest request, HttpServletResponse response)	throws
	SQLException, IOException, ServletException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("Register.jsp");
		dispatcher.forward(request, response);
	
	}
	
	public void insertNewUSer(HttpServletRequest request, HttpServletResponse response)	throws
	SQLException, IOException, ServletException{
		
		UserDao userDao = new UserDao(jdbcURL, jdbcUsername, jdbcPassword);
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		UserEntity userEntity = new UserEntity(login, password);
		userDao.addUser(userEntity);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
		dispatcher.forward(request, response);
		
		
	}
	
	
	public void logout(HttpServletRequest request, HttpServletResponse response)	throws
	SQLException, IOException, ServletException{
		HttpSession session = request.getSession();
		session.invalidate();
		RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
		dispatcher.forward(request, response);
	}
	public void userValidation(HttpServletRequest request, HttpServletResponse response)	throws
	SQLException, IOException, ServletException{
		String login=request.getParameter("login");
		String password=request.getParameter("password");
		UserEntity user = new UserEntity(login, password);
		UserDao userDao = new UserDao(jdbcURL, jdbcUsername, jdbcPassword);
			try {
				if(userDao.checkUser(login, password)) {
					
					HttpSession session  = request.getSession();
					session.setAttribute("login", login);
					session.setAttribute("user",user);
					Context.getInstance().getItemService().listItemi(request, response);
	
				}
				else {
				
					RequestDispatcher rs = request.getRequestDispatcher("Error.jsp");
					rs.include(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	

}
