package com.cydeo.tests.officeHours.day05;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class P02_Priority_DependsOn {

    String username;

    @Test
    public void noPriority() {
        System.out.println("Hello "+username);
    }

    @Test(priority = 1)
    public void createUser() {
        username="Mike";
        System.out.println(username+" is created");
        Assert.assertEquals("Mike",username);
    }



    @Test(priority = 2,dependsOnMethods = {"createUser"})
    public void updateuser() {
        username="John";
        System.out.println(username+" is updated");

    }

    @Test(priority = 3,dependsOnMethods = {"updateuser"})
    public void deleteUser() {

        System.out.println(username+" is deleted");
        username="";


    }

    @Test@Ignore
    public void ignored() {
        System.out.println("This test case is ignored" );

    }
}
