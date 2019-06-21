package sliit.destope.dilrukshi.rajapakshe.business.custom;

import sliit.destope.dilrukshi.rajapakshe.business.SuperBO;
import ijse.dep.dilrukshi.rajapakshe.dto.employeeDTO;

import java.util.List;

public interface ManageEmployeeBO extends SuperBO {
    List<employeeDTO> getEmployee() throws Exception;

    boolean createEmployee(employeeDTO dto) throws Exception;

    boolean updateEmployee(employeeDTO dto) throws Exception;

    boolean deleteEmployee(String nic) throws Exception;

    employeeDTO findEmployee(String nic) throws Exception;
}
