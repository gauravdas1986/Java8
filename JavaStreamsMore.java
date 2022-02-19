package com.example.test.java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamsMore {
    public static void main(String[] args){

        List<Employee> list= new ArrayList<>();
        list.add(new Employee(1, "vijay",100));
        list.add(new Employee(1, "ajay",0));
        list.add(new Employee(2, "ramu",34));
        list.add(new Employee(2, "lakki",54));
        list.add(new Employee(3, "vijay",3));
        list.add(new Employee(4, "balu",9));

        //map

        OptionalDouble avg=list.stream().mapToDouble(emp->emp.getSalary()).average();
        double sum=list.stream().mapToDouble(emp->emp.getSalary()).sum();
        System.out.println(avg.getAsDouble());
        System.out.println(sum);

        List<String > ls=list.stream().map(employee -> employee.getName().toUpperCase()).collect(Collectors.toList());

        //to find last last or first employee based on employee id
        OptionalInt lastemp=list.stream().mapToInt(empl->empl.getId()).max();
        OptionalInt firstemp=list.stream().mapToInt(empl->empl.getId()).min();
        System.out.println(lastemp.getAsInt());





    }


}
