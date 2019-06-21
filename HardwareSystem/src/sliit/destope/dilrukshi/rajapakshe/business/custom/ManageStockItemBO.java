package sliit.destope.dilrukshi.rajapakshe.business.custom;

import sliit.destope.dilrukshi.rajapakshe.business.SuperBO;
import ijse.dep.dilrukshi.rajapakshe.dto.stockItemDTO;

import java.util.List;

public interface ManageStockItemBO extends SuperBO {
    List<stockItemDTO> getStockItem() throws Exception;

    boolean createStockItem(stockItemDTO dto) throws Exception;

    boolean updateStockItem(stockItemDTO dto) throws Exception;

    boolean deleteStockItem(String Iid) throws Exception;

    stockItemDTO findStockItem(String Iid) throws Exception;

    String generateStockId() throws Exception;
}
