package com.ps;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    // MENUS AND APPLICATION FLOW HERE
    static Scanner commandScan = new Scanner(System.in);
    private static Order order = new Order();

    public static void display() { // THIS IS THE MAIN MENU
        byte mainMenuCommand;
        do {
            System.out.print("""
                    Welcome to the Deli! Please choose one of the options below...
                    (1) New order
                    (0) Exit
                    """);
            mainMenuCommand = handleMenuInputMismatch("Your command: ");

            switch (mainMenuCommand) {
                case 1:
                    handleNewOrder();
                    break;
                case 0:
                    System.out.println("Thank you for visiting, have a good day!");
                    continue;
                default:
                    System.out.println("Invalid entry, try again.");
            }
        } while (mainMenuCommand != 0);
    }

    private static void handleNewOrder() {
        byte orderScreenCommand;
        do {
            System.out.println("""
                    ======= ORDER SCREEN =======
                    Please select an option...
                    (1) Add sandwich
                    (2) Add Drink
                    (3) Add Chips
                                        
                    (4) Review/change order
                    (0) Cancel order
                    """); // TODO: Add a conditional that checks for items in order and only display 4, 0, if there are items. Else add back option.
            // TODO: Add a running total line if there are products in the order
            orderScreenCommand = handleMenuInputMismatch("Your selection: ");

            switch (orderScreenCommand) {
                case 1:
                    handleAddSandwich();
                    break;
                case 2:
                    handleAddDrink();
                    break;
                case 3:
                    handleAddChips();
                    break;
                case 4:
                    handleReviewOrder();
                    break;
                case 0:
                    System.out.println("Returning to the main menu...");
                default:
                    System.out.println("Invalid entry, try again.");
            }
        } while (orderScreenCommand != 0);
    }

    private static void handleAddSandwich() {
        byte size = 0;
        String breadType = "";
        ArrayList<Topping> toppings = new ArrayList<>();

        boolean validInput = false;
        byte sizeSelector;
        do {
            System.out.print("""
                    ======== NEW SANDWICH ========
                    What size sandwich would you like?
                    (1) 4"
                    (2) 8"
                    (3) 12"
                                        
                    (0) Cancel
                    """);
            sizeSelector = handleMenuInputMismatch("Your selection: ");

            switch (sizeSelector) {
                case 1:
                    size = 4;
                    validInput = true;
                    break;
                case 2:
                    size = 8;
                    validInput = true;

                    break;
                case 3:
                    size = 12;
                    validInput = true;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        } while (sizeSelector != 0 && !validInput);
        validInput = false;

        byte breadTypeSelector;
        do {
            System.out.print("""
                    ---- BREAD ----
                    What bread type would you like?
                    (1) White
                    (2) Wheat
                    (3) Rye
                    (4) Wrap
                    """);
            breadTypeSelector = handleMenuInputMismatch("Your selection: ");

            switch (breadTypeSelector) {
                case 1:
                    breadType = "White";
                    validInput = true;
                    break;
                case 2:
                    breadType = "Wheat";
                    validInput = true;
                    break;
                case 3:
                    breadType = "Rye";
                    validInput = true;
                    break;
                case 4:
                    breadType = "Wrap";
                    validInput = true;
                    break;
                default:
                    System.out.println("Invalid selection, try again.");
            }
        } while (breadTypeSelector != 0 && !validInput);
        validInput = false;

//        byte meatSelector;
//        Topping meat = new Topping("meat", 0); // TODO: Revisit this once I've done the logic to handle price according to sandwich size.
//        do {
//            System.out.println("""
//                    ---- MEAT ----
//                    What meat would you like?
//                    (1) Steak
//                    (2) Ham
//                    (3) Salami
//                    (4) Roast Beef
//                    (5) Chicken
//                    (6) Bacon
//
//                    (0) None
//                    """);
//            meatSelector = handleMenuInputMismatch("Your selection: ");
//
//            switch (meatSelector) {
//                case 1:
//                    meat.setName("Steak");
//                    toppings.add(meat);
//                    validInput = true;
//                    break;
//                case 2:
//                    meat.setName("Ham");
//                    toppings.add(meat);
//                    validInput = true;
//                    break;
//                case 3:
//                    meat.setName("Salami");
//                    toppings.add(meat);
//                    validInput = true;
//                    break;
//                case 4:
//                    meat.setName("Roast beef");
//                    validInput = true;
//                    toppings.add(meat);
//                    break;
//                case 5:
//                    meat.setName("Chicken");
//                    validInput = true;
//                    toppings.add(meat);
//                    break;
//                case 6:
//                    meat.setName("Bacon");
//                    validInput = true;
//                    toppings.add(meat);
//                    break;
//                case 0:
//                    validInput = true;
//                    break;
//                default:
//                    System.out.println("Invalid selection, try again.");
//            }
//        } while (meatSelector != 0 && !validInput);
//
//        validInput = false;
//        // Ask user if they want extra meat, only if they selected a meat
//        if (!toppings.isEmpty()) {
//            do {
//                System.out.println("Would you like to add extra meat? (1) Yes or (2) No");
//                if (handleMenuInputMismatch("Your selection") == 1) {
//                    meat.setHasExtra(true);
//                    validInput = true;
//                } else if (handleMenuInputMismatch("Your selection: ") == 0) {
//                    validInput = true;
//                } else {
//                    System.out.println("Input invalid, try again.");
//                }
//            } while (!validInput);
//        }
        handleAddToppings();

        boolean wantToasted = false;
        byte wantToastedSelector;
        do{
            System.out.println("Would you like this sandwich toasted? (1) Yes or (2) no");
            wantToastedSelector = handleMenuInputMismatch("Your selection: ");

            switch (wantToastedSelector) {
                case 1:
                    wantToasted = true;
                case 2:
                    wantToasted = false;
                default:
                    System.out.println("Invalid input, try again.");
            }
        }while (validInput = false);

        Sandwich sandwich = new Sandwich(breadType,size,wantToasted,toppings);
    }

    private static void handleAddToppings() {
        String[] meats = {"Steak", "Ham", "Salami", "Roast beef", "Chicken", "Bacon"}; // can have extra, so allow 2 selections of either the same meat or 2 diff meats
        String[] cheeses = {"American", "Provolone", "Cheddar", "Swiss"}; // same as above
        String[] vegetables = {"Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapeños", "Cucumbers", "Pickles", "Guacamole", "Mushrooms"};
        String[] sauces = {"Mayo", "Mustard", "Ketchup", "Ranch", "Thousand Islands", "Vinaigrette"};
        String[] sides = {"Au jus", "Sauce"};

        byte toppingSelector;
        do { // TODO: Find a way to dry out this code later, also looks
            int toppingIndex = 1;

            System.out.println("---- Meats ----");
            for(int i = 0; i < meats.length; i++, toppingIndex++) {
                System.out.printf("(%d) %s ", toppingIndex, meats[i]);
                if(toppingIndex % 4 == 0){
                    System.out.print("\n");
                }
            }

            System.out.println("\n---- Cheeses ----");
            for(int i = 0; i < cheeses.length; i++, toppingIndex++) {
                System.out.printf("(%d) %s ", toppingIndex, cheeses[i]);
                if(i % 4 == 0){
                    System.out.print("\n");
                }
            }

            System.out.println("\n---- Vegetables ----");
            for(int i = 0; i < vegetables.length; i++, toppingIndex++) {
                System.out.printf("(%d) %s ", toppingIndex, vegetables[i]);
                if(i % 4 == 0){
                    System.out.print("\n");
                }
            }

            System.out.println("\n---- Sauces ----");
            for(int i = 0; i < sauces.length; i++, toppingIndex++) {
                System.out.printf("(%d) %s ", toppingIndex, sauces[i]);
                if(i % 4 == 0){
                    System.out.print("\n");
                }
            }

            System.out.println("\n---- Sides ----");
            for(int i = 0; i < cheeses.length; i++, toppingIndex++) {
                System.out.printf("(%d) %s ", toppingIndex, cheeses[i]);
                if(i % 4 == 0){
                    System.out.print("\n");
                }
            }
            toppingSelector = handleMenuInputMismatch("\nYour selection: ");
            // TODO: Handle adding toppings to arraylist

        } while(toppingSelector != 0);
    }

    public static void handleAddDrink() {
        String size = "";
        String name = "";

        byte sizeSelector;
        boolean validInput = false;
        do {
            System.out.println("""
                    What size drink would you like?
                    1) Small
                    2) Medium
                    3) Large
                    """);
            sizeSelector = handleMenuInputMismatch("Your selection: ");
            switch (sizeSelector) {
                case 1:
                    size = "Small";
                    validInput = true;
                    break;
                case 2:
                    size = "Medium";
                    validInput = true;
                    break;
                case 3:
                    size = "Large";
                    validInput = true;
                    break;
                default:
                    System.out.println("Invalid input, try again.");
            }
        } while (!validInput);
        validInput = false;

        byte drinkSelector;
        do {
            System.out.println("""
                    Here are our available drinks, choose one:
                    (1) Lemonade
                    (2) Dr. Pepper
                    (3) Coca Cola
                    (4) Sprite
                    (5) Root Beer
                    """);
            drinkSelector = handleMenuInputMismatch("Your selection: ");
            switch (drinkSelector) {
                case 1:
                    name = "Lemonade";
                    validInput = true;
                    break;
                case 2:
                    name = "Dr. Pepper";
                    validInput = true;
                    break;
                case 3:
                    name = "Coca cola";
                    validInput = true;
                    break;
                case 4:
                    name = "Sprite";
                    validInput = true;
                    break;
                case 5:
                    name = "Root beer";
                    validInput = true;
                    break;
                default:
                    System.out.println("Invalid input, try again.");
            }
        } while (!validInput);
        order.addProduct(new Drink(name, size));
    } //done

    private static void handleAddChips() {
        String name = "";
        byte chipsSelector;
        do {

            System.out.println("""
                    Here are the chips we have available, select as many as you would like:
                    (1) BBQ
                    (2) Jalapeño
                    (3) Salt & Vinegar
                    (4) Pretzels
                    
                    (0) Done
                    """);
            System.out.println("Chips currently in order: ");
            for(Product product: order.getProducts()) {
                if(product instanceof Chips) {
                    System.out.println(product);
                }
            }
            chipsSelector = handleMenuInputMismatch("Your selection: ");

            switch (chipsSelector) {
                case 1:
                    name = "BBQ";
                    break;
                case 2:
                    name = "Jalapeño";
                    break;
                case 3:
                    name = "Salt & Vinegar";
                    break;
                case 4:
                    name = "Pretzels";
                    break;
                default:
                    System.out.println("Invalid selection, try again.");
            }
            if(!name.equals("")) {
                order.addProduct(new Chips(name));
            }

        } while(chipsSelector != 0);
    }

    private static void handleReviewOrder() {

    }

    public static byte handleMenuInputMismatch(String prompt) {
        byte userInput = -1;
        boolean validInput = false;

        while (!validInput) {
            System.out.print(prompt);
            try {
                userInput = commandScan.nextByte();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid entry, please enter a number.");
                commandScan.nextLine();
            }
        }
        return userInput;
    }

}