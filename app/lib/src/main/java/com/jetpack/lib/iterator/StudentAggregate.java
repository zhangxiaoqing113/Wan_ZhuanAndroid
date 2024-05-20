package com.jetpack.lib.iterator;

public interface StudentAggregate {
void add (Student student);
void remove (Student student);
StudentIterator getStudentIterator();

}
