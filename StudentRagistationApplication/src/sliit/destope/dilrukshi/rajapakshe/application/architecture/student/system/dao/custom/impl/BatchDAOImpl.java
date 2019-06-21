package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.custom.impl;

import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.batch;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.CrudUtil;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.custom.BatchDAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BatchDAOImpl implements BatchDAO {
    @Override
    public Optional<batch> find(String BId) throws Exception {
        ResultSet rst = sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.CrudUtil.execute("SELECT * FROM batch WHERE Bid=?", BId);
        batch b = null;
        if (rst.next()) {
            b = new batch(
                    rst.getString("Bid"),
                    rst.getString("Cid"),
                    rst.getString("Sdate"),
                    rst.getString("Bdisc"),
                    rst.getInt("Samount")
            );
        }
        return Optional.ofNullable(b);
    }

    @Override
    public Optional<List<batch>> findAll() throws Exception {
        ArrayList<batch> alBatch = new ArrayList<>();
        ResultSet rst = sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.CrudUtil.<ResultSet>execute("SELECT * FROM batch");
        while (rst.next()) {
            String bid = rst.getString(1);
            String cid = rst.getString(2);
            String startDate = rst.getString(3);
            String dis = rst.getString(4);
            int amount = Integer.parseInt(rst.getString(5));

            batch b = new batch(bid, cid, startDate,dis,amount);
            alBatch.add(b);
        }
        return Optional.ofNullable(alBatch);
    }

    @Override
    public boolean save(batch b) throws Exception {
        return sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.CrudUtil.<Integer>execute("INSERT INTO batch VALUES (?,?,?,?,?)",
                b.getBid(), b.getCid(), b.getSdate(),b.getBdisc(),b.getSamount()) > 0;
    }

    @Override
    public boolean update(batch b) throws Exception {
        return sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.CrudUtil.<Integer>execute("UPDATE batch SET Cid=? ,Sdate=? ,Bdisc=? ,Samount=? WHERE Bid=?",
                 b.getCid(), b.getSdate(),b.getBdisc(),b.getSamount(),b.getBid()) > 0;
    }

    @Override
    public boolean delete(String Bid) throws Exception {
        return CrudUtil.<Integer>execute("DELETE FROM batch WHERE Bid=?", Bid) > 0;
    }
}
