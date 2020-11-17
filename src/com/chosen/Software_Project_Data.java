package com.chosen;

import java.util.ArrayList;
import java.util.Scanner;

public class Software_Project_Data {
    private String project_name;
    private String project_description;
    public ArrayList<software_project_member> project_members;

    public Software_Project_Data() {
    }

    public Software_Project_Data(String project_name, String project_description, ArrayList<software_project_member> project_members) {
        this.project_name = project_name;
        this.project_description = project_description;
        this.project_members = project_members;
    }

    public void add_member(software_project_member new_member){
        project_members.add(new_member);

    }

    public void remove_member(int index) {
        software_project_member removed = project_members.get(index);
        System.out.print("Removed ");
        removed.display_member_data();
        project_members.remove(index);
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
            for (software_project_member member : project_members) {
                System.out.print("  " + count + ". ");
                member.display_member_data();
                count++;
            }
        }
    }

    //Needs Error handling
    public int get_member_index(Scanner input) {
        System.out.println("Enter the specified number to select a member: ");
        display_project_members();
        String num = input.nextLine();
        return Integer.parseInt(num) - 1;
    }

    public software_project_member get_member(int index) {
        return project_members.get(index);
    }

    public boolean valid_index(int index) {
        return index > 0 && index <= (project_members.size() - 1);
    }

    public void setProject_members(ArrayList<software_project_member> project_members) {
        this.project_members = project_members;
    }
}
