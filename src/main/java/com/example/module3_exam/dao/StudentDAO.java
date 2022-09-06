package com.example.module3_exam.dao;

import com.example.module3_exam.config.ConnectionDB;
import com.example.module3_exam.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IDAO {
    Connection connection = ConnectionDB.getConnect();

    private static final String INSERT_STUDENT = "insert into student(name, birthDate, address, phone, email, classroom) values (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_STUDENT = "select * from student";
    private static final String SELECT_STUDENT_BY_ID = "select id,name,birthDate,address,phone,email,classroom from student where id=?";
    private static final String DELETE_STUDENT = "delete from student where id = ?";
    private static final String UPDATE_STUDENT = "update student set name=?,birthDate=?, address=?, phone=?, email=?, classroom=? where id=?;";

    @Override
    public List<Student> selectAll() {
        List<Student> studentList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_STUDENT);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                LocalDate birth = resultSet.getDate("birthDate").toLocalDate();
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String classroom = resultSet.getString("classroom");
                studentList.add(new Student(id, name, birth, address, phone, email, classroom));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public List selectByName(String name) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        boolean rowDeleted;
        try (
                PreparedStatement statement = connection.prepareStatement(DELETE_STUDENT);
        )
        {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDeleted;
    }

    @Override
    public void create(Student students) {
        try (
                PreparedStatement statement = connection.prepareStatement(INSERT_STUDENT)
        )
        {
            statement.setString(1, students.getName());
            statement.setString(2, String.valueOf(students.getBirthDate()));
            statement.setString(3, students.getAddress());
            statement.setString(4, students.getPhone());
            statement.setString(5, students.getEmail());
            statement.setString(6, students.getClassRoom());
            System.out.println(statement);
            statement.executeUpdate();
            System.out.println("INSERT THANH CONG");
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    @Override
    public boolean update(Student students) {
        boolean rowUpdated;
        try (
                PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENT);
        )
        {
            statement.setString(1, students.getName());
            statement.setString(2, String.valueOf(students.getBirthDate()));
            statement.setString(3, students.getAddress());
            statement.setString(4, students.getPhone());
            statement.setString(5, students.getEmail());
            statement.setString(6, students.getClassRoom());
            statement.setInt(7, students.getId());
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("SUA THANH CONG");
        return rowUpdated;
    }

    @Override
    public Student findByID(int id) {

        Student student = null;
        try (
                PreparedStatement statement = connection.prepareStatement(SELECT_STUDENT_BY_ID);)
        {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                LocalDate birth = resultSet.getDate("birthDate").toLocalDate();
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String classroom = resultSet.getString("classroom");
                student =  new Student(id, name, birth, address, phone, email, classroom);
            }
            System.out.println("CHAY THANH CONG");
        } catch (SQLException e) {
            System.err.println(e);
        }
        return student;
    }
}
