package com.softserve.academy.util;

import com.softserve.academy.dao.ItemDao;
import com.softserve.academy.dao.UserDao;
import com.softserve.academy.services.ItemService;
import com.softserve.academy.services.UserService;

public class Context {
	private static volatile Context instance = null;

    //
    UserDao userDao;
    ItemDao itemDao;
    //
    UserService userService;
    ItemService itemService;
    

    public UserService getUserService() {
        return userService;
    }

    public ItemService getItemService() {
        return itemService;
    }

   

    private Context() {
        initComponents();

    }

    public static Context getInstance() {
        if (instance == null) {
            synchronized (Context.class) {
                if (instance == null) {
                    instance = new Context();
                }
            }
        }
        return instance;
    }

    private void initComponents() {
        userDao = new UserDao();
        itemDao = new ItemDao();
        userService = new UserService();
       
        itemService = new ItemService();

    }
}
