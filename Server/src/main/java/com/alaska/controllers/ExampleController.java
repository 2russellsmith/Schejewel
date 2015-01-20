package com.alaska.controllers;

import com.alaska.daos.ExampleDao;
import com.alaska.daos.MySqlExampleDao;
import com.alaska.models.Message;

public class ExampleController {
    private ExampleDao dao;

    public ExampleController(){
        dao = new MySqlExampleDao();
    }

    public Message getMessage(){
        return dao.readMessage();
    }
}
