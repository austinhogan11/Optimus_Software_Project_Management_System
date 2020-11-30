package com.chosen;

import java.util.*;

/**Software_Project_Workweek
 * This class represents a full work week. A project would have a list of workweeks with each of the members
 * and their hours for each week.
 * */
public class Software_Project_Workweek {
    private Map<Software_project_member, Float> person_hours;
    private List<Software_project_member> team_member_list;
    private float total_hours_worked;
    private String state;
    public Software_Project_Workweek(List<Software_project_member> team_member_list)
    {
        this.team_member_list = team_member_list;
        person_hours = new HashMap<>();
        initSoftwareProjectSchedule();
    }

    private void initSoftwareProjectSchedule()
    {
        state = "default";
        for (int i = 0; i < team_member_list.size(); i++)
        {
            person_hours.put(team_member_list.get(i), 0f);
        }
        total_hours_worked = 0f;
    }

    public void ChangeState(String state)
    {
        this.state = state;
    }

    public void AddHoursByMember(Software_project_member member, float newHours)
    {
        var previousHours = person_hours.get(member);
        person_hours.put(member, previousHours + newHours);
        total_hours_worked += newHours;
    }

    public void ChangeHoursByMember(Software_project_member member, float newHours)
    {
        var previousHours = person_hours.get(member);
        total_hours_worked -= previousHours;
        person_hours.put(member, newHours);
        total_hours_worked += newHours;
    }

    public float GetTotalHoursWorked()
    {
        return total_hours_worked;
    }

    public void print()
    {
        float totalPersonHours = 0f;

        for (int i = 0; i < team_member_list.size(); i++)
        {
            var firstName = team_member_list.get(i).getFirst_name();
            var lastName = team_member_list.get(i).getLast_name();
            var fullName = firstName + " " + lastName;
            var member_hours = person_hours.get(team_member_list.get(i));
            if (member_hours == null)
            {
                continue;
            }
            System.out.println("State of Project: " + state);
            System.out.println(i+1 + ". " + fullName + ": " + member_hours + " hours");
            totalPersonHours += person_hours.get(team_member_list.get(i));
        }
        System.out.println("Total person hours this work week: " + totalPersonHours + "\n");
    }
}
