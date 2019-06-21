package sliit.destope.dilrukshi.rajapakshe.business.custom.Impl;

import ijse.dep.dilrukshi.rajapakshe.business.Converter;
import sliit.destope.dilrukshi.rajapakshe.business.custom.ManageEmployeeBO;
import ijse.dep.dilrukshi.rajapakshe.dao.DAOFactory;
import ijse.dep.dilrukshi.rajapakshe.dao.custom.EmployeeDAO;
import ijse.dep.dilrukshi.rajapakshe.dto.employeeDTO;

import java.util.List;

public class ManageEmployeeBOImpl implements ManageEmployeeBO {

    private EmployeeDAO employeeDAO;

    public ManageEmployeeBOImpl() {
        employeeDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.EMPLOYEE);
    }

    @Override
    public List<employeeDTO> getEmployee() throws Exception {
        return employeeDAO.findAll().map(Converter::<employeeDTO>getDTOList).get();
    }

    @Override
    public boolean createEmployee(employeeDTO dto) throws Exception {
        return employeeDAO.save(Converter.getEntity(dto));
    }

    @Override
    public boolean updateEmployee(employeeDTO dto) throws Exception {
        return employeeDAO.update(Converter.getEntity(dto));
    }

    @Override
    public boolean deleteEmployee(String nic) throws Exception {
        return employeeDAO.delete(nic);
    }

    @Override
    public employeeDTO findEmployee(String nic) throws Exception {
        return employeeDAO.find(nic).map(Converter::<employeeDTO>getDTO).orElse(null);
    }
}
