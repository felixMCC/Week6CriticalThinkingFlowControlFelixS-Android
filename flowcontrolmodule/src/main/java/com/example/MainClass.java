package com.example;

public class MainClass {

    public static void main (String [] Args){
        System.out.println("Week 6 Critical Thinking Exercise: Flow Control\nBy: Nestor (Felix) Sotres\n");
        System.out.println("I love food, you could say Im a glutton. So I love to EAT food.");
        System.out.println("This program will help me choose a type of cuisine based on some decisions presented\n\n");

        //Call FoodChoice class to run program
        FoodChoice run = new FoodChoice();
        run.runFoodChoice();
    }
}
