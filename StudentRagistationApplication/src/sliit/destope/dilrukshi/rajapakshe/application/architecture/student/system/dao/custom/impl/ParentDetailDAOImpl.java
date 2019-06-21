package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.custom.impl;

import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.parent;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.CrudUtil;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.custom.ParentDAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParentDetailDAOImpl implements ParentDAO {
    @Override
    public Optional<parent> find(String Sid) throws Exception {
        ResultSet rst = sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.CrudUtil.execute("SELECT * FROM course WHERE Cid=?", Sid);
        parent p = null;
        if (rst.next()) {
            p = new parent(
                    rst.getString("Sid"),
                    rst.getString("Pname"),
                    rst.getString("Mtel"),
                    rst.getString("Ptel"),
                    rst.getString("Pemail"),
                    rst.getString("Pposition"),
                    rst.getString("PworkPlase"),
                    rst.getString("Paddress")
            );
        }
        return Optional.ofNullable(p);
    }

    @Override
    public Optional<List<parent>> findAll() throws Exception {
        ArrayList<parent> alparent = new ArrayList<>();
        ResultSet rst = sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.CrudUtil.<ResultSet>execute("SELECT * FROM parent");
        while (rst.next()) {
            String Sid = rst.getString(1);
            parent p = new parent(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),
                    rst.getString(5),rst.getString(6),rst.getString(7),rst.getString(8));
            alparent.add(p);
        }
        return Optional.ofNullable(alparent);
    }

    @Override
    public boolean save(parent p) throws Exception {
        return sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.CrudUtil.<Integer>execute("INSERT INTO parent VALUES (?,?,?,?,?,?,?,?)",
                p.getSid(), p.getPname(), p.getMtel(),p.getPtel(),p.getPemail(), p.getPposition(), p.getPworkPlase(),p.getPaddress()) > 0;
    }

    @Override
    public boolean update(parent p) throws Exception {
        return sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.CrudUtil.<Integer>execute("UPDATE parent SET Pname=?,Mtel=?,Ptel=? Pemail=?,Pposition=?,PworkPlase=? Paddress=? WHERE Sid=?",
                p.getPname(), p.getMtel(),p.getPtel(),p.getPemail(), p.getPposition(), p.getPworkPlase(),p.getPaddress(), p.getSid()) > 0;
    }

    @Override
    public boolean delete(String Sid) throws Exception {
        return CrudUtil.<Integer>execute("DELETE FROM parent WHERE Sid=?", Sid) > 0;
    }
}
