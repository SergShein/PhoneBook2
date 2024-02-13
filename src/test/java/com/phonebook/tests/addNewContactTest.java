package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class addNewContactTest extends TestBase{
    @BeforeMethod
    public void precondition(){
        if (!app.getUser().isLoginLickPresent()){
            app.getUser().clickOnSighOutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User().setEmail("rambo23@gm.com")
                .setPassword("Rambo23$"));
        app.getUser().clickOnLoginButton();
    }
    @Test
    public void addNewContactPositiveTest() {
        // click on add link
        app.getContact().clickOnAddLink();
        // enter name
        app.getContact().fillContactForm(new Contact()
                .setName("John")
                .setLastname("Rambo")
                .setPhone("014578859569")
                .setEmail("rambo23@gm.com")
                .setAddress("USA")
                .setDescription("Here is John Rambo  , Hi!!!"));

        //click on save button
        app.getContact().clickOnSaveButton();
        //assert contact is added by text
        Assert.assertTrue(app.getContact().isContactCreated("John"));
    }

    @AfterMethod
    public void postCondition(){
        app.getContact().removeContact();
    }

}
