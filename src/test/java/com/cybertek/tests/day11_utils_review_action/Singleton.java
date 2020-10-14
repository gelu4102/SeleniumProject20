package com.cybertek.tests.day11_utils_review_action;

public class Singleton {

    private Singleton(){

    }

    //Making the String private so that we can only reach this using getter method
    private static String word;

    //Creating a 'getter' method to allow users to reach private String above
    public static String getWord(){
        if (word == null){
            System.out.println("First time call. Word Object is null. "+"Assigning value to it now!");
            word = "Something";
        }else {
            System.out.println("Word already has value");
        }
        return word;
    }

}
