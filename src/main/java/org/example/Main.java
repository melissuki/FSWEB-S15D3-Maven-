package org.example;

import org.example.entity.Employee;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(4, "Burak", "Cevizli"));
    }

    public static List<Employee> findDuplicates(List<Employee> employees) {
        Map<Integer, Employee> employeeMap = new HashMap<>();
        List<Employee> duplicates = new LinkedList<>();

        for (Employee emp : employees) {
            if (emp == null) continue;
            if (employeeMap.containsKey(emp.getId())) {
                if (!duplicates.contains(emp)) {
                    duplicates.add(emp);
                }
            } else {
                employeeMap.put(emp.getId(), emp);
            }
        }
        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        Map<Integer, Employee> uniqueMap = new HashMap<>();

        for (Employee emp : employees) {
            if (emp == null) continue;
            if (!uniqueMap.containsKey(emp.getId())) {
                uniqueMap.put(emp.getId(), emp);
            }
        }
        return uniqueMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (Employee emp : employees) {
            if (emp == null) continue;
            countMap.put(emp.getId(), countMap.getOrDefault(emp.getId(), 0) + 1);
        }

        List<Employee> onlyUniques = new LinkedList<>();
        for (Employee emp : employees) {
            if (emp == null) continue;
            if (countMap.get(emp.getId()) == 1) {
                onlyUniques.add(emp);
            }
        }
        return onlyUniques;
    }
}