package com.phonebook.tests;

import com.phonebook.models.User;
import com.phonebook.utils.UserData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends  TestBase {
    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getUser().isLoginLickPresent()){
            app.getUser().clickOnSighOutButton();
        }
    }

    @Test
    public void registerExistedUserNegativeTest() {
        //click on Login link
        app.getUser().clickOnLoginLink();
        //enter email
        app.getUser().fillLoginRegisterForm(new User().setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        //click on Registration button
        app.getUser().clickOnRegistrationButton();
        //assert alert is appeared
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}

