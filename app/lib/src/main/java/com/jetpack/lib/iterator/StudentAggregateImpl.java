package com.jetpack.lib.iterator;

import java.util.ArrayList;
import java.util.List;

public class StudentAggregateImpl implements StudentAggregate {
    List<Student> list = new ArrayList<>();

    @Override
    public void add(Student student) {
        list.add(student);
    }

    @Override
    public void remove(Student student) {
        list.remove(student);
    }

    @Override
    public StudentIterator getStudentIterator() {
        System.out.println("list size"+list.size());
        StudentIterator iterator=new StudentIteratorImpl(list);
        return iterator;
    }

}
