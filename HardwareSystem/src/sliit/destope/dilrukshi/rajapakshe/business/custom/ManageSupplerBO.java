package sliit.destope.dilrukshi.rajapakshe.business.custom;

import sliit.destope.dilrukshi.rajapakshe.business.SuperBO;
import sliit.destope.dilrukshi.rajapakshe.dto.supplerDTO;

import java.util.List;

public interface ManageSupplerBO extends SuperBO {
    List<supplerDTO> getSuppler() throws Exception;

    boolean createSuppler(supplerDTO dto) throws Exception;

    boolean updateSuppler(supplerDTO dto) throws Exception;

    boolean deleteSuppler(String Sid) throws Exception;

    supplerDTO findSuppler(String Sid) throws Exception;
}
