package com.example.finaldemo;

public class MenuController {

    MenuModel menu;

    public MenuController(Database db){

        menu = new MenuModel(db);
    }
    public String populateScreen(String item){

        return menu.getMenuItem(item).toString();
    }

}
