package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {
   //precondition: login and add contact
    @BeforeMethod
    public void preconditionTest(){
        if (!app.getUser().isLoginLickPresent()){
            app.getUser().clickOnSighOutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User().setEmail("rambo23@gm.com")
                .setPassword("Rambo23$"));
        app.getUser().clickOnLoginButton();

        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName("John")
                .setLastname("Rambo")
                .setPhone("014578859569")
                .setEmail("rambo23@gm.com")
                .setAddress("USA")
                .setDescription("Here is John Rambo , Hi!!!"));
        app.getContact().clickOnSaveButton();
    }
    @Test
    public void removeContactTest() {
        int sizeBefore = app.getContact().sizeOfContacts();
        //click on the card
        app.getContact().removeContact();
        app.getContact().pause(1000);
        int sizeAfter = app.getContact().sizeOfContacts();
        //assert size of contacts equals -1
        Assert.assertEquals(sizeAfter,sizeBefore -1);
    }

}
