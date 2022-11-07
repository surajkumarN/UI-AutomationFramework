package com.proj.pages.initializepages;

import com.proj.pages.loginandlogout.LoginPage;
import com.proj.pages.loginandlogout.LogoutPage;

/**
 * This class is created for initilize the all pomrepository pages and use in scripts
 */
public class InitializePages {

    public LoginPage loginPage;
    public LogoutPage logoutPage;

    public InitializePages() {
        loginPage = new LoginPage();
        logoutPage = new LogoutPage();
    }
}
