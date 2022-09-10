package com.interview.sixsense;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://docs.google.com/document/d/16u6VEFLbtzgA-2FZptJckoYoT1tQzAsdt_D9_PjmISg/edit
 */
public class PrintInSuchPattern {

    public void printHierarchy(List<Employee> emps){
        if(emps == null || emps.isEmpty())
            return;
        Set<Integer> alreadyVisited = new HashSet<>();
        Map<Integer, Employee> employeeMap = new HashMap<>();
        Map<Integer, List<Employee>> managerToEmployeeMap = new HashMap<>();
        for(Employee emp:  emps){
            List<Employee> employee = managerToEmployeeMap.getOrDefault(emp.getManagerId(), new ArrayList<>());
            employee.add(emp);
            managerToEmployeeMap.put(emp.getManagerId(), employee);
            employeeMap.put(emp.getId(), emp);
        }

        managerToEmployeeMap.forEach((k,v) -> {
            Integer managerId = k;
            List<Employee> employee = v;
            if(!alreadyVisited.contains(managerId)){
                if(managerId == null) {
                    System.out.println(employee.get(0).getName());
                    System.out.println("|__");
                }
                else {
                    System.out.println(employee.get(0).getName());
                    System.out.println("|__");
                }
            }
        });
    }
}
class Employee{

    private int id;
    private String name;
    // id of employee
    private int managerId;

    public Employee(int id, String name, int managerId) {
        this.id = id;
        this.name = name;
        this.managerId = managerId;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", managerId=" + managerId +
                '}';
    }
}
