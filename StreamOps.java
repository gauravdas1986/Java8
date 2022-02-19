package com.example.test.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamOps {
public static void main(String[] args) {
	List <Integer> list = Arrays.asList(40, 32, 53, 11, 22, 11, 89, 76);
	int max1 = list.stream().max(Comparator.comparing(Integer::valueOf)).get();
	System.out.println("Max: "+max1);
	
	Optional<Integer> max2 = list.stream().map(val ->val).max(Comparator.comparing(Integer::valueOf));
	OptionalInt max3 = list.stream().mapToInt(val ->val).max();
	
	System.out.println(" max2 "+max2+" max3 "+max3);
	
	List < Person > persons = Arrays.asList(
            new Person("Tom", 3, 500000),
            new Person("Sam", 5, 800000),
            new Person("Andy", 12,200000),
            new Person("Candy", 12,900000),
            new Person("Jazz", 18,5600000),
            new Person("Brett", 18,8900000)
        );
	Person maxPerson = persons.stream().max(Comparator.comparing(Person::getAge)).get();
	
//	Map<Integer,List<Person>> m = persons.stream().collect(Collectors.groupingBy(Person::getAge,Collectors.toList()));
	Map<Integer,List<Person>> groupByAge = persons.stream().collect(Collectors.groupingBy(Person::getAge));
	System.out.println(groupByAge);
	
	Map<Integer,Long> countByAge = persons.stream().collect(Collectors.groupingBy(Person::getAge,Collectors.counting()));
	System.out.println(countByAge);
	
	Map<Integer,Optional<Person>> groupByMaxSalary = persons.stream().collect(Collectors.groupingBy(Person::getAge,
			Collectors.maxBy(Comparator.comparing(Person::getSalary))));
	
	System.out.println(groupByMaxSalary);
	
	Set set = new HashSet();
	list.stream().filter(e -> !set.add(e)).forEach(x -> System.out.println(x));
	
	persons.stream().sorted(Comparator.comparing(Person::getAge)).forEach(e -> System.out.println(e));
	
	Map <String, Integer> cities = new HashMap <> ();
	 
    cities.put("Shanghai", 24256800);
    cities.put("Karachi", 23500000);
    cities.put("Beijing", 21516000);
    cities.put("Delhi", 16349831);
    cities.put("Lagos", 16060303);
    cities.put("Tianjin", 15200000);
	

}
}
