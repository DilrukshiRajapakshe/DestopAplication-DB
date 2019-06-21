package sliit.destope.dilrukshi.rajapakshe.business.custom;

import sliit.destope.dilrukshi.rajapakshe.business.SuperBO;
import ijse.dep.dilrukshi.rajapakshe.dto.loginDTO;

import ijse.dep.dilrukshi.rajapakshe.entity.loginFK;

public interface ManageLoginBO extends SuperBO {
    boolean createEmployeeLogin(loginDTO dto) throws Exception;

    boolean updateEmployeeLogin(loginDTO dto) throws Exception;

    boolean deleteEmployeeLogin(loginFK fk) throws Exception;

    loginDTO findEmployeeLogin(loginFK fk) throws Exception;

    boolean deleteEmployeeLoginDetail(String nic) throws Exception;

}
