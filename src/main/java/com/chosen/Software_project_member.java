package com.chosen;

public class Software_project_member {
    private String first_name;
    private String last_name;
    private boolean isManager;

    public Software_project_member(String first_name, String last_name, boolean isManager) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.isManager = isManager;
    }

    /*
        Displays information for a specific project member.
        If the member is a manager that is also displayed.
     */
    public void display_member_data(){
        if(this.isManager) {
            System.out.println(this.first_name + " " + this.last_name + " (Manager)");
        } else {
            System.out.println(this.first_name + " " + this.last_name);
        }
    }

    /*
        Project Member Getters & Setters
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

    public void setManager(boolean manager) {
        this.isManager = manager;
    }
}
