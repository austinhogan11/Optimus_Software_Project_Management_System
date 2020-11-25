package com.chosen;

import java.util.ArrayList;
import java.util.Scanner;

public class Software_Project_Data {
    private String project_name;
    private String project_description;
    public ArrayList<Software_project_member> project_members;
    private ArrayList<Software_Project_Workweek> project_workweeks;

    public Software_Project_Data(String project_name, String project_description,
                                 ArrayList<Software_project_member> project_members,
                                 ArrayList<Software_Project_Workweek> project_workweeks) {
        this.project_name = project_name;
        this.project_description = project_description;
        this.project_members = project_members;
        this.project_workweeks = project_workweeks;
    }

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
            System.out.println("Total Hours Overall: " + overall_hours_worked);
        }
        else
        {
            System.out.println("No workweeks to show :(");
        }
    }

    public Software_project_member get_member(int index) {
        return project_members.get(index);
    }

    public ArrayList<Software_project_member> getProject_members(){
        return project_members;
    }
    public Software_project_member getProject_member_at_id(int id){
        return project_members.get(id);
    }
}
