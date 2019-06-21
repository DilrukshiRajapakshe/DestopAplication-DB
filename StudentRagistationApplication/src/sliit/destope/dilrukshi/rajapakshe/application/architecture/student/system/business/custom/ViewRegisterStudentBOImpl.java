package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.custom;

import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.SuperBO;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.studentDTO;

import java.util.List;

public interface ViewRegisterStudentBOImpl extends SuperBO {

    List<sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.studentDTO> getStudent() throws Exception;

    boolean createStudent(sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.studentDTO dto) throws Exception;

    boolean updateStudent(sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.studentDTO dto) throws Exception;

    boolean deleteStudent(String studentID) throws Exception;

    studentDTO findStudent(String id) throws Exception;
}
