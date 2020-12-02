package com.chosen;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.Reader;

import java.util.ArrayList;
import java.util.Scanner;

public class Optimus_Software_UI {
    private final Scanner user_input = new Scanner(System.in);
    private Optimus_File_Handling specFile;

    public Optimus_Software_UI(Optimus_File_Handling specFile) {
        this.specFile = specFile;
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
    public void optimusUI_main_menu() {
        System.out.println("~   Please enter the specified key for an option below: ~");
        System.out.println("~   1. Create a new Software Project                    ~");
        System.out.println("~   2. Open an Existing Project.                        ~");
        System.out.println("~   e. Exit Application                                 ~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public void optimusUI_main_menu_UI(){
        optimusUI_welcome_message();
        optimusUI_main_menu();
    }

    //  Still needs to be implemented
    public void optimusUI_main_menu_processing(Optimus_Software_UI systemUI){

        boolean appIsOpen = true;
        boolean atMainMenu = true;

        Software_Project_Data currently_accessed_project = new Software_Project_Data();

        do {
            systemUI.optimusUI_main_menu_UI();
            String selection = user_input.nextLine();
            switch(selection) {
                case "1":
                    Software_Project_Data new_software_project = systemUI.optimusUI_create_new_project();
                    systemUI.current_project_processing(systemUI, new_software_project);
                    currently_accessed_project = new_software_project;
                    atMainMenu = true;
                    break;
                case "2":
                    atMainMenu = false;
                    Software_Project_Data project = deserialize_objects();
                    current_project_processing(systemUI, project);
                    systemUI.serialize_objects(project);
                    break;
                case "e":
                    systemUI.serialize_objects(currently_accessed_project);
                    appIsOpen = false;
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Invalid Input. Try again please.");
            }
        } while (appIsOpen && atMainMenu);
    }

    /*
        ================================== Create A New Project UI & Functionality ===========================================
    */

    /*
        Function Calls:
        - enter_new_project_name() - returns a string containing the New Project's Name.
        - enter_new_project_description() - returns a string containing the New Project's Description.
        - enter_new_project_members() - returns an ArrayList<Software_project_member> containing the new Project's Members.
        The name, Description, & Members collected are passed to as parameters to create a new Software_Project_Data Object serving as the new software project.
    */
    public Software_Project_Data optimusUI_create_new_project() {
        System.out.println("~                 Create a New Project                  ~");
        String project_name = enter_new_project_name();
        String project_desc = new_project_description_input();
        ArrayList<Software_project_member> project_members = new_project_members_input();
        ArrayList<Software_Project_Workweek> project_workweeks = new_project_workweeks_input(project_members);
        return new Software_Project_Data(project_name, project_desc, project_members, project_workweeks);
    }

    /*
        Returns user input for a new Software Project's Name.
        Called by optimusUI_create_new_project()
     */
    private String enter_new_project_name(){
        System.out.println("~   Enter the Software Project's Name:                  ~");
        return user_input.nextLine();
    }

    /*
        Returns user input for a new Software Project's Description
        Called by optimusUI_create_new_project()
     */
    private String new_project_description_input(){
        System.out.println("~   Enter the Software Project's Description:                  ~");
        return user_input.nextLine();
    }

    /*
        Returns a list of Software Project Members from the User's input.
        Called by optimusUI_create_new_project()
     */
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

    //  Processes user input & Returns a new Software_project_member option to be added to the projects list of members.
    //  Used above in new_project_members_input();
    public Software_project_member optimusUI_create_new_project_member() {
        String first_name = new_member_first_name_input();
        String last_name = new_member_last_name_input();
        boolean isManager = new_member_manager_input();
        return new Software_project_member(first_name, last_name, isManager);
    }

    private ArrayList<Software_Project_Workweek> new_project_workweeks_input(ArrayList<Software_project_member> members)
    {
        ArrayList<Software_Project_Workweek> new_project_workweeks = new ArrayList<>();
        System.out.println("Do you want to add a workweek to the project? (y/n)");
        String add_workweek = user_input.nextLine().toLowerCase();
        while (add_workweek.equals("y")){
            Software_Project_Workweek project_workweek = optimusUI_create_new_project_workweek(members);
            new_project_workweeks.add(project_workweek);
            System.out.println("Add another workweek to the project? (y/n)");
            add_workweek = user_input.nextLine().toLowerCase();
        }
        return new_project_workweeks;
    }

    public Software_Project_Workweek optimusUI_create_new_project_workweek(ArrayList<Software_project_member> members) {
        Software_Project_Workweek new_workweek = new Software_Project_Workweek(members);
        System.out.println("~   Enter the state:                                    ~");
        String state = user_input.nextLine().toLowerCase();
        new_workweek.ChangeState(state);

        for (int i = 0; i < members.size(); i++) {
            String firstName = members.get(i).getFirst_name();
            String lastName = members.get(i).getLast_name();
            String member_fullName = firstName + " " + lastName;

            System.out.println("~   Enter the hours for " + member_fullName + ":                  ~");
            float hours = Float.parseFloat(user_input.nextLine().toLowerCase());

            new_workweek.AddHoursByMember(i, hours);
        }
        return new_workweek;
    }

    //  Retrieves the first name for a new project member.
    //  Used in optimusUI_create_new_project_member() above.
    private String new_member_first_name_input() {
        System.out.println("~   Enter the project member's first name:                  ~");
        return user_input.nextLine().toLowerCase();
    }

    //  Retrieves the last name for a new project member.
    //  Used in optimusUI_create_new_project_member() above.
    private String new_member_last_name_input() {
        System.out.println("~   Enter the project member's last name:                  ~");
        return user_input.nextLine().toLowerCase();
    }

    //  Retrieves the manager status for a new project member.
    //  Used in optimusUI_create_new_project_member() above.
    private boolean new_member_manager_input() {
        System.out.println("~   Is this project member a project manager? (y/n)                  ~");
        return user_input.nextLine().toLowerCase().equals("y");
    }

    /*
        ================================== "Current Project" Project Information UI & Functionality ==============================
    */

    // Current Project Menu UI
    public void optimusUI_current_project_menu(){
        System.out.println("~   Please enter the specified key for an option below: ~");
        System.out.println("~   1. Software Project Information                     ~");
        System.out.println("~   2. Software Project Requirements                    ~");
        System.out.println("~   3. Software Project Effort Monitoring               ~");
        System.out.println("~   e. Back to Main Menu                                ~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    /*
        Process Handling for the current software project
        1 - Starts the processes for the Software Project's Project Information
        2 - Starts the processes for the Software Project's Project Requirements
        3 - Starts the processes for the Software Project's Project Monitoring
        e - Takes the user back to the previous menu
     */
    public void current_project_processing(Optimus_Software_UI system_UI, Software_Project_Data current_project) {
        boolean atProjectMenu = true;
        do {
            system_UI.optimusUI_current_project_menu();
            String selection = user_input.nextLine().toLowerCase();
            switch (selection) {
                case "1":
                    system_UI.project_information_processing(system_UI, current_project);
                    break;
                case "2":
                    system_UI.project_requirements_processing(system_UI, current_project);
                    break;
                case "3":
                    system_UI.project_effort_monitoring_processing(system_UI, current_project);
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

    // Currently Accessed Project, Project Information Menu
    public void optimusUI_project_information_menu(){
        System.out.println("~   Please enter the specified key for an option below: ~");
        System.out.println("~   1. View Software Project Information                ~");
        System.out.println("~   2. Edit Software Project Information                ~");
        System.out.println("~   e. Back                                             ~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    /*
        Process Handling when viewing the current project's information
        1 - Displays the current project information data
        2 - Starts the process for editing project information data
        e - Takes the user back to the previous menu
     */
    public void project_information_processing(Optimus_Software_UI systemUI, Software_Project_Data project) {
        boolean inProjectInfo = true;
        do {
            systemUI.optimusUI_project_information_menu();
            String selection = user_input.nextLine().toLowerCase();
            switch (selection) {
                case "1":
                    systemUI.view_project_information(project);
                    break;
                case "2":
                    systemUI.project_information_modification_processing(systemUI, project);
                    break;
                case "e":
                    inProjectInfo = false;
                    break;
                default:
                    System.out.println("Invalid Input. Try again please.");

            }
        } while (inProjectInfo);
    }

    //  Displays Project information when option 1 in optimusUI_project_information_menu() is selected.
    public void view_project_information(Software_Project_Data project) {
        System.out.println("Project Name: " + project.getProject_name() + "\n"
                + "Project Description: " + project.getProject_description() + "\n"
                + "Project Members: ");
        project.display_project_members();
    }

    //
    public void optimusUI_project_information_modification_menu(){
        System.out.println("~   Please enter the specified key for an option below: ~");
        System.out.println("~   1. Edit Project Name                                ~");
        System.out.println("~   2. Edit Project Description                         ~");
        System.out.println("~   3. Edit Project Members                             ~");
        System.out.println("~   e. Back                                             ~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    /*
    Handles the processing for project modifications
    1 - Starts the process to edit the project name
    2 - Starts the process to edit the project description
    3 - Starts the process to edit the project members
    e - Takes the user back to the previous menu
 */
    public void project_information_modification_processing(Optimus_Software_UI systemUI, Software_Project_Data project) {
        boolean inEditProjectMenu = true;
        do {
            systemUI.optimusUI_project_information_modification_menu();
            String selection = user_input.nextLine().toLowerCase();
            switch (selection) {
                case "1":
                    systemUI.edit_project_name(project);
                    break;
                case "2":
                    systemUI.edit_project_description(project);
                    break;
                case "3":
                    systemUI.project_membersList_modification_processing(project);
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

    public void optimusUI_project_membersList_modification_menu(){
        System.out.println("~   Please enter the specified key for an option below: ~");
        System.out.println("~   1. Add a Project Team Member                        ~");
        System.out.println("~   2. Remove a Project Team Member                     ~");
        System.out.println("~   3. Edit a Project Team Member                       ~");
        System.out.println("~   e. Back                                             ~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    /*
        Handles the functionality to edit project members on a project.
        1 - Lets the user add a member to the project
        2 - Lets the user remove a member from project
        3 - Lets the user edit a chosen project members information.
        e - Takes the user back to the previous menu
     */
    public void project_membersList_modification_processing(Software_Project_Data project){
        boolean inMemberOptions = true;
        do {
            optimusUI_project_membersList_modification_menu();
            String selection = user_input.nextLine().toLowerCase();
            switch (selection){
                case "1":
                    add_project_member(project);
                    break;
                case "2":
                    remove_project_member(project);
                    break;
                case "3":
                    project_member_modification_processing(project);
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

    // Adds a project member to the current project.
    private void add_project_member(Software_Project_Data project) {
        project.add_project_member(optimusUI_create_new_project_member());
    }

    // Removes a specified project member from a project.
    private void remove_project_member(Software_Project_Data project) {
        if(project.get_members_list_size() == 0) {
            System.out.println("The project currently has no members to remove.");
        } else {
            project.remove_project_member(project.find_member_index(user_input));
        }
    }

    public void optimusUI_project_member_modification_menu(){
        System.out.println("~   Please enter the specified key for an option below: ~");
        System.out.println("~   1. Edit The Member's First Name                     ~");
        System.out.println("~   2. Edit The Member's Last Name                      ~");
        System.out.println("~   3. Edit The Member's Manager Status                 ~");
        System.out.println("~   e. Back                                             ~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    // Project Member Modification Handling
    private void project_member_modification_processing(Software_Project_Data project) {
        boolean editingMember = true;
        if(project.get_members_list_size() == 0) {
            System.out.println("The project currently has no members to remove.");
        } else {
            int member_index = project.find_member_index(user_input);
            do {
                optimusUI_project_member_modification_menu();
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
        member.setManager(isManager.equals("y"));
        System.out.println("Member's project manager status was updated.");
    }


    /*
        ================================== "Current Project" Project Effort ==============================
    */

    public void optimusUI_project_effort_menu(){
        System.out.println("~   Please enter the specified key for an option below: ~");
        System.out.println("~   1. Add Software Project Workweeks                   ~");
        System.out.println("~   2. View Software Project Workweeks                  ~");
        System.out.println("~   3. Edit Software Project Workweeks                  ~");
        System.out.println("~   e. Back                                             ~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public void project_effort_monitoring_processing(Optimus_Software_UI systemUI, Software_Project_Data project) {
        boolean inProjectEffort = true;
        do {
            systemUI.optimusUI_project_effort_menu();
            String selection = user_input.nextLine().toLowerCase();
            switch (selection) {
                case "1":
                    systemUI.add_project_effort_workweeks(systemUI, project);
                    break;
                case "2":
                    systemUI.view_project_effort_workweeks(project);
                    break;
                case "3":
                    systemUI.edit_project_effort_workweeks(systemUI, project);
                    break;
                case "e":
                    inProjectEffort = false;
                    break;
                default:
                    System.out.println("Invalid Input. Try again please.");

            }
        } while (inProjectEffort);
    }

    public void add_project_effort_workweeks(Optimus_Software_UI systemUI, Software_Project_Data project) {
        project.Add_Workweek(systemUI.optimusUI_create_new_project_workweek(project.getProject_members()));
    }

    public void view_project_effort_workweeks(Software_Project_Data project) {
        project.display_project_workweeks();
    }

    public void optimusUI_project_effort_edit_menu(Software_Project_Data project){
        int numWorkweeks = project.get_workweek_count();
        for (int i = 0; i < numWorkweeks; i++)
        {
            System.out.println((i+1) + ". Week " + (i+1));
        }
        System.out.println("e. Back");
    }

    public void workweek_member_mod_menu(Software_Project_Data project, Software_Project_Workweek workweek)
    {
        while (true)
        {
            System.out.println("Select a member:");
            workweek.print();
            System.out.println("e: Back");
            String selection = user_input.nextLine().toLowerCase();
            int selection_index = -1;
            boolean numeric = true;
            try
            {
                selection_index = Integer.parseInt(selection) - 1;
            }
            catch (Exception e)
            {
                numeric = false;
            }
            if (selection.equalsIgnoreCase("e"))
            {
                break;
            }
            if (numeric && (selection_index < 0 || selection_index >= project.get_workweek_count()))
            {
                System.out.println("Invalid Input. Try again please.");
                continue;
            }
            if (!numeric && !selection.equalsIgnoreCase("e"))
            {
                System.out.println("Invalid Input. Try again please.");
                continue;
            }

            String firstName = project.get_member(selection_index).getFirst_name();
            String lastName = project.get_member(selection_index).getLast_name();
            String fullName = firstName + " " + lastName;

            System.out.println("Enter new hours for " + fullName);
            Float input = Float.parseFloat(user_input.nextLine().toLowerCase());
            workweek.ChangeHoursByMember(selection_index, input);
        }
    }

    public void edit_project_effort_workweeks(Optimus_Software_UI systemUI, Software_Project_Data project) {
        while (true)
        {
            System.out.println("Select a workweek:");
            systemUI.optimusUI_project_effort_edit_menu(project);
            String selection = user_input.nextLine().toLowerCase();
            int selection_index = -1;
            boolean numeric = true;
            try
            {
                selection_index = Integer.parseInt(selection) - 1;
            }
            catch (Exception e)
            {
                numeric = false;
            }
            if (selection.equalsIgnoreCase("e"))
            {
                break;
            }
            if (numeric && (selection_index < 0 || selection_index >= project.get_workweek_count()))
            {
                System.out.println("Invalid Input. Try again please.");
                continue;
            }
            if (!numeric && !selection.equalsIgnoreCase("e"))
            {
                System.out.println("Invalid Input. Try again please.");
                continue;
            }
            System.out.println("Week " + (selection));
            systemUI.workweek_member_mod_menu(project, project.get_workweek(selection_index));
        }
    }

    /*
        ================================== "Current Project" Project Requirements UI & Functionality ==============================
    */

    public void optimusUI_project_requirements_options(){
        System.out.println("~   Please enter the specified key for an option below: ~");
        System.out.println("~   1. Software Project Functional Requirements         ~");
        System.out.println("~   2. Software Project Non-Functional Requirements     ~");
        System.out.println("~   e. Back                                             ~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public void optimusUI_functional_requirements_options(){
        System.out.println("~   Please enter the specified key for an option below: ~");
        System.out.println("~   1. View Functional Requirements                     ~");
        System.out.println("~   2. Add a Functional Requirement                     ~");
        System.out.println("~   3. Remove a Functional Requirement                  ~");
        System.out.println("~   e. Back                                             ~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public void optimusUI_non_functional_requirements_options(){
        System.out.println("~   Please enter the specified key for an option below: ~");
        System.out.println("~   1. View Non-Functional Requirements                     ~");
        System.out.println("~   2. Add a Non-Functional Requirement                     ~");
        System.out.println("~   3. Remove a Non-Functional Requirement                  ~");
        System.out.println("~   e. Back                                             ~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public void project_requirements_processing(Optimus_Software_UI systemUI, Software_Project_Data project) {
        boolean inProjectReqs = true;
        do {
            systemUI.optimusUI_project_requirements_options();
            String selection = user_input.nextLine().toLowerCase();
            switch (selection) {
                case "1":
                    functional_requirements_processing(systemUI, project);
                    break;
                case "2":
                    non_functional_requirements_processing(systemUI, project);
                    break;
                case "e":
                    inProjectReqs = false;
                    break;
                default:
                    System.out.println("Invalid Input. Try again please.");
            }
        } while (inProjectReqs);
    }

    public void functional_requirements_processing(Optimus_Software_UI systemUI, Software_Project_Data project) {
        boolean inFunctionalReqs = true;
        do {
            systemUI.optimusUI_functional_requirements_options();
            String selection = user_input.nextLine().toLowerCase();
            switch (selection) {
                case "1":
                    view_functional_reqs(project);
                    break;
                case "2":
                    add_project_functional_requirement(project);
                    break;
                case "3":
                    remove_project_functional_requirement(project);
                    break;
                case "e":
                    inFunctionalReqs = false;
                    break;
                default:
                    System.out.println("Invalid Input. Try again please.");
            }
        } while (inFunctionalReqs);
    }

    public void view_functional_reqs(Software_Project_Data project){
        project.display_list_requirements(project.project_functional_reqs);
    }

    public void add_project_functional_requirement(Software_Project_Data project){
        System.out.println("Enter the functional requirement: ");
        String functional_req = user_input.nextLine();
        project.project_functional_reqs.add(functional_req);
    }

    public  void remove_project_functional_requirement(Software_Project_Data project){
        int list_size = project.get_requirements_list_size(project.project_functional_reqs);
        if (list_size < 1){
            System.out.println("There are no functional requirements to remove.");
        } else {
            int index = project.find_requirement_index(user_input, project.project_functional_reqs);
            project.remove_requirement(index, project.project_functional_reqs);
        }
    }


    public void non_functional_requirements_processing(Optimus_Software_UI systemUI, Software_Project_Data project) {
        boolean inNonFunctionalReqs = true;
        do {
            systemUI.optimusUI_non_functional_requirements_options();
            String selection = user_input.nextLine().toLowerCase();
            switch (selection) {
                case "1":
                    view_non_functional_reqs(project);
                    break;
                case "2":
                    add_project_non_functional_requirement(project);
                    break;
                case "3":
                    remove_project_non_functional_requirement(project);
                    break;
                case "e":
                    inNonFunctionalReqs = false;
                    break;
                default:
                    System.out.println("Invalid Input. Try again please.");
            }
        } while (inNonFunctionalReqs);
    }

    public void view_non_functional_reqs(Software_Project_Data project){
        project.display_list_requirements(project.project_nonfunctional_reqs);
    }

    public void add_project_non_functional_requirement(Software_Project_Data project){
        System.out.println("Enter the non-functional requirement: ");
        String non_functional_req = user_input.nextLine();
        project.project_nonfunctional_reqs.add(non_functional_req);
    }

    public  void remove_project_non_functional_requirement(Software_Project_Data project){
        int list_size = project.get_requirements_list_size(project.project_nonfunctional_reqs);
        if (list_size < 1){
            System.out.println("There are no non-functional requirements to remove.");
        } else {
            int index = project.find_requirement_index(user_input, project.project_nonfunctional_reqs);
            project.remove_requirement(index, project.project_nonfunctional_reqs);
        }
    }

    public void serialize_objects(Software_Project_Data project) {
        Gson gson = new Gson();
        String jsonInString = gson.toJson(project);
        specFile.WriteToFile(jsonInString);
    }

    public Software_Project_Data deserialize_objects() {
        Gson gson = new Gson();
        Reader reader = specFile.ReadFromFile();
        Software_Project_Data project = gson.fromJson(reader, Software_Project_Data.class);
        project.toString();
        return project;
    }
}
