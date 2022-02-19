package com.example.test.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamsFilter {
    public static void main(String[] args){

        //integers
        List<Integer> list= Arrays.asList(2,6,7,10,20,-90,100);

        //list.stream().forEach(ele-> System.out.println(ele*ele));
        //list=list.stream().map(ele->ele*ele).collect(Collectors.toList());


       list= list.stream().filter((ele)->ele>10).collect(Collectors.toList());
        System.out.println(list);

        System.out.println("--------------------------------------------------------");
        List<Integer> list1= Arrays.asList(2,6,7,10,3,155,-11,20,-90,100);
        list1.stream().filter((ele)->ele%2==0).forEach(evn->System.out.print(evn+" ,"));

        System.out.println();
        System.out.println("--------------------------------------------------------");
        List<Integer> list2= Arrays.asList(2,6,7,10,3,155,-11,20,-90,100);
        list2.stream().mapToInt(num->num*num).forEach(System.out::println);
        System.out.println("--------------------------------------------------------");
        List<Integer> list3= Arrays.asList(2,6,7,10,3,155,-11,20,-90,100);
        list3=list3.stream().map(num->num*num).limit(5).collect(Collectors.toList());
        System.out.println(list3);

        System.out.println("--------------------------------------------------------");
        List<Integer> list4= Arrays.asList(2,6,7,10,3,155,-11,20,-90,100);
        list4=list4.stream().map(num->num*num).filter(num->num<1000).collect(Collectors.toList());
        System.out.println(list4);

        System.out.println("--------------------------------------------------------");
        List<Integer> list5= Arrays.asList(2,6,7,10,3,155,-11,20,-90,100);
        Optional<Integer> no=list5.stream().map(num->num*num).filter(num->num<1000).findFirst();
        System.out.println(no);

     System.out.println("--------------------------------------------------------");
     List<String> list6= Arrays.asList("vinay","vijaykumar","vamshi","akshay","punith","geetha");
     list6=list6.stream().filter(name->name.length()>5).filter(name2->name2.startsWith("v"))
             .collect(Collectors.toList());
     System.out.println(list6);












    }


}
