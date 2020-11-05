package com.chosen;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner optimus_scanner = new Scanner(System.in);
        boolean appIsOpen = true;
        ArrayList<software_project_member> current_members = new ArrayList<>();
        Software_Project_Data current_project = new Software_Project_Data("", "", current_members);

        Optimus_Software_UI optimusUI = new Optimus_Software_UI();

        do {
            optimusUI.optimusUI_welcome_message_header();
            optimusUI.optimusUI_welcome_message_project_options();
            if(optimus_scanner.nextLine().equals("1")) {
                Software_Project_Data new_software_project = optimusUI.optimusUI_create_new_project();
            } else {
                appIsOpen = false;
                break;
            }

        } while (appIsOpen);

    }
}
