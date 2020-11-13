package com.chosen;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner optimus_scanner = new Scanner(System.in);
        boolean appIsOpen = true;
        boolean atMainMenu = true;
        boolean inProject = false;
        boolean atProjectMenu;

        ArrayList<software_project_member> current_members = new ArrayList<>();
        Software_Project_Data current_project = new Software_Project_Data("", "", current_members);

        Optimus_Software_UI optimusUI = new Optimus_Software_UI();

        do {
            optimusUI.optimusUI_welcome_message_header();
            optimusUI.optimusUI_welcome_message_project_options();
            var selection = optimus_scanner.nextLine();
            switch(selection) {
                case "1":
                    atMainMenu = false;
                    Software_Project_Data new_software_project = optimusUI.optimusUI_create_new_project();
                    do {
//                        inProject = true;
                        atProjectMenu = true;
                        optimusUI.optimus_UI_in_project_menu_options();
                        selection = optimus_scanner.nextLine();
                        switch (selection) {
                            case "1":
                                optimusUI.view_project_information(new_software_project);
                                break;
                            case "2":
                                System.out.println("Software Project Requirements");
                                break;
                            case "3":
                                System.out.println("Software Project Monitoring");
                                break;
                            case "e":
                                System.out.println("Exiting Project back to Optimus Main Menu.");
                                atProjectMenu = false;
                                break;
                            default:
                                System.out.println("Invalid Input. Try again please.");
                        }
                    } while (atProjectMenu);
                    atMainMenu = true;
                    break;
                case "2":
                    atMainMenu = false;
                    System.out.println("To Do");
                    break;
                case "e":
                    appIsOpen = false;
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Invalid Input. Try again please.");
            }
        } while (appIsOpen && atMainMenu);

    }
}
