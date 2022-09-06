package com.example.module3_exam.dao;

import com.example.module3_exam.config.ConnectionDB;

import java.sql.Connection;
import java.util.List;

public class StudentDAO implements IDAO {
    Connection connection = ConnectionDB.getConnect();



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
