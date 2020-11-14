package com.chosen;

public class software_project_member {
    String first_name;
    String last_name;
    boolean isManager;

    public software_project_member(String first_name, String last_name, boolean isManager) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.isManager = isManager;
    }

    public void display_member_data(){
        if(this.isManager) {
            System.out.println(this.first_name + " " + this.last_name + " (Manager)");
        } else {
            System.out.println(this.first_name + " " + this.last_name);
        }
    }









    /*
    Getters & Setters
     */
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        this.isManager = manager;
    }
}
