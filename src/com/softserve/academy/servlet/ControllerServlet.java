package com.softserve.academy.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softserve.academy.util.Context;



@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

	
	
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		try {
			switch(action) {
			case "/new":
					Context.getInstance().getItemService().vievNewFrom(request, response);
					break;
			case "/edit":
					Context.getInstance().getItemService().vievEdtiFrom(request, response);
					break;
			case "/update":
					Context.getInstance().getItemService().updateItem(request, response);
					break;
			case "/delete":
					Context.getInstance().getItemService().deleteItem(request, response);
					break;	
			case "/list":
					Context.getInstance().getItemService().listItemi(request,response);
					break;
			case "/newacc":
					Context.getInstance().getUserService().vievNewFromUser(request, response);
					break;
			case "/logout":
					Context.getInstance().getUserService().logout(request, response);
					break;
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch(action) {
			case "/insert":
					Context.getInstance().getItemService().insertItem(request, response);
					break;
			case "/edit":
					Context.getInstance().getItemService().vievEdtiFrom(request, response);
					break;
			case "/update":
					Context.getInstance().getItemService().updateItem(request, response);
					break;
			case "/adduser":
					Context.getInstance().getUserService().insertNewUSer(request, response);
					break;
			
			default :
					Context.getInstance().getUserService().	userValidation(request, response);
					break;
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			}
	
	}
	
	
	
	
}
