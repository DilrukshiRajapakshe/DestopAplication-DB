package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.custom.impl;

import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.custom.QualificationDAO;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.qulification;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.CrudUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QualificationDAOImpl implements QualificationDAO {
    @Override
    public Optional<qulification> find(String Sid) throws Exception {
        ResultSet rst = sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.CrudUtil.execute("SELECT * FROM qulification WHERE Sid=?", Sid);
        qulification q = null;
        if (rst.next()) {
            q = new qulification(
                    rst.getString("Sid"),
                    rst.getString("filed"),
                    rst.getString("year"),
                    rst.getString("result"),
                    rst.getString("institiute"),
                    rst.getString("any")
            );
        }
        return Optional.ofNullable(q);
    }

    @Override
    public Optional<List<qulification>> findAll() throws Exception {
        ArrayList<qulification> alqulification = new ArrayList<>();
        ResultSet rst = sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.CrudUtil.<ResultSet>execute("SELECT * FROM qulification");
        while (rst.next()) {
            qulification q = new qulification(rst.getString(1),rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5));
            alqulification.add(q);
        }
        return Optional.ofNullable(alqulification);
    }

    @Override
    public boolean save(qulification q) throws Exception {
        return sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.CrudUtil.<Integer>execute("INSERT INTO qulification VALUES (?,?,?,?,?,?)",
                q.getSid(), q.getFiled(), q.getYear(),q.getResult(),q.getInstitiute(),q.getAny()) > 0;
    }

    @Override
    public boolean update(qulification q) throws Exception {
        return sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.CrudUtil.<Integer>execute("UPDATE qulification SET filed=? ,year=? ,result=? ,institiute=? any=? WHERE Sid=?",
                q.getFiled(), q.getYear(),q.getResult(),q.getInstitiute(),q.getAny(),q.getSid()) > 0;

    }

    @Override
    public boolean delete(String Sid) throws Exception {
        return CrudUtil.<Integer>execute("DELETE FROM qulification WHERE Sid=?", Sid) > 0;
    }
}
