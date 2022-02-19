package com.example.test.java8;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaStreamsMap {
    public static void main(String[] args){

        Map<Integer,String> map=new LinkedHashMap();
        //insertion order preserved
        map.put(1,"vijay");
        map.put(2,"vamsi");
        map.put(3,"punith");
        map.put(4,"akshay");
        map.put(9,"ravi");
        map.put(6,"geetha");
        // iterating map
        map.forEach((k,v)->System.out.println(k+"  "+v));

        System.out.println("--------------------------------------------------------");
        map.forEach((k,v)->{
            if(k==6){
                System.out.println(v);
            }
        });

        System.out.println("--------------------------------------------------------");

        //sorting map based on value
        map=map.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        map.forEach((k,v)->System.out.print(k+":"+ v+","));
        System.out.println();
        System.out.println("--------------------------------------------------------");
        //sorting map based on key using Comparator.comparing()
        map=map.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        map.forEach((k,v)->System.out.print(k+":"+ v+","));
        System.out.println();
        System.out.println("--------------------------------------------------------");
        //"OR"
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));


        //filter
        map=map.entrySet().stream()
                .filter(entryset ->entryset.getKey()>3)
                .collect(Collectors.toMap(Map.Entry::getKey, entryset -> entryset.getValue()));
        map.forEach((k,v)->System.out.print(k+":"+ v+","));
        System.out.println();
        System.out.println("--------------------Custom Map------------------------------------");



        HashMap<Employee, Integer> map1 = new HashMap<>();
        Employee e1 = new Employee(5, "vijay",100);
        Employee e2 = new Employee(0, "vamsi",200);
        Employee e3 = new Employee(2, "ravi",100000);
        Employee e4 = new Employee(3, "akshay",1);
        Employee e5 = new Employee(4, "vijay",23);
        Employee e6 = new Employee(4, "vijay",0);
       // map1.put(e1, 1);
        map1.put(e2, 2);
        map1.put(e3, 3);
        map1.put(e4, 4);
        map1.put(e6, 7);
       // map1.put(e5, 5);
        // map1.put(e5, 6);

        // map1.put(null, e3);

        //directly we can not sort custom type map
        Comparator<Employee> bySalary = Comparator.comparing(Employee::getSalary);
        map1 = map1.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(bySalary))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(o1,o2)->o1,LinkedHashMap::new));
        map1.forEach((k,v)->System.out.print(k+":"+ v+","));
        System.out.println();
        System.out.println("--------------------------------------------------------");

       map1= map1.entrySet().stream().filter(entry->entry.getKey().getSalary()>100)
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(o1,o2)->o1,LinkedHashMap::new));
        map1.forEach((k,v)->System.out.print(k+":"+ v+","));
        System.out.println();
        System.out.println("--------------------------------------------------------");






    }

}
