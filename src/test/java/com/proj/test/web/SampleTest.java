package com.proj.test.web;

import com.proj.driver.DriverManager;
import com.proj.test.base.WebSetUp;
import org.testng.annotations.Test;

public class SampleTest extends WebSetUp {
    @Test
    public void test(){
        System.out.println("WEB LOCAL");
        String title = DriverManager.getDriver().getTitle();
        System.out.println(title);
    }
}
