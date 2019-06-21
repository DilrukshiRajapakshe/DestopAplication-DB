package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.custom.impl;

import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.custom.StudentDAO;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.student;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.CrudUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public Optional<student> find(String Sid) throws Exception {
        ResultSet rst = sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.CrudUtil.execute("SELECT * FROM student WHERE Sid=?", Sid);
        student s = null;
        if (rst.next()) {
            s = new student(
                    rst.getString("Sid"),
                    rst.getString("SinName"),
                    rst.getString("SfuName"),
                    rst.getString("Sadd"),
                    rst.getString("Scity"),
                    rst.getString("Htel"),
                    rst.getString("Mtel"),
                    rst.getString("email"),
                    rst.getString("DofB"),
                    rst.getString("gender")
            );
        }
        return Optional.ofNullable(s);
    }

    @Override
    public Optional<List<student>> findAll() throws Exception {
        ArrayList<student> alstudent = new ArrayList<>();
        ResultSet rst = sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.CrudUtil.<ResultSet>execute("SELECT * FROM student");
        while (rst.next()) {
            String Sid = rst.getString(1);
            student s = new student(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),
                    rst.getString(5),rst.getString(6),rst.getString(7),rst.getString(8),rst.getString(9),rst.getString(10));
            alstudent.add(s);
        }
        return Optional.ofNullable(alstudent);
    }

    @Override
    public boolean save(student s) throws Exception {
        return sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.CrudUtil.<Integer>execute("INSERT INTO student VALUES (?,?,?,?,?,?,?,?,?,?)",
                s.getSid(), s.getSinName(), s.getSfuName(),s.getSadd(),s.getScity(), s.getHtel(), s.getMtel(),s.getEmail(), s.getDofB(),s.getGender()) > 0;
    }

    @Override
    public boolean update(student s) throws Exception {
        return sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.CrudUtil.<Integer>execute("UPDATE parent SET SinName=?,SfuName=?,Sadd=? Scity=?,Htel=?,Mtel=? email=?,DofB=? gender=? WHERE Sid=?",
                s.getSinName(), s.getSfuName(),s.getSadd(),s.getScity(), s.getHtel(), s.getMtel(),s.getEmail(), s.getDofB(),s.getGender(),s.getSid()) > 0;
    }

    @Override
    public boolean delete(String Sid) throws Exception {
        return CrudUtil.<Integer>execute("DELETE FROM parent WHERE Sid=?", Sid) > 0;
    }
}
