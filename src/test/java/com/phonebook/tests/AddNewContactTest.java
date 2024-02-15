package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import com.phonebook.utils.ContactData;
import com.phonebook.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddNewContactTest extends TestBase{
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
                .setName(ContactData.NAME)
                .setLastname(ContactData.LAST_NAME)
                .setPhone(ContactData.PHONE)
                .setEmail(ContactData.EMAIL)
                .setAddress(ContactData.ADDRESS)
                .setDescription(ContactData.DESCRIPTION));

        //click on save button
        app.getContact().clickOnSaveButton();
        //assert contact is added by text
        Assert.assertTrue(app.getContact().isContactCreated(ContactData.NAME));
    }

    @AfterMethod
    public void postCondition(){
        app.getContact().removeContact();
    }


    @Test(dataProvider = "addNewContact",dataProviderClass = DataProviders.class)
    public void addNewContactPositiveTestFromDataProvider(String name, String lastName, String phone, String email, String address, String description) {
        // click on add link
        app.getContact().clickOnAddLink();
        // enter name
        app.getContact().fillContactForm(new Contact()
                .setName(name)
                .setLastname(lastName)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setDescription(description));

        //click on save button
        app.getContact().clickOnSaveButton();
        //assert contact is added by text
        Assert.assertTrue(app.getContact().isContactCreated(name));
    }


    @Test(dataProvider = "adNewContactFromCSV", dataProviderClass = DataProviders.class)
    public void addNewContactPositiveTestFromDataProviderWithCSV(Contact contact) {
        // click on add link
        app.getContact().clickOnAddLink();
        // enter name
        app.getContact().fillContactForm(contact);
        //click on save button
        app.getContact().clickOnSaveButton();
        //assert contact is added by text
        Assert.assertTrue(app.getContact().isContactCreated(contact.getName()));
    }

}
