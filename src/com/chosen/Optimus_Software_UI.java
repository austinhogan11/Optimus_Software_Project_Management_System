package com.chosen;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Optimus_Software_UI {
    private final Scanner user_input = new Scanner(System.in);

    public Optimus_Software_UI() {
    }

    /*
        ================================== Main Menu UI & Functionality ==============================
     */

    // Welcome Message Displayed at applications home screen.
    public void optimusUI_welcome_message() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~                   Welcome To The                      ~");
        System.out.println("~       Optimus Software Project Management System      ~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    /*
        Project Menu options displayed on the applications main menu/home screen.
        The numbers represent what key to enter to select an option.
     */
    public void optimusUI_welcome_message_project_options() {
        System.out.println("~   Please enter the specified key for an option below: ~");
        System.out.println("~   1. Create a new Software Project                    ~");
        System.out.println("~   2. Open an Existing Project.                        ~");
        System.out.println("~   e. Exit Application                                 ~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public void optimusUI_main_menu(Optimus_Software_UI systemUI){
        systemUI.optimusUI_welcome_message();
        systemUI.optimusUI_welcome_message_project_options();
    }

    /*
        =============================================================================================
     */


    /*
    ================================== "In-Project" Menu UI & Functionality ==============================
    */

    // Menu options for project user is currently in.
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
        System.out.println("~   2. Edit Software Project Information                ~");
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

    public void optimusUI_edit_project_members_options(){
        System.out.println("~   Please enter the specified key for an option below: ~");
        System.out.println("~   1. Add a Project Team Member                        ~");
        System.out.println("~   2. Remove a Project Team Member                     ~");
        System.out.println("~   3. Edit a Project Team Member                       ~");
        System.out.println("~   e. Back                                             ~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public void optimusUI_edit_project_member_options(){
        System.out.println("~   Please enter the specified key for an option below: ~");
        System.out.println("~   1. Edit The Member's First Name                     ~");
        System.out.println("~   2. Edit The Member's Last Name                      ~");
        System.out.println("~   3. Edit The Member's Manager Status                 ~");
        System.out.println("~   e. Back                                             ~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public void optimusUI_choose_project_memberUI(Software_Project_Data project){
        System.out.println("~   Please enter the specified key for an option below: ~");
        project.display_project_members();
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
        ArrayList<Software_project_member> project_members = new_project_members_input();

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

    private ArrayList<Software_project_member> new_project_members_input(){
        ArrayList<Software_project_member> new_project_members = new ArrayList<>();
        System.out.println("Do you want to add a team member to the project? (y/n)");
        String add_member = user_input.nextLine().toLowerCase();
        while (add_member.equals("y")){
            Software_project_member project_member = optimusUI_create_new_project_member();
            new_project_members.add(project_member);
            System.out.println("Add another team member to the project? (y/n)");
            add_member = user_input.nextLine().toLowerCase();
        }
        return new_project_members;
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

    /*
    This function takes user input for the members and creates a member object with it.
     */
    public Software_project_member optimusUI_create_new_project_member() {
        String first_name = new_member_first_name_input();
        String last_name = new_member_last_name_input();
        boolean isManager = new_member_manager_input();
        return new Software_project_member(first_name, last_name, isManager);
    }


    public void view_project_information(Software_Project_Data project) {
        System.out.println("Project Name: " + project.getProject_name() + "\n"
                            + "Project Description: " + project.getProject_description() + "\n"
                            + "Project Members: ");
        project.display_project_members();
    }

    /*
        Process Handling for the current software project
        1 - Starts the processes for the Software Project's Project Information
        2 - Starts the processes for the Software Project's Project Requirements
        3 - Starts the processes for the Software Project's Project Monitoring
        e - Takes the user back to the previous menu
     */
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

    /*
        Process Handling when viewing the current project's information
        1 - Displays the current project information data
        2 - Starts the process for editing project information data
        e - Takes the user back to the previous menu
     */
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
        Handles the processing for project modifications
        1 - Starts the process to edit the project name
        2 - Starts the process to edit the project description
        3 - Starts the process to edit the project members
        e - Takes the user back to the previous menu
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

    /*
        These methods edit a Software Projects Basic Information
        - Project Name
        - Project Description
        - Project Members
    */

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

    /*
        Handles the functionality to edit project members on a project.
        1 - Lets the user add a member to the project
        2 - Lets the user remove a member from project
        3 - Lets the user edit a chosen project members information.
        e - Takes the user back to the previous menu
     */
    public void edit_project_members_processing(Software_Project_Data project){
        boolean inMemberOptions = true;
        do {
            optimusUI_edit_project_members_options();
            String selection = user_input.nextLine().toLowerCase();
            switch (selection){
                case "1":
                    add_project_member(project);
                    break;
                case "2":
                    remove_project_member(project);
                    break;
                case "3":
                    edit_project_member(project);
                    break;
                case "e":
                    inMemberOptions = false;
                    System.out.println("Back.");
                    break;
                default:
                    System.out.println("Invalid Input. Try again please.");
            }
        } while (inMemberOptions);

    }

    private void add_project_member(Software_Project_Data project) {
        project.add_project_member(optimusUI_create_new_project_member());
    }

    private void remove_project_member(Software_Project_Data project) {
        if(project.get_members_list_size() == 0) {
            System.out.println("The project currently has no members to remove.");
        } else {
            project.remove_project_member(project.find_member_index(user_input));
        }
    }

    private void edit_project_member(Software_Project_Data project) {
        boolean editingMember = true;
        if(project.get_members_list_size() == 0) {
            System.out.println("The project currently has no members to remove.");
        } else {
            int member_index = project.find_member_index(user_input);
            do {
                optimusUI_edit_project_member_options();
                String selection = user_input.nextLine().toLowerCase();
                switch (selection){
                    case "1":
                        edit_member_first_name(project.project_members.get(member_index));
                        break;
                    case "2":
                        edit_member_last_name(project.project_members.get(member_index));
                        break;
                    case "3":
                        edit_member_manager_status(project.project_members.get(member_index));
                        break;
                    case "e":
                        editingMember = false;
                        System.out.println("Back.");
                        break;
                    default:
                        System.out.println("Invalid Input. Try again please.");
                }
            } while (!editingMember);
        }
    }


    /*
        These methods edit a project members Basic Information
        - First Name
        - Last Name
        - Manager Status
    */

    // Receives user input and changes the selected project members first name
    public void edit_member_first_name(Software_project_member member){
        System.out.println("Enter the new first name: ");
        String new_first_name = user_input.nextLine();
        member.setFirst_name(new_first_name);
        System.out.println("Member's first name updated.");
    }

    // Receives user input and changes the selected project members last name
    public void edit_member_last_name(Software_project_member member){
        System.out.println("Enter the new last name: ");
        String new_last_name = user_input.nextLine();
        member.setLast_name(new_last_name);
        System.out.println("Member's last name updated.");
    }

    // Receives user input and changes the selected project members member status
    public void edit_member_manager_status(Software_project_member member){
        System.out.println("Is the member a manager? (y/n) ");
        String isManager = user_input.nextLine().toLowerCase();
        if(isManager.equals("y")) {
            member.setManager(true);
        } else {
            member.setManager(false);
        }
        System.out.println("Member's project manager status was updated.");
    }

}
