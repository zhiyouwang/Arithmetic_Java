package com.JnuWangPractice;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 比较器的作用：在实际应用场景中，自定义比较器能够很好的实现工业上业务逻辑的实现。在JDK中，像Array.sort（）底层非常复杂。
 * 但全部都是稳定的排序。
 * 在数据量大的时候，如果是基本数据类型，就会使用快排，如果存储的是对象，会使用归并排序。
 * 在数据量不大的情况下，存储的是对象的话，就会使用插入排序，虽然插入排序的时间复杂度很高，但是在数据量不大的情况下，常
 * 数项很小。
 */
public class Comparer {

    public static class Student {
        public String name;
        public int id;
        public int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    /**
     * id升序
     */
    public static class IdAscendingComparator implements Comparator<Student> {

        // 值小于0就是o1在前面
        @Override
        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;
        }
    }

    /**
     * id降序
     */
    public static class IdDescendingComparator implements Comparator<Student> {
        // 大于0就是o2在前面
        @Override
        public int compare(Student o1, Student o2) {
            return o2.id - o1.id;
        }
    }

    public static class AgeAscendingComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;
        }
    }

    public static class AgeDescendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.age - o1.age;
        }
    }

    public static void printStudents(Student[] students) {
        for (Student student: students
             ) {
            System.out.println("Name : " + student.name + ", Id : " + student.id + ", Age : " + student.age);
        }
        System.out.println("======================================");
    }

    public static void main(String[] args) {
        Student student1 = new Student("A", 1, 23);
        Student student2 = new Student("b", 5, 24);
        Student student3 = new Student("A", 2, 18);

        Student[] students = new Student[] {student3, student2, student1};
        printStudents(students);

        Arrays.sort(students, new IdDescendingComparator());
        printStudents(students);

        Arrays.sort(students, new AgeAscendingComparator());
        printStudents(students);

        Arrays.sort(students, new AgeDescendingComparator());
        printStudents(students);
    }
}
