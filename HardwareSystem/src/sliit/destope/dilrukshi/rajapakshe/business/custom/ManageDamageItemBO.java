package sliit.destope.dilrukshi.rajapakshe.business.custom;

import sliit.destope.dilrukshi.rajapakshe.business.SuperBO;
import ijse.dep.dilrukshi.rajapakshe.dto.damageStockDTO;

import java.util.List;

public interface ManageDamageItemBO extends SuperBO {
    List<damageStockDTO> getDamageItem() throws Exception;

    boolean createDamageItem(damageStockDTO dto) throws Exception;

    boolean updateDamageItem(damageStockDTO dto) throws Exception;

    boolean deleteDamageItem(String Iid) throws Exception;

    damageStockDTO findDamageItem(String Iid) throws Exception;


}
