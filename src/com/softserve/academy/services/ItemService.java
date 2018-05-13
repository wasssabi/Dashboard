package com.softserve.academy.services;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.softserve.academy.dao.ItemDao;

import com.softserve.academy.entity.ItemEntity;

public class ItemService extends HttpServlet {
       public static final String jdbcURL = "jdbc:mysql://localhost:3306/testi";
       public static final  String jdbcUsername = "root";
       public static final  String jdbcPassword = "123456";
 
       
        
 
    
	
	private static final long serialVersionUID = 1L;
	
	
	public void listItemi(HttpServletRequest request, HttpServletResponse response)	throws
	SQLException, IOException, ServletException{
		
		ItemDao itemDao = new ItemDao(jdbcURL, jdbcUsername, jdbcPassword);
		HttpSession session  = request.getSession();
		String login = (String) session.getAttribute("login");
		
		
		List<ItemEntity> listItems = itemDao.getItem(login);
		
		request.setAttribute("listItems", listItems);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("ItemsList.jsp");
		
        dispatcher.forward(request, response);
	}
	

	
	public void vievNewFrom(HttpServletRequest request, HttpServletResponse response)	throws
	SQLException, IOException, ServletException{
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("NewItem.jsp");
		dispatcher.forward(request, response);
	}
	
	public void vievEdtiFrom(HttpServletRequest request, HttpServletResponse response)	throws
	SQLException, IOException, ServletException{
		ItemDao itemDao = new ItemDao(jdbcURL, jdbcUsername, jdbcPassword);
		Long id =Long.parseLong(request.getParameter("id"));
		ItemEntity existingItem = itemDao.getItemi(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("NewItem.jsp");
		request.setAttribute("item", existingItem);
		dispatcher.forward(request, response);
		
	}
	
	public void insertItem(HttpServletRequest request, HttpServletResponse response)	throws
	SQLException, IOException, ServletException{
		
		ItemDao itemDao = new ItemDao(jdbcURL, jdbcUsername, jdbcPassword);
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String userlogin = request.getParameter("userlogin");
		ItemEntity itemEntity = new ItemEntity(title, description, userlogin);
		itemDao.insertItem(itemEntity);
		response.sendRedirect("list");
	}
	
	public void updateItem(HttpServletRequest request, HttpServletResponse response)	throws
	SQLException, IOException, ServletException{
		
		ItemDao itemDao = new ItemDao(jdbcURL, jdbcUsername, jdbcPassword);
		Long id;
		id= Long.parseLong(request.getParameter("id"));
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String userlogin = request.getParameter("userlogin");
		
		ItemEntity entity = new ItemEntity(id, title, description, userlogin);
		itemDao.updateItem(entity);
		listItemi(request, response);
		
	}
	public void deleteItem(HttpServletRequest request, HttpServletResponse response)	throws
	SQLException, IOException, ServletException{
		ItemDao itemDao = new ItemDao(jdbcURL, jdbcUsername, jdbcPassword);
		Long id;
		id= Long.parseLong(request.getParameter("id"));
		ItemEntity entity = new ItemEntity(id);
		
		itemDao.deleteItem(entity);
		listItemi(request, response);
	}
	
	
}
