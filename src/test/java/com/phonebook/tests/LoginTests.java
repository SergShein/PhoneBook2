package com.phonebook.tests;

import com.phonebook.models.User;
import com.phonebook.utils.ContactData;
import com.phonebook.utils.UserData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getUser().isLoginLickPresent()){
            app.getUser().clickOnSighOutButton();
        }
    }
    @Test
    public void  loginRegisteredUserPositiveTest(){
        //click on Login link
        app.getUser().clickOnLoginLink();
        //enter email
        app.getUser().fillLoginRegisterForm(new User().setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));

        //click on Login button
        app.getUser().clickOnLoginButton();
        //Assert Log Out button is present
        Assert.assertTrue(app.getUser().isElementPresent(By.cssSelector("button")));
    } @Test
    public void  loginRegisteredUserNegativeTestWithOutEmail(){
        //click on Login link
        app.getUser().clickOnLoginLink();
        //enter email
        app.getUser().fillLoginRegisterForm(new User()
                .setPassword(UserData.PASSWORD ));

        //click on Login button
        app.getUser().clickOnLoginButton();
        //Assert Log Out button is present
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}
