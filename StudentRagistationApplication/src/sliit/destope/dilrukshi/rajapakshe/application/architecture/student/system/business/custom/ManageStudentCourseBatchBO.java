package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.custom;

import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.SuperBO;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.choose_courseDTO;

import java.util.List;

public interface ManageStudentCourseBatchBO extends SuperBO {
    List<sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.choose_courseDTO> getRegistationCourse() throws Exception;

    boolean createRegistationCourse(sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.choose_courseDTO dto) throws Exception;

    boolean updateRegistationCourse(sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.choose_courseDTO dto) throws Exception;

    boolean deleteRegistationCourse(String studentID,String CourseID) throws Exception;

    choose_courseDTO findRegistationCourse(String id) throws Exception;

}
