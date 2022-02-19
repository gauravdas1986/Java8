package com.example.test.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreamsSortMultipleFields {
    public static void main(String[] args){

        List<Employee> list= new ArrayList<>();
        list.add(new Employee(1, "vijay",100));
        list.add(new Employee(1, "ajay",0));
        list.add(new Employee(2, "ramu",34));
        list.add(new Employee(2, "lakki",54));
        list.add(new Employee(3, "vijay",3));
        list.add(new Employee(4, "balu",9));

        //descending order
        //using streams and sorted
        //compareTo() is used for only String comparison
        list=list.stream().sorted((emp1,emp2)->emp1.getName().compareTo(emp2.getName())).collect(Collectors.toList());
        list.forEach(System.out::println);
        System.out.println("-----------------------------------------------------");

        //using streams & Comparator.comparing

        list.stream().sorted((emp1,emp2)->emp1.getId()-emp2.getId()).collect(Collectors.toList());


        list=list.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());

        list.forEach(System.out::println);
        System.out.println("-----------------------------------------------------");

        //sorting based on multiple fields
        //using streams & Comparator.comparing
        list=list.stream().sorted(Comparator.comparing(Employee::getName)
                .thenComparing(Employee::getSalary)).collect(Collectors.toList());
        list.forEach(System.out::println);
        System.out.println("----------------------Testing-------------------------------");

        //sorting reverse order
        //using streams & Comparator.comparing
        list=list.stream().sorted(Comparator.comparing(Employee::getName).reversed()).collect(Collectors.toList());

        list.forEach(System.out::println);
        System.out.println("-----------------------------------------------------");
        
       //using sort & Comparator.comparing

        list.sort(Comparator.comparing(Employee::getName));

        list.forEach(System.out::println);
        System.out.println("-------------------Using sort----------------------------------");

    }

}
