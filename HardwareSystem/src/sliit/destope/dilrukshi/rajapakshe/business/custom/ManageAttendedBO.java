package sliit.destope.dilrukshi.rajapakshe.business.custom;

import sliit.destope.dilrukshi.rajapakshe.business.SuperBO;
import ijse.dep.dilrukshi.rajapakshe.dto.attendedDTO;
import sliit.destope.dilrukshi.rajapakshe.entity.attendedFK;

import java.util.List;

public interface ManageAttendedBO extends SuperBO {

    List<attendedDTO> getEmployeeAttendees() throws Exception;

    boolean createAttendees(attendedDTO dto) throws Exception;

    boolean updateEmployeeAttendees(attendedDTO dto) throws Exception;

    boolean deleteEmployeeAttendees(attendedFK fk) throws Exception;

    attendedDTO findEmployeeAttendees(attendedFK fk) throws Exception;

    List<attendedDTO> SearchEmployeeAttendees(String eid) throws Exception;

}
