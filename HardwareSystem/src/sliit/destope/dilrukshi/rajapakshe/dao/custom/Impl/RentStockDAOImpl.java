package sliit.destope.dilrukshi.rajapakshe.dao.custom.Impl;

import ijse.dep.dilrukshi.rajapakshe.dao.CrudUtil;
import ijse.dep.dilrukshi.rajapakshe.dao.custom.RentStockDAO;
import sliit.destope.dilrukshi.rajapakshe.entity.rent_stock;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RentStockDAOImpl implements RentStockDAO {
    @Override
    public Optional<rent_stock> find(String Iid) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM rent_stock WHERE Iid=?", Iid);
        rent_stock p = null;
        if (rst.next()) {
            p = new rent_stock(
                    rst.getString("Iid"),
                    rst.getString("Iname"),
                    rst.getString("Sid"),
                    rst.getDouble("buyPrice"),
                    rst.getDouble("discount"),
                    rst.getInt("amount"),
                    rst.getString("brand"),
                    rst.getDouble("rentPrice")
            );
        }
        return Optional.ofNullable(p);
    }

    @Override
    public Optional<List<rent_stock>> findAll() throws Exception {
        ArrayList<rent_stock> al_RentItem = new ArrayList<>();
        ResultSet rst = CrudUtil.<ResultSet>execute("SELECT * FROM rent_stock");
        while (rst.next()) {
            rent_stock p = new rent_stock(
                    rst.getString("Iid"),
                    rst.getString("Iname"),
                    rst.getString("Sid"),
                    rst.getDouble("buyPrice"),
                    rst.getDouble("discount"),
                    rst.getInt("amount"),
                    rst.getString("brand"),
                    rst.getDouble("rentPrice")
            );
            al_RentItem.add(p);
        }
        return Optional.ofNullable(al_RentItem);
    }

    @Override
    public boolean save(rent_stock p) throws Exception {
        return CrudUtil.<Integer>execute("INSERT INTO rent_stock VALUES (?,?,?,?,?,?,?,?)",
                p.getIid(), p.getIname(),p.getSid(),p.getBuyPrice(),p.getDiscount(), p.getAmount(),p.getBrand() ,p.getRentPrice()) > 0;
    }

    @Override
    public boolean update(rent_stock p) throws Exception {
        return CrudUtil.<Integer>execute("UPDATE rent_stock SET Iname=?, Sid=?, buyPrice=?, discount=?, amount=? brand=? rentPrice=? WHERE Iid=?"
                ,  p.getIname(),p.getSid(),p.getBuyPrice(),p.getDiscount(), p.getAmount(),p.getBrand() ,p.getRentPrice(),p.getIid()) > 0;
    }

    @Override
    public boolean delete(String Iid) throws Exception {
        return CrudUtil.<Integer>execute("DELETE FROM rent_stock WHERE Iid=?", Iid) > 0;
    }


    @Override
    public String findLastRowData() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM rent_stock ORDER BY Iid DESC  LIMIT 1");
        rent_stock p = null;
        if (rst.next()) {
            return  rst.getString("Iid");
        }
        return null;
    }
}
