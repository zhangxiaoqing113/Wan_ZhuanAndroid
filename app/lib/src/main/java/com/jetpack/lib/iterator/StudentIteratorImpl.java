package com.jetpack.lib.iterator;

import java.util.List;

public class StudentIteratorImpl implements StudentIterator {

    List<Student> list;

    public StudentIteratorImpl(List<Student> list) {
        this.list = list;
    }

    int position = 0;

    @Override
    public boolean hasNext() {
        return  position < list.size();
    }

    @Override
    public Student next() {
        Student student = list.get(position);
        position++;
        return student;
    }
}
