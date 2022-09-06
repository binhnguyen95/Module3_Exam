package com.example.module3_exam.dao;

import com.example.module3_exam.model.Student;

import java.util.List;

public interface IDAO<T> {
    List<T> selectAll();
    List<T> selectByName(String name);
    boolean delete(int id);
    void save(T t);
    boolean update(Student students);
    public Student findByID(int id);
}
