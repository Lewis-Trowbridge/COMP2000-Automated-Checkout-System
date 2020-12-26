package com.autochecksys.controller.shared;


public abstract class AbstractLoginController extends AbstractController {
    public abstract boolean checkLogin(String username, String password);

}
