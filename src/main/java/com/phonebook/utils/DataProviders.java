package com.phonebook.utils;

import com.phonebook.models.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public Iterator<Object[]> addNewContact(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Oliver1","Kan","1123456789","kan@gmail.com","Berlin","Busfaher"});
        list.add(new Object[]{"Oliver2","Kan","2223456789","kan@gmail.com","Berlin","Busfaher"});
        list.add(new Object[]{"Oliver3","Kan","3323456789","kan@gmail.com","Berlin","Busfaher"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> adNewContactFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));

        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");

            list.add(new Object[]{new Contact().setName(split[0]).setLastname(split[1]).setPhone(split[2])
                    .setEmail(split[3]).setAddress(split[4]).setDescription(split[5])});

            line = reader.readLine();
        }
        return list.iterator();
    }


}
