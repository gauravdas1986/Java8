package com.example.test.java8;

import java.util.*;
import java.util.LinkedList;

public class JavaStreamsMaxMin {
        public static void main(String[] args){
            Employee emp1 = new Employee(1, "vijay",100);
            Employee emp2 = new Employee(1, "ajay",0);
            Employee emp3 = new Employee(2, "ramu",34);
            Employee emp4 = new Employee(2, "lakki",54);
            Employee emp5 = new Employee(3, "vijay",3);
            Employee emp6 = new Employee(4, "balu",9);
            List<Employee> list = new LinkedList<>();
            list.add(emp1);
            list.add(emp2);
            list.add(emp3);
            list.add(emp4);
            list.add(emp5);
            list.add(emp6);


         /* List<Integer> ls= Arrays.asList(2,-1,3,6,9,0);
          int max=ls.stream().max(Comparator.comparing(Integer::valueOf)).get();
            System.out.println(max);
         */


            //Optional<Integer> max= ls.stream().max(Comparator.naturalOrder());
            //Optional<Integer> min= ls.stream().max(Comparator.reverseOrder());
            // System.out.println(min.get());
            //int max=ls.stream().max(Integer::compare).get();

            /*if(max.isPresent()) {
                System.out.println(max.get());
            }*/

            //easiest way

            /*

            int max=ls.stream().mapToInt((ele)->ele).max().orElseThrow(NoSuchElementException::new);
            int min=ls.stream().mapToInt((ele)->ele).min().orElseThrow(NoSuchElementException::new);
            System.out.println(max);
            System.out.println(min);

            */


         // /*  //Strings

            List<String> ls1= Arrays.asList("klmflf","dsfsd","df","sdfcsdfds");
           /* String max=ls1.stream().map((ele)->ele).max(String::compareTo).get();
            String min=ls1.stream().map((ele)->ele).min(String::compareTo).get();
           */
            String max=ls1.stream().max(String::compareTo).get();
            String min=ls1.stream().min(String::compareTo).get();
            System.out.println(min);
            System.out.println(max+"-----"+max.length());
            System.out.println("-----------------------------------------------------");

            //"OR"
            String maxString = Collections.max(ls1, Comparator.comparing(s -> s.length()));

            //using method reference
            String maxString1 = Collections.max(ls1, Comparator.comparing(String::length));
            System.out.println(maxString);
            int maxLen = maxString.length();
            System.out.println(maxLen);
            System.out.println("-----------------------------------------------------");

            //*/

            //easy and better approach
            //for both Custom objects and primitive data types

            Employee salaryEmp= list.stream().max(Comparator.comparing(Employee::getSalary)).get();
            System.out.println(salaryEmp.getSalary());
            System.out.println("-----------------------------------------------------");

            //using sort and findFirst

           // list.stream().
            Employee singleEmp=list.stream().sorted((empl1,empl2)->empl2.getSalary()- empl1.getSalary())
                    .findFirst().get();
            System.out.println(singleEmp);
            System.out.println("-----------------------------------------------------");

            //using max/min and sorting
            Employee singleEmp1=list.stream().min((empl3,empl4)->empl3.getSalary()- empl4.getSalary()).get();
            System.out.println(singleEmp1);
            System.out.println("-------------------last----------------------------------");



        }
    }
