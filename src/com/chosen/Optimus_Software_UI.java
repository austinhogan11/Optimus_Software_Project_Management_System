package com.chosen;

import java.util.ArrayList;
import java.util.Scanner;

public class Optimus_Software_UI {
    private final Scanner user_input = new Scanner(System.in);

    public Optimus_Software_UI() {
    }

    /*
        Welcome Message Displayed at applications home screen.
     */
    public void optimusUI_welcome_message_header() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~                   Welcome To The                      ~");
        System.out.println("~       Optimus Software Project Management System      ~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    /*
        Project Menu options displayed on the applications home screen.
        The numbers represent what key to enter to select an option.
     */
    public void optimusUI_welcome_message_project_options() {
        System.out.println("~   Please enter the specified key for an option below: ~");
        System.out.println("~   1. Create a new Software Project                    ~");
        System.out.println("~   2. Open an Existing Project.                        ~");
        System.out.println("~   e. Exit Application                                 ~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    /*
       Menu options for project user is currently in.
     */
    public void optimusUI_in_project_menu_options(){
        System.out.println("~   Please enter the specified key for an option below: ~");
        System.out.println("~   1. Software Project Information                     ~");
        System.out.println("~   2. Software Project Requirements                    ~");
        System.out.println("~   3. Software Project Effort Monitoring               ~");
        System.out.println("~   e. Back to Main Menu                                ~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public void optimusUI_project_information_options(){
        System.out.println("~   Please enter the specified key for an option below: ~");
        System.out.println("~   1. View Software Project Information                ~");
        System.out.println("~   2. Edit Software Project Information        ~");
        System.out.println("~   e. Back                                             ~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public void optimusUI_edit_project_info_menu_options(){
        System.out.println("~   Please enter the specified key for an option below: ~");
        System.out.println("~   1. Edit Project Name                                ~");
        System.out.println("~   2. Edit Project Description                         ~");
        System.out.println("~   3. Edit Project Members                             ~");
        System.out.println("~   e. Back                                             ~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public void optimusUI_edit_project_member_options(){
        System.out.println("~   Please enter the specified key for an option below: ~");
        System.out.println("~   1. Add a Project Team Member                        ~");
        System.out.println("~   2. Remove a Project Team Member                     ~");
        System.out.println("~   3. Edit a Project Team Member                       ~");
        System.out.println("~   e. Back                                             ~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public void optimusUI_choose_project_memberUI(Software_Project_Data project){
        System.out.println("~   Please enter the specified key for an option below: ~");
        project.getProject_members();
    }

    public void optimusUI_project_requirements_options(){
        System.out.println("~   Please enter the specified key for an option below: ~");
        System.out.println("~   1. Software Project Functional Requirements         ~");
        System.out.println("~   2. Software Project Non-Functional Requirements     ~");
        System.out.println("~   e. Back                                             ~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public void optimusUI_functional_requirements_options(){
        System.out.println("~   Please enter the specified key for an option below: ~");
        System.out.println("~   1. Add a Functional Requirement                     ~");
        System.out.println("~   2. Remove a Functional Requirement                  ~");
        System.out.println("~   e. Back                                             ~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public void optimusUI_nonfunctional_requirements_options(){
        System.out.println("~   Please enter the specified key for an option below: ~");
        System.out.println("~   1. Add a non-Functional Requirement                 ~");
        System.out.println("~   2. Remove a Non-Functional Requirement              ~");
        System.out.println("~   e. Back                                             ~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }




    /*
    This function takes user input for project data and creates a new project from it.
    */
    public Software_Project_Data optimusUI_create_new_project() {
        System.out.println("~                 Create a New Project                  ~");
        String project_name = new_project_name_input();
        String project_desc = new_project_description_input();
        ArrayList<software_project_member> project_members = new_project_members_input();

        return new Software_Project_Data(project_name, project_desc, project_members);
    }

    /*
    The three functions below obtain user input to create a new software project.
    Project Data Collected:
        -   Project Name - String
        -   Project Description - String
        -   Project Team Members - ArrayList<software_project_member>
    */
    private String new_project_name_input(){
        System.out.println("~   Enter the Software Project's Name:                  ~");
        return user_input.nextLine();
    }

    private String new_project_description_input(){
        System.out.println("~   Enter the Software Project's Description:                  ~");
        return user_input.nextLine();
    }

    private ArrayList<software_project_member> new_project_members_input(){
        ArrayList<software_project_member> new_project_members = new ArrayList<>();
        System.out.println("Do you want to add a team member to the project? (y/n)");
        String add_member = user_input.nextLine().toLowerCase();
        while (add_member.equals("y")){
            software_project_member project_member = optimusUI_create_new_project_member();
            new_project_members.add(project_member);
            System.out.println("Add another team member to the project? (y/n)");
            add_member = user_input.nextLine().toLowerCase();
        }
        return new_project_members;
    }

    /*
    This function takes user input for the members and creates a member object with it.
     */
    public software_project_member optimusUI_create_new_project_member() {
        String first_name = new_member_first_name_input();
        String last_name = new_member_last_name_input();
        boolean isManager = new_member_manager_input();
        return new software_project_member(first_name, last_name, isManager);
    }


    /*
    The three functions below obtain user input to create a project member.
    Project Member Data Collected:
        -   Team Member First Name - String
        -   Team Member Last Name - String
        -   If the member is a project manager - Boolean
     */
    private String new_member_first_name_input() {
        System.out.println("~   Enter the project member's first name:                  ~");
        return user_input.nextLine().toLowerCase();
    }

    private String new_member_last_name_input() {
        System.out.println("~   Enter the project member's last name:                  ~");
        return user_input.nextLine().toLowerCase();
    }

    private boolean new_member_manager_input() {
        System.out.println("~   Is this project member a project manager? (y/n)                  ~");
        return user_input.nextLine().toLowerCase().equals("y");
    }


    public void view_project_information(Software_Project_Data project) {
        System.out.println("Project Name: " + project.getProject_name() + "\n"
                            + "Project Description: " + project.getProject_description() + "\n"
                            + "Project Members: ");
        project.getProject_members();
    }

    public void welcome_page_UI(Optimus_Software_UI systemUI){
        systemUI.optimusUI_welcome_message_header();
        systemUI.optimusUI_welcome_message_project_options();
    }

    public void current_project_handling(Optimus_Software_UI system_UI, Software_Project_Data current_project) {
        boolean atProjectMenu = true;
        do {
            system_UI.optimusUI_in_project_menu_options();
            String selection = user_input.nextLine().toLowerCase();
            switch (selection) {
                case "1":
                    system_UI.project_information_handling(system_UI, current_project);
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
    }

    public void project_information_handling(Optimus_Software_UI systemUI, Software_Project_Data project) {
        boolean inProjectInfo = true;
        do {
            systemUI.optimusUI_project_information_options();
            String selection = user_input.nextLine().toLowerCase();
            switch (selection) {
                case "1":
                    systemUI.view_project_information(project);
                    break;
                case "2":
                    systemUI.edit_project_information_processing(systemUI, project);
                    break;
                case "e":
                    inProjectInfo = false;
                    break;
                default:
                    System.out.println("Invalid Input. Try again please.");

            }
        } while (inProjectInfo);
    }

    /*
        Handles the project modifications for the current Software Project
        Displays the menu options to edit the current project. (Edit Name, Description, Team Members
        Accepts user input and proceeds on to the project attribute to modify or goes back to the previous screen.
     */
    public void edit_project_information_processing(Optimus_Software_UI systemUI, Software_Project_Data project) {
        boolean inEditProjectMenu = true;
        do {
            systemUI.optimusUI_edit_project_info_menu_options();
            String selection = user_input.nextLine().toLowerCase();
            switch (selection) {
                case "1":
                    systemUI.edit_project_name(project);
                    break;
                case "2":
                    systemUI.edit_project_description(project);
                    break;
                case "3":
                    systemUI.edit_project_members_processing(project);
                    break;
                case "e":
                    inEditProjectMenu = false;
                    break;
                default:
                    System.out.println("Invalid Input. Try again please.");
            }
        } while (inEditProjectMenu);
    }


    // Changes the name of the software project
    public void edit_project_name(Software_Project_Data project) {
        System.out.println("Enter the new project name: ");
        String new_name = user_input.nextLine();
        project.setProject_name(new_name);
        System.out.println("Project Name Updated to: " + new_name);
    }

    //  Changes the description for the software Project
    public void edit_project_description(Software_Project_Data project) {
        System.out.println("Enter the new project description: ");
        String new_description = user_input.nextLine();
        project.setProject_description(new_description);
        System.out.println("Project Name Updated.");
    }

    public  void edit_project_members_processing(Software_Project_Data project){
        boolean inMemberOptions = true;
        do {
            optimusUI_edit_project_member_options();
            String selection = user_input.nextLine().toLowerCase();
            switch (selection){
                case "1":
                    System.out.println("Add a member");
                    break;
                case "2":
                    System.out.println("remove a member");
                    break;
                case "3":
                    System.out.println("edit a member");
                    break;
                case "e":
                    System.out.println("Back.");
                    break;
                default:
                    System.out.println("Invalid Input. Try again please.");
            }
        } while (inMemberOptions);

    }

    public void edit_member_first_name(software_project_member member){
        System.out.println("Enter the new first name: ");
        String new_first_name = user_input.nextLine();
        member.setFirst_name(new_first_name);
        System.out.println("Member's first name updated.");
    }

    public void edit_member_last_name(software_project_member member){
        System.out.println("Enter the new last name: ");
        String new_last_name = user_input.nextLine();
        member.setFirst_name(new_last_name);
        System.out.println("Member's last name updated.");
    }

    public void edit_member_manager_status(software_project_member member){
        System.out.println("Is the member a manager? (y/n) ");
        String isManager = user_input.nextLine().toLowerCase();
        if(isManager.equals("y")) {
            member.isManager = true;
        } else {
            member.isManager = false;
        }
        System.out.println("Member's project manager status was updated.");
    }

}
