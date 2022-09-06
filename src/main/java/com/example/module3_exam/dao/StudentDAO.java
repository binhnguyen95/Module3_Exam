package com.example.module3_exam.dao;

import com.example.module3_exam.config.ConnectionDB;

import java.sql.Connection;
import java.util.List;

public class StudentDAO implements IDAO {
    Connection connection = ConnectionDB.getConnect();

    private static final String INSERT_STUDENT = "insert into student(name, birthDate, address, phone, email, classroom) values (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_STUDENT = "select * from student";
    private static final String SELECT_STUDENT_BY_ID = "select id,name,birthDate,address,phone,email,classroom from student where id=?";
    private static final String DELETE_STUDENT = "delete from student where id = ?";
    private static final String UPDATE_STUDENT = "update student set name=?,birthDate=?, address=?, phone=?, email=?, classroom=? where id=?;";

    @Override
    public List selectAll() {
        return null;
    }

    @Override
    public List selectByName(String name) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void save(Object o) {

    }

    @Override
    public void update(int id, Object o) {

    }

    @Override
    public Object findByID(int id) {
        return null;
    }
}
