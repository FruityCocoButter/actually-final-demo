package com.example.finaldemo;

import java.util.ArrayList;

public class MenuController {

    MenuModel menu;

    public MenuController(){

        menu = new MenuModel();
    }
    public String populateScreen(String item){

        return menu.getMenuItem(item).toString();
    }

    public ArrayList<ArrayList<String>> setMenuItemsToUI(String vendor_name){
        return menu.getAllMenuItems(vendor_name);
    }

}
