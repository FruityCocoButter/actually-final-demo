package com.example.finaldemo;

public class MenuController {

    MenuModel menu;

    public MenuController(){

        menu = new MenuModel();
    }
    public String populateScreen(String item){

        return menu.getMenuItem(item).toString();
    }

}
