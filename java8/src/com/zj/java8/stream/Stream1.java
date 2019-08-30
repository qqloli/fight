package com.zj.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream1 {

    //1 创建Stream:通过stream()方法，取得集合对象的数据集。
    //2 Intermediate:通过一系列中间（Intermediate）方法，对数据集进行过滤、检索等数据集的再次处理。
    //3 Terminal通过最终（terminal）方法完成对数据集中元素的处理。
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student(1L,"zj",18,"man"),
                new Student(2L,"lyy",18,"woman"),
                new Student(3L,"zfr",18,"man")
        );

        //Intermediate
        //筛选
//        students.stream().filter(student -> student.getName().equals(18))
//                .forEach(student -> System.out.println(student.toString()));

         //拼接
//         Stream stream1 =  students.stream();
//         Stream stream2 =  students.stream();
//         Stream.concat(stream1,stream2).forEach(Student ->{
//             System.out.println(Student.toString());
//         });

        //去重
//        students.stream().distinct().forEach(student -> System.out.println(student.toString()));

        //map映射
//        students.stream()
//                .map(student ->{
//                     if (student.getSex().equals("man")){
//                         student.setSex("男");
//                     }else {
//                         student.setSex("女");
//                     }
//                     return student;
//        } )
//                .forEach(s -> System.out.println(s.toString()));



        //Terminal
        //遍历
//        students.stream().forEach(student -> System.out.println(student.toString()));
        //collect

        List<Student> students2 = students.stream()
                .map(student ->{
            if (student.getSex().equals("man")){
                student.setSex("男");
            }else {
                student.setSex("女");
            }
            return student;
        } ).collect(Collectors.toList());

        students2.stream().forEach(System.out::println);


        Optional<Integer> any = Stream.of(1, 2, 3, 4).findAny();
        System.out.println(any.get());
    }
}
