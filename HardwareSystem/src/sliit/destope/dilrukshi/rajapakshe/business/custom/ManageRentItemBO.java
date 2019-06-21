package sliit.destope.dilrukshi.rajapakshe.business.custom;

import sliit.destope.dilrukshi.rajapakshe.business.SuperBO;
import ijse.dep.dilrukshi.rajapakshe.dto.rentStockDTO;

import java.util.List;

public interface ManageRentItemBO extends SuperBO {
    List<rentStockDTO> getRentItem() throws Exception;

    boolean createRentItem(rentStockDTO dto) throws Exception;

    boolean updateRentItem(rentStockDTO dto) throws Exception;

    boolean deleteRentItem(String Iid) throws Exception;

    rentStockDTO findRentItem(String Iid) throws Exception;

    String generateRentStockId() throws Exception;
}
