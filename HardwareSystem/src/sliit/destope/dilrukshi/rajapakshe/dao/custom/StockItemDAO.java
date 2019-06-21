package sliit.destope.dilrukshi.rajapakshe.dao.custom;

import ijse.dep.dilrukshi.rajapakshe.dao.CrudDAO;
import ijse.dep.dilrukshi.rajapakshe.entity.stock_item;

import java.util.Optional;

public interface StockItemDAO extends CrudDAO<stock_item,String> {
    String findLastRowData() throws Exception;
}
