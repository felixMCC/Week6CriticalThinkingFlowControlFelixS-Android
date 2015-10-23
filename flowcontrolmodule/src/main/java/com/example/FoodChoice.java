package com.example;
import java.io.IOException;
import java.util.*;

/**
 * Created by Felix on 9/29/15.
 */
public class FoodChoice {

    Scanner in = new Scanner(System.in);    //object for input from user
    String tasteType = "";                  //user's choice salty, bitter, spicy
    String cuisineChoice = "";              //user's choice of cuisine
    //array for names of types of cuisine
    String cuisines[] = {"Mexican", "Italian", "Chinese", "Thai", "Indian"};
    HashMap<String, String> Mexican = new HashMap<String, String>();
    HashMap<String, String> Italian = new HashMap<String, String>();
    HashMap<String, String> Chinese = new HashMap<String, String>();
    HashMap<String, String> Thai = new HashMap<String, String>();
    HashMap<String, String> Indian = new HashMap<String, String>();

    //main program loop is held here
    public void runFoodChoice(){
        //initialize data
        initializeHashMaps();
        //main program loop
        do{
            printToUser("So felix, you glutton of a glutton you... what would you like to stuff your face with now?");
            spicyBitterSalty(); //ask if user is in the mood for spicy, bitter, or salty types of food
            //iterate();
            pickCuisine();
        }while(checkYesNo()); // check to see if user wants to try again


    }

    //prints message to the console
    private void printToUser(String toUser){
        System.out.println(toUser);
    }

    //receives input from user
    private String receiveInput(){
        String temp = in.nextLine();
        //printToUser("echo: " + temp); //testing
        return temp;
    }

    //prompts user if they want to try again (run program again)
    private boolean checkYesNo(){
        //prompt user if they want to try again
        printToUser("\nWould you like to try again? (Y / N)");
        //receive input from user
        String tempIn = in.nextLine();

        if(tempIn.equalsIgnoreCase("Y") || tempIn.equalsIgnoreCase("Yes")){
            return true;
        }else {
            return false;
        }

    }

    private void spicyBitterSalty(){
        printToUser("\nI know youre a Spicy, bitter, salty kind of guy (much like your personality...)");
        printToUser("So... Which of the three are you feeling today? \n1. Spicy\n2.Bitter\n3.Salty");
        int choice = -1;
        //validating input parsing
        try{
            //receive choice from user
            choice = Integer.parseInt(receiveInput()); //parse as int for switch case
        }catch (NumberFormatException e){
            //if user has not entered a number then user will be prompted to try again
            printToUser("\nDoode, stop messing around, please pick one of the valid choices");
            spicyBitterSalty();
        }

        switch(choice){
            case 1:
                tasteType = "spicy";
                break;
            case 2:
                tasteType = "bitter";
                break;
            case 3:
                tasteType = "salty";
                break;
            default:
                printToUser("\nDoode, stop messing around, please pick one of the valid choices");
                spicyBitterSalty();
                break;

        }
    }

    private void pickCuisine(){
        printToUser("\nSo, which type of cusine would you like?");
        printToUser("1. Mexican 2. Thai 3. Indian 4. Chinese 5. Italian 6. Hit me with all!");
        int choice = -1;

        //validating input parsing
        try{
            //receive choice from user
            choice = Integer.parseInt(receiveInput()); //parse as int for switch case
        }catch (NumberFormatException e){
            //if user has not entered a number then user will be prompted to try again
            printToUser("\nDoode, stop messing around, please pick one of the valid choices");
            pickCuisine();
        }

        //based on users choice, you will iterate through a  cuisine type to print dishes that match the flavor profile (salty, spicy, bitter)
        switch(choice){
            case 1:
                cuisineChoice = "Mexican";
                iterate(Mexican, tasteType);
                break;
            case 2:
                cuisineChoice = "Thai";
                iterate(Thai, tasteType);
                break;
            case 3:
                cuisineChoice = "Indian";
                iterate(Indian, tasteType);
                break;
            case 4:
                cuisineChoice = "Chinese";
                iterate(Chinese, tasteType);
                break;
            case 5:
                cuisineChoice = "Italian";
                iterate(Italian, tasteType);
                break;
            case 6:
                pickedAll();
                break;
            default:
                printToUser("\nDoode, stop messing around, please pick one of the valid choices");
                pickCuisine();
                break;
        }

    }

    //User selected all cuisine types. Print out all dishes from all cuisines that match flavor profile.
    private void pickedAll(){
        printToUser("You want ALL THE THINGS?? OK:\n");
        //print Mexican
        cuisineChoice = "Mexican";
        iterate(Mexican, tasteType);
        //print Thai
        cuisineChoice = "Thai";
        iterate(Thai, tasteType);
        //print Indian
        cuisineChoice = "Indian";
        iterate(Indian, tasteType);
        //Print Chinese
        cuisineChoice = "Chinese";
        iterate(Chinese, tasteType);
        //print Italian
        cuisineChoice = "Italian";
        iterate(Italian, tasteType);

    }

    //base method for iterating through a hashmap (Mexican) as an example
    private void iterate(){
        for (Map.Entry<String, String> entry : Mexican.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if(value.equalsIgnoreCase("spicy")){
                // printing
                printToUser("Cuisine: " + key + " Value: " + value);
            }

        }
    }

    /*generic method to iterate through a hashmap.
    Receives the type of cuisine (hashmap) and then based on the type (spicy, bitter, salty)
    the method presents the choices of food
    */
    private void iterate(HashMap<String, String> foodMap, String type){
        printToUser("\nCuisine type: " + cuisineChoice);
        printToUser("Flavor profile: " + tasteType);
        printToUser("Food choices:\n");
        //iterate through the values in the hashmap passed in
        for (Map.Entry<String, String> entry : foodMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if(value.equalsIgnoreCase(type)){
                // printing
                printToUser("" + key);
            }

        }
    }

    //method just initializes all cuisine dishes into hashmaps
    private void initializeHashMaps(){
        //Initiate Mexican cuisine
        Mexican.put("Tacos Dorados", "salty");
        Mexican.put("Mole Enchiladas", "spicy");
        Mexican.put("Cactus Salad","spicy");
        Mexican.put("Pico de Gallo", "bitter");

        //Initiate Indian cuisine
        Indian.put("Aloo Tikki - Potato fritters", "salty");
        Indian.put("Samosas - Indian empanadas", "salty");
        Indian.put("Tandoori Chicken - Grilled chicken in yougurt", "spicy");
        Indian.put("Saag Paneer - Spinach dip", "bitter");
        Indian.put("Chicken Tikka Masala - Chicken in sauce", "spicy");

        //Initiate Thai cuisine
        Thai.put("Sukiyaki - Noodles and soup","bitter");
        Thai.put("Papaya Salad - Green papaya salad","bitter");
        Thai.put("Miang Kham - Leaf wrap appetizers","salty");
        Thai.put("Chicken Tom Yum - chicken soup","spicy");
        Thai.put("Thai Sour Orange Curry","bitter");

        //initiate Chinese cuisine
        Chinese.put("Cumin Lamb Skewers", "salty");
        Chinese.put("Sweet and Sour Pork", "spicy");
        Chinese.put("Mapo Tofu - Tofu soup", "spicy");
        Chinese.put("Beef Stir Fry", "spicy");
        Chinese.put("Pork Belly Buns", "salty");
        Chinese.put("Zha Jian Mian - Pork Noodles with soybean paste", "bitter");

        //Initiate Italian cuisine
        Italian.put("Bacon Wrapped Scallions","salty");
        Italian.put("Caprese Salad with Capers","salty");
        Italian.put("Spicy Grouper with Fregola","spicy");
        Italian.put("Lasagna","salty");

    }
}//end FoodChoice class
