package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.custom.impl;

import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.custom.CourseDAO;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.CrudUtil;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.course;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourseDAOImpl implements CourseDAO {
    @Override
    public Optional<sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.course> find(String Cid) throws Exception {
        ResultSet rst = sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.CrudUtil.execute("SELECT * FROM course WHERE Cid=?", Cid);
        sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.course c = null;
        if (rst.next()) {
            c = new sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.course(
                    rst.getString("Cid"),
                    rst.getString("Cname"),
                    rst.getString("Cdis"),
                    rst.getString("Cdura")
            );
        }
        return Optional.ofNullable(c);
    }

    @Override
    public Optional<List<sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.course>> findAll() throws Exception {
        ArrayList<sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.course> alCourse = new ArrayList<>();
        ResultSet rst = sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.CrudUtil.<ResultSet>execute("SELECT * FROM course");
        while (rst.next()) {
            String cid = rst.getString(1);
            sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.course c = new sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.course(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4));
            alCourse.add(c);
        }
        return Optional.ofNullable(alCourse);
    }

    @Override
    public boolean save(sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.course c) throws Exception {
        return sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.CrudUtil.<Integer>execute("INSERT INTO course VALUES (?,?,?,?)",
                c.getCid(), c.getCname(), c.getCdis(),c.getCdura()) > 0;
    }

    @Override
    public boolean update(course c) throws Exception {
        return sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.CrudUtil.<Integer>execute("UPDATE course SET Cname=?,Cdis=?,Cdura=? WHERE Cid=?",
                 c.getCname(), c.getCdis(),c.getCdura(),c.getCid()) > 0;
    }

    @Override
    public boolean delete(String Cid) throws Exception {
        return CrudUtil.<Integer>execute("DELETE FROM course WHERE Cid=?", Cid) > 0;
    }

//
}
