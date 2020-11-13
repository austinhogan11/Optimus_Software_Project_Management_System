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
    public void optimus_UI_in_project_menu_options(){
        System.out.println("~   Please enter the specified key for an option below: ~");
        System.out.println("~   1. View Software Project Information                ~");
        System.out.println("~   2. Enter or Edit Software Project Information       ~");
        System.out.println("~   3. View Software Project Requirements               ~");
        System.out.println("~   4. Enter Edit Software Project Requirements         ~");
        System.out.println("~   5. View Software Project Monitoring Data            ~");
        System.out.println("~   6. Enter or Edit Software Project Monitoring Data   ~");
        System.out.println("~   e. Back to Main Menu                                ~");
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


}
