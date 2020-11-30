package com.chosen;

import java.util.ArrayList;
import java.util.Scanner;

public class Software_Project_Data {
    private String project_name;
    private String project_description;
    public ArrayList<Software_project_member> project_members;
    public ArrayList<String> project_functional_reqs;
    public ArrayList<String> project_nonfunctional_reqs;
    private ArrayList<Software_Project_Workweek> project_workweeks;

    public Software_Project_Data(String project_name, String project_description,
                                 ArrayList<Software_project_member> project_members,
                                 ArrayList<Software_Project_Workweek> project_workweeks) {
        this.project_name = project_name;
        this.project_description = project_description;
        this.project_members = project_members;
        this.project_workweeks = project_workweeks;
        this.project_functional_reqs = new ArrayList<>();
        this.project_nonfunctional_reqs = new ArrayList<>();

    }

    /* ---------------------------------- Project Member Handling----------------------------------- */

    // Adds a new project member to the list of project_members for the current project.
    public void add_project_member(Software_project_member new_member){
        project_members.add(new_member);
    }

    // Removes a project member at a specific index of project_members for the current project.
    public void remove_project_member(int index) {
        Software_project_member removed = project_members.get(index);
        System.out.print("Removed ");
        removed.display_member_data();
        project_members.remove(index);
    }

    //Needs Error handling
    public int find_member_index(Scanner input) {
        System.out.println("Enter the specified number to select a member: ");
        display_project_members();
        String num = input.nextLine();
        return Integer.parseInt(num) - 1;
    }

    public void display_project_members() {
        int count = 1;
        if (project_members.size() > 0) {
            for (Software_project_member member : project_members) {
                System.out.print("  " + count + ". ");
                member.display_member_data();
                count++;
            }
        }
        else
        {
            System.out.println("No members to show. It's so lonely :(");
        }
    }

    /* ---------------------------------- Project Requirements Handling----------------------------------- */

    // Retrieves the size of either the functional or non-functional requirements lists
    public int get_requirements_list_size(ArrayList<String> reqs){
        return reqs.size();
    }

    // Retrieves the index for a specific requirement to be removed from either the functional or non-functional requirements
    public int find_requirement_index(Scanner input, ArrayList<String> reqs) {
        System.out.println("Enter the specified number to select a member: ");
        display_list_requirements(reqs);
        return (Integer.parseInt(input.nextLine()) - 1);
    }

    // Removes a requirement at a specified index of the functional or non-functional requirements list.
    public void remove_requirement(int index, ArrayList<String> reqs) {
        System.out.println("Removed requirement.");
        reqs.remove(index);
    }

    public void display_list_requirements(ArrayList<String> reqs){
        int count = 1;
        if (reqs.size() > 0) {
            for (String req : reqs) {
                System.out.println(count++ + ". " + req);
            }
        } else {
            System.out.println("The project has no requirements.");
        }
    }

    /* ---------------------------------- Project Effort Monitoring Handling----------------------------------- */

    public void display_project_workweeks()
    {
        if (project_workweeks.size() > 0)
        {
            var overall_hours_worked = 0f;
            for (int i = 0; i < project_workweeks.size(); i++)
            {
                var weekNum = i + 1;
                System.out.println("Effort Data for Week " + weekNum + ":");
                project_workweeks.get(i).print();
                overall_hours_worked += project_workweeks.get(i).GetTotalHoursWorked();
            }
            System.out.println("Total Hours Overall: " + overall_hours_worked + "\n");
        }
        else
        {
            System.out.println("No workweeks to show :(");
        }
    }

    public void Add_Workweek(Software_Project_Workweek newWorkweek)
    {
        project_workweeks.add(newWorkweek);
    }

    public Software_Project_Workweek get_workweek(int index)
    {
        return project_workweeks.get(index);
    }

    public int get_workweek_count()
    {
        return project_workweeks.size();
    }

    /*
        Software Project Getters & Setters
     */
    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getProject_description() {
        return project_description;
    }

    public void setProject_description(String project_description) {
        this.project_description = project_description;
    }

    public int get_members_list_size(){
       return project_members.size();
    }

    public Software_project_member get_member(int index) {
        return project_members.get(index);
    }

    public ArrayList<Software_project_member> getProject_members(){
        return project_members;
    }
}
