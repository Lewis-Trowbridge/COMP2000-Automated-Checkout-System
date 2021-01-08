package com.autochecksys.controller.shared;


public abstract class AbstractLoginController extends AbstractController {
    public abstract void checkLogin(String username, String password);

}
