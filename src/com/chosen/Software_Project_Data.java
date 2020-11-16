package com.chosen;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Software_Project_Data {
    private String project_name;
    private String project_description;
    private ArrayList<software_project_member> project_members;

    public Software_Project_Data() {
    }

    public Software_Project_Data(String project_name, String project_description, ArrayList<software_project_member> project_members) {
        this.project_name = project_name;
        this.project_description = project_description;
        this.project_members = project_members;
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

    public void setProject_members(ArrayList<software_project_member> project_members) {
        this.project_members = project_members;
    }
}
