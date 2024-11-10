package com.ps;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    // MENUS AND APPLICATION FLOW HERE
    static Scanner commandScan = new Scanner(System.in);

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
        } while(mainMenuCommand != 0);
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
                    """);
            orderScreenCommand = commandScan.nextByte();

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
        byte size;
        String breadType;

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
        } while(sizeSelector != 0 && !validInput);
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
        } while(breadTypeSelector != 0 && !validInput);

    }

    private static void handleAddDrink() {

    }

    private static void handleAddChips() {

    }

    private static void handleReviewOrder() {

    }

    public static byte handleMenuInputMismatch(String prompt) {
        byte userInput = -1;
        boolean validInput = false;

        while(!validInput) {
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
