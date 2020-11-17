package com.chosen;

import java.util.ArrayList;
import java.util.Scanner;

public class Software_Project_Data {
    private String project_name;
    private String project_description;
    public ArrayList<Software_project_member> project_members;

    public Software_Project_Data() {
    }

    public Software_Project_Data(String project_name, String project_description, ArrayList<Software_project_member> project_members) {
        this.project_name = project_name;
        this.project_description = project_description;
        this.project_members = project_members;
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
    //
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
    }

    public Software_project_member get_member(int index) {
        return project_members.get(index);
    }

    public boolean valid_index(int index) {
        return index > 0 && index <= (project_members.size() - 1);
    }

    public void setProject_members(ArrayList<Software_project_member> project_members) {
        this.project_members = project_members;
    }

    public ArrayList<Software_project_member> getProject_members(){
        return project_members;
    }
    public Software_project_member getProject_member_at_id(int id){
        return project_members.get(id);
    }
}
