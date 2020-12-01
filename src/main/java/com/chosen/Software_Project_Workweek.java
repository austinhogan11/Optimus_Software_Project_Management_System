package com.chosen;

import java.util.*;

/**Software_Project_Workweek
 * This class represents a full work week. A project would have a list of workweeks with each of the members
 * and their hours for each week.
 * */
public class Software_Project_Workweek {
    private ArrayList<Float> person_hours;
    private List<Software_project_member> team_member_list;
    private float total_hours_worked;
    private String state;
    public Software_Project_Workweek(List<Software_project_member> team_member_list)
    {
        this.team_member_list = team_member_list;
        person_hours = new ArrayList<Float>();
        initSoftwareProjectSchedule();
    }

    private void initSoftwareProjectSchedule()
    {
        state = "default";
        for (int i = 0; i < team_member_list.size(); i++)
        {
            person_hours.add(0f);
        }
        total_hours_worked = 0f;
    }

    public void ChangeState(String state)
    {
        this.state = state;
    }

    public void AddHoursByMember(int member_index, float newHours)
    {
        float previousHours = person_hours.get(member_index);
        person_hours.remove(member_index);
        person_hours.add(member_index, previousHours + newHours);
        total_hours_worked += newHours;
    }

    public void ChangeHoursByMember(int member_index, float newHours)
    {
        float previousHours = person_hours.get(member_index);
        total_hours_worked -= previousHours;
        person_hours.remove(member_index);
        person_hours.add(member_index, newHours);
        total_hours_worked += newHours;
    }

    public float GetTotalHoursWorked()
    {
        return total_hours_worked;
    }

    public void print()
    {
        float totalPersonHours = 0f;

        System.out.println("State of Project: " + state);
        for (int i = 0; i < team_member_list.size(); i++)
        {
            String firstName = team_member_list.get(i).getFirst_name();
            String lastName = team_member_list.get(i).getLast_name();
            String fullName = firstName + " " + lastName;
            float member_hours = person_hours.get(i);
            if (member_hours == 0f)
            {
                continue;
            }
            System.out.println(i+1 + ". " + fullName + ": " + member_hours + " hours");
            totalPersonHours += person_hours.get(i);
        }
        System.out.println("Total person hours this work week: " + totalPersonHours + "\n");
    }
}
