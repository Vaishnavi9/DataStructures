package com.StreamCollectors;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        //sum of all digits
        List<Integer> li = Arrays.asList( 3,26,1,4 );
        int sum = li.stream().mapToInt(i -> i).sum();
        int sumWay2 = li.stream().reduce( Integer::sum).get();
        //System.out.println(sum+" "+sumWay2);

        //max integer
        int maxInt = li.stream().reduce((a, b) -> a > b ? a : b).get();
        int maxIntWay2 = li.stream().reduce( Integer::max ).get();
        //System.out.println(maxInt+" "+maxIntWay2);
        List<Employee> employeeList = createEmployeeList();

        Map<String, Employee> employeeMap = new HashMap<String, Employee>();
        employeeMap = employeeList.stream().collect(Collectors.toMap(e-> e.getGrade(), e-> e));
        //System.out.println(employeeMap.get("A").getSalary());

        //partition odd and even salaries
        Map<Boolean, List<Employee>> employeeMap1 = employeeList.stream().collect(Collectors.partitioningBy(e-> e.getSalary()%2==0));
        // System.out.println(employeeMap1.get(false).get(0).getSalary()); // false contains employees with odd salaries
        // System.out.println(employeeMap1.get(true).get(0).getSalary());  // true contains employees with even salaries
        List<Employee> evenSalariedEmployees = employeeMap1.get(true); // retrieve list of employees with even salaries
        //System.out.println(evenSalariedEmployees.size());

        List<Employee> employeeList2 = createEmployeeListForGroupingBy();
        Map<String, List<Employee>> groupingEmployeeOnGrade = employeeList2.stream().collect(Collectors.groupingBy(Employee::getGrade));
        groupingEmployeeOnGrade.forEach((k,v) -> System.out.println(k+" "+v.get(0).getSalary()));



    }

    public static List<Employee> createEmployeeList(){
        List<Employee> employeeList = new ArrayList<Employee>();
            Employee e1 = new Employee("A", 23);
            Employee e2 = new Employee("F", 21);
            Employee e3 = new Employee("C", 23);
            Employee e4 = new Employee("B", 29);
            Employee e5 = new Employee("D", 30);
            Employee e6 = new Employee("E", 20);

            employeeList.add(e1);
            employeeList.add(e2);
            employeeList.add(e3);
            employeeList.add(e4);
            employeeList.add(e5);
            employeeList.add(e6);

            return employeeList;
    }

    public static List<Employee> createEmployeeListForGroupingBy(){
        List<Employee> employeeList = new ArrayList<Employee>();
        Employee e1 = new Employee("A", 23);
        Employee e2 = new Employee("A", 21);
        Employee e3 = new Employee("B", 23);
        Employee e4 = new Employee("B", 29);
        Employee e5 = new Employee("D", 30);
        Employee e6 = new Employee("E", 20);

        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        employeeList.add(e5);
        employeeList.add(e6);

        return employeeList;
    }
}

class Employee{
    String grade;
    int salary;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employee(String grade, int salary) {
        this.grade = grade;
        this.salary = salary;
    }
}
