package com.ps;

import com.ps.filemanagement.FileManager;
import com.ps.structure.*;

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
                                        
                    (4) Review/edit order
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
                    order.clearOrder();
                    System.out.println("Order cancelled, returning to the main menu...");
                default:
                    System.out.println("Invalid entry, try again.");
            }
        } while (orderScreenCommand != 0);
    }

    private static void handleAddSandwich() {
        byte size = 0;
        String breadType = "";

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

        Sandwich sandwich = new Sandwich(breadType, size);

        byte wantToastedSelector;
        do {
            System.out.println("Would you like this sandwich toasted? (1) Yes or (2) no");
            wantToastedSelector = handleMenuInputMismatch("Your selection: ");

            switch (wantToastedSelector) {
                case 1:
                    sandwich.setToasted(true);
                    validInput = true;
                    break;
                case 2:
                    sandwich.setToasted(false);
                    validInput = true;
                    break;
                default:
                    System.out.println("Invalid input, try again.");
            }
        } while (!validInput);

        handleAddToppings(sandwich);
    }

    private static void handleAddToppings(Sandwich sandwich) {
        boolean validInput = false;

        byte toppingCategorySelector;
        do {
            byte meatCount = getMeatCount(sandwich);
            byte cheeseCount = getCheeseCount(sandwich);
            System.out.println("======= TOPPINGS =======");
            System.out.println("Here is your sandwich so far: \n" + sandwich);
            System.out.printf("""
                    \nWhat category of topping do you want to add?
                    (1) Meat (up to 2 selections)  Current: %d
                    (2) Cheese (up to 2)           Current: %d
                    (3) Vegetables, sauces, sides
                    
                    (4) Remove toppings menu                   
                    (0) Add sandwich to order
                    """, meatCount, cheeseCount);
            toppingCategorySelector = handleMenuInputMismatch("Your selection: ");

            switch (toppingCategorySelector) {
                case 1:
                    if (meatCount < 2) {
                        handleAddMeats(sandwich);
                    } else {
                        System.out.println("Limit reached, would you like to get rid of a meat?");
                        // TODO: Switch statement to get rid of a meat or go back.
                    }
                    break;
                case 2:
                    if (cheeseCount < 2) {
                        handleAddCheeses(sandwich);
                    } else {
                        System.out.println("Limit reached! Choose another category");
                    }
                    break;
                case 3:
                    handleAddOtherToppings(sandwich);
                    break;
                case 4:
                    if (!sandwich.getToppings().isEmpty()) {
                        removeToppingMenu(sandwich);
                    } else {
                        System.out.println("There are no toppings to remove.");
                    }
                    break;
                case 0:
                    order.addProduct(sandwich);
            }
        } while (toppingCategorySelector != 0);
        sandwich.checkForExtraToppings(sandwich.getToppings());
    }

    private static void handleAddMeats(Sandwich sandwich) {
        String[] meats = {"Steak", "Ham", "Salami", "Roast beef", "Chicken", "Bacon"};// can have extra, so allow 2 selections of either the same meat or 2 diff meats
        byte meatCount = getMeatCount(sandwich);
        byte meatSelector;

        System.out.println("Choose the meat(s) you would like one at a time, up to 2.");
        displayFourToppingsPerLine(meats);
        System.out.println("(0) Back");
        do {
            meatSelector = handleMenuInputMismatch("Your selection: ");
            if (meatSelector == 0) {
                break;
            }
            sandwich.addTopping(new Topping(meats[meatSelector - 1],"meat"));
            System.out.println("Added " + meats[meatSelector - 1]);
            meatCount++;
        } while (meatCount < 2);
        sandwich.checkForExtraToppings(sandwich.getToppings());
    }

    private static void handleAddCheeses(Sandwich sandwich) {
        String[] cheeses = {"American", "Provolone", "Cheddar", "Swiss"};
        byte cheeseCount = getCheeseCount(sandwich);
        byte cheeseSelector;

        System.out.println("Choose the cheese(s) you would like one at a time, up to 2.");
        displayFourToppingsPerLine(cheeses);
        System.out.println("(0) Back");
        do {
            cheeseSelector = handleMenuInputMismatch("Your selection: ");
            if (cheeseSelector == 0) {
                break;
            }
            sandwich.addTopping(new Topping(cheeses[cheeseSelector - 1],"cheese"));
            System.out.println("Added " + cheeses[cheeseSelector - 1]);
            cheeseCount++;
        } while (cheeseCount < 2 && cheeseSelector != 0);
        sandwich.checkForExtraToppings(sandwich.getToppings());
    }

    private static void handleAddOtherToppings(Sandwich sandwich) {
        String[] otherToppings = {"Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapeños", "Cucumbers", "Pickles", "Guacamole", "Mushrooms","Mayo", "Mustard", "Ketchup", "Ranch", "Thousand Islands", "Vinaigrette","Au jus", "Sauce (side)"};
        byte toppingSelector;

        System.out.println("---- Other Toppings ----");
        displayFourToppingsPerLine(otherToppings);

        System.out.println("Choose the topping(s) you would like, one at a time.");
        System.out.println("(0) Back");

        do {
            toppingSelector = handleMenuInputMismatch("Your selection: ");
            sandwich.addTopping(new Topping(otherToppings[toppingSelector - 1],"other"));
            System.out.println("Added " + otherToppings[toppingSelector - 1]);
        } while (toppingSelector != 0);
    }

    private static byte getMeatCount(Sandwich sandwich) {
        byte meatCount = 0;
        for(Topping topping : sandwich.getToppings()) { // To check how many meats are already on the sandwich
            if(topping.getType().equals("meat")) {
                meatCount++;
            }
        }
        return meatCount;
    }

    private static byte getCheeseCount(Sandwich sandwich) {
        byte cheeseCount = 0;
        for(Topping topping : sandwich.getToppings()) { // To check how many meats are already on the sandwich
            if(topping.getType().equals("cheese")) {
                cheeseCount++;
            }
        }
        return cheeseCount;
    }

    private static void displayFourToppingsPerLine(String[] toppings) { // Purpose of this method is to make the list of toppings more readable, especially if there are many
        for(int i = 0; i < toppings.length; i++) {
            System.out.printf("(%d) %s ", i + 1, toppings[i]);
            if ((i + 1) % 4 == 0 || i == toppings.length - 1) { // Checks if the current item is 4th in line OR if it's the last item in the array. Will go to next line if it's the 4th
                System.out.println();
            }
        }
    } // Method for displaying 4 toppings per line, created to be used for longer lists of toppings

    private static void handleAddDrink() {
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
    }

    private static void handleAddChips() {

        byte chipsSelector = 0;
        do {
            String name = "";
            System.out.println("""
                        Chips
                    -------------
                    Here are the chips we have available, select as many as you would like ($1.50 per bag):
                    (1) BBQ
                    (2) Jalapeño
                    (3) Salt & Vinegar
                    (4) Pretzels
                                        
                    (0) Done
                    """);
            System.out.println("Chips currently in order: ");
            for (Product product : order.getProducts()) {
                if (product instanceof Chips) {
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
                case 0:
                    break;
                default:
                    System.out.println("Invalid selection, try again.");
            }
            if (!name.isEmpty()) {
                order.addProduct(new Chips(name));
            }
        } while (chipsSelector != 0);
    }

    private static void removeToppingMenu(Sandwich sandwich) {
        byte removalSelector;
        do {
            sandwich.checkForExtraToppings(sandwich.getToppings());
            if (sandwich.getToppings().isEmpty()) {
                System.out.println("No more toppings! Going back...");
                break;
            }
        System.out.println("Select topping to remove, one at a time:");
        for (int i = 0; i < sandwich.getToppings().size(); i++) {
            System.out.printf("(%d) %s\n",i + 1,sandwich.getToppings().get(i));
        }
        System.out.println("(0) Back");
            removalSelector = handleMenuInputMismatch("Your selection: ");
            sandwich.getToppings().remove(removalSelector - 1);
        } while (removalSelector != 0);
    } // TODO: Exception handling

    private static void handleReviewOrder() {
        System.out.printf("""
                ===============================
                    Order Total: $%.2f
                ===============================
                """,order.getTotal());
        System.out.print("""
                    Sandwiches
                ------------------
                """);
        for (Product product : order.getProducts()) {
            if(product instanceof Sandwich) {
                System.out.println(product);
            }
        }
        System.out.println();
        System.out.print("""
                      Drinks
                ------------------
                """);
        for (Product product : order.getProducts()) {
            if(product instanceof Drink) {
                System.out.println(product);
            }

        }
        System.out.println();
        System.out.print("""
                      Chips
                ------------------
                """);
        for (Product product : order.getProducts()) {
            if(product instanceof Chips) {
                System.out.println(product);
            }
        }
        System.out.println();
        byte reviewMenuCommand;
        System.out.println("""
                Choose an option:
                (1) Edit/Remove items
                (2) Confirm order (save receipt)
                
                (0) Back
                """);
        do {
            reviewMenuCommand = handleMenuInputMismatch("Your selection: ");
            switch (reviewMenuCommand) {
                case 1:
                    handleEditOrder(order);
                    break;
                case 2:
                    FileManager.saveOrderReceipt(order);
                    order.clearOrder();
                    break;
                case 0:
                    System.out.println("Returning to the menu screen...");
                    break;
                default:
                    System.out.println("Invalid selection, try again.");
            }
        } while (reviewMenuCommand != 0 && reviewMenuCommand != 1);
    }

    private static void handleEditOrder(Order order) {
        byte selection;
        do {
            System.out.println("""
                    Select an option:
                    (1) Edit a sandwich
                    (2) Remove item(s)
                                    
                    (0) Back
                    """);
            selection = handleMenuInputMismatch("Your selection: ");

            switch (selection) {
                case 1:

                    break;
                case 2:
                    removeItemsMenu(order);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid selection, try again.");
            }

        } while (selection != 0);
    }

    private static void removeItemsMenu(Order order) {
        byte removalSelector;
        do {
            if (order.getProducts().isEmpty()) {
                System.out.println("No items in order. Going back...");
                break;
            }
            System.out.println("Select topping to remove, one at a time:");
            for (int i = 0; i < order.getProducts().size(); i++) {
                System.out.printf("(%d) %s\n",i + 1,order.getProducts().get(i));
            }
            System.out.println("(0) Back");
            removalSelector = handleMenuInputMismatch("Your selection: ");
            if (removalSelector == 0) {
                break;
            }
            order.getProducts().remove(removalSelector - 1);
        } while (removalSelector != 0);
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
                System.out.println("Invalid entry, try again.");
                commandScan.nextLine();
            }
        }
        return userInput;
    }
}