package com.jetpack.lib.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        //---------------------
        ArrayList<Integer> list = new ArrayList<>();
        Iterator<Integer> listIterator = list.iterator();
        while (listIterator.hasNext()) {

        }

        //----------------------------


        StudentAggregateImpl impl = new StudentAggregateImpl();
        impl.add(new Student("zhangsan", 200));
        impl.add(new Student("lisi", 100));
        impl.add(new Student("wangwu", 150));
        impl.add(new Student("zhaoliu", 160));


        StudentIterator iterator = impl.getStudentIterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println(student.toString());
        }


    }
}
