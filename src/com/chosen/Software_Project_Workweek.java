package com.chosen;

import java.util.*;

/**Software_Project_Workweek
 * This class represents a full work week. A project would have a list of workweeks with each of the members
 * and their hours for each week.
 * */
public class Software_Project_Workweek {
    Map<Software_project_member, Float> person_hours;
    List<Software_project_member> team_member_list;
    private float total_hours_worked;
    public Software_Project_Workweek(List<Software_project_member> team_member_list)
    {
        this.team_member_list = team_member_list;
        person_hours = new HashMap<>();
        initSoftwareProjectSchedule();
    }

    private void initSoftwareProjectSchedule()
    {
        for (int i = 0; i < team_member_list.size(); i++)
        {
            person_hours.put(team_member_list.get(i), 0f);
        }
        total_hours_worked = 0f;
    }

    public void AddHoursByMember(Software_project_member member, float newHours)
    {
        var previousHours = person_hours.get(member);
        person_hours.put(member, previousHours + newHours);
        total_hours_worked += newHours;
    }

    public float GetTotalHoursWorked()
    {
        return total_hours_worked;
    }

    public void print()
    {
        float totalPersonHours = 0f;
        for(Software_project_member person: person_hours.keySet())
        {
            System.out.println(person.getFirst_name() + " " + person.getLast_name() + ": "
                    + person_hours.get(person) + " hours");
            totalPersonHours += person_hours.get(person);
        }
        System.out.println("Total person hours this work week: " + totalPersonHours);
    }
}
