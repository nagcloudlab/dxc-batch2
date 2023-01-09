package com.com;

import com.jerry.WebContainer;

public class Application {
    public static void main(String[] args) {

        WebContainer webContainer=new WebContainer();
        webContainer.handleHttpRequest("POST","/register");
        webContainer.handleHttpRequest("POST","/login");

    }
}
