package com.cybertek.tests.day6_Dropdown_Review_JavaFaker;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerExamples {
    @Test
    public void faker_test(){

        //we need to create an object from the faker class to be able to use methods
        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        System.out.println("First name =  "+ firstName);

        String lastName = faker.name().lastName();
        System.out.println("Last Name = "+lastName);

        String fullName = faker.name().fullName();
        System.out.println("Full Name = "+fullName);

        String address = faker.address().fullAddress();
        System.out.println("Address = "+address);

        String house = faker.gameOfThrones().house();
        String quote = faker.gameOfThrones().quote();

        System.out.println("House = "+house);
        System.out.println("Quote = "+quote);

        String fact = faker.chuckNorris().fact();
        System.out.println("Fact = "+fact);

    }
}
