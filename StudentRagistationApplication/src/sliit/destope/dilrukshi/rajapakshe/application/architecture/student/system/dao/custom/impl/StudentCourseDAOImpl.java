package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.custom.impl;

import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.custom.Re_CourseDAO;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.choose_course;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.CrudUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentCourseDAOImpl implements Re_CourseDAO{


    @Override
    public Optional<choose_course> find(String Sid) throws Exception {
        ResultSet rst = sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.CrudUtil.execute("SELECT * FROM choose_course WHERE Sid=?", Sid);
        choose_course c = null;
        if (rst.next()) {
            c = new choose_course(
                    rst.getString("Sid"),
                    rst.getString("Cid"),
                    rst.getString("Bid")
            );
        }
        return Optional.ofNullable(c);
    }

    @Override
    public Optional<List<choose_course>> findAll() throws Exception {
        ArrayList<choose_course> alBatch = new ArrayList<>();
        ResultSet rst = sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.CrudUtil.<ResultSet>execute("SELECT * FROM choose_course");
        while (rst.next()) {
            String sid = rst.getString(1);
            String cid = rst.getString(2);
            String bid = rst.getString(3);

            choose_course c = new choose_course(sid,cid,bid);
            alBatch.add(c);
        }
        return Optional.ofNullable(alBatch);
    }

    @Override
    public boolean save(choose_course c) throws Exception {
        return sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.CrudUtil.<Integer>execute("INSERT INTO choose_course VALUES (?,?,?)",
                c.getSid(),c.getCid(), c.getBid()) > 0;
    }

    @Override
    public boolean update(choose_course c) throws Exception {
        return sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.CrudUtil.<Integer>execute("UPDATE choose_course SET Cid=? ,Bid=? WHERE Sid=?",
                 c.getCid(),c.getBid(),c.getSid()) > 0;
    }

    @Override
    public boolean delete(String Sid) throws Exception {
        return sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.CrudUtil.<Integer>execute("DELETE FROM choose_course WHERE Sid=?", Sid) > 0;
    }

    public boolean deleteCourse(String Sid,String CourseID) throws Exception {
        return CrudUtil.<Integer>execute("DELETE FROM choose_course WHERE Sid=? and Cid =?", Sid,CourseID) > 0;
    }
}
