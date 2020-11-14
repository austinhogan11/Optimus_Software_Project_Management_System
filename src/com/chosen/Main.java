package com.chosen;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner optimus_scanner = new Scanner(System.in);
        boolean appIsOpen = true;
        boolean atMainMenu = true;

        ArrayList<software_project_member> current_members = new ArrayList<>();

        Optimus_Software_UI optimusUI = new Optimus_Software_UI();

        do {
            optimusUI.welcome_page_UI(optimusUI);
            String selection = optimus_scanner.nextLine();
            switch(selection) {
                case "1":
                    atMainMenu = false;
                    Software_Project_Data new_software_project = optimusUI.optimusUI_create_new_project();
                    optimusUI.current_project_handling(optimusUI, new_software_project);
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
