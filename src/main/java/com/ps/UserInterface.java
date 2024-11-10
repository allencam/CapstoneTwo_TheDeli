package com.ps;

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
            System.out.print("Your command: ");
            mainMenuCommand = commandScan.nextByte();

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

    }

    private static void handleAddDrink() {

    }

    private static void handleAddChips() {

    }

    private static void handleReviewOrder() {

    }

}
