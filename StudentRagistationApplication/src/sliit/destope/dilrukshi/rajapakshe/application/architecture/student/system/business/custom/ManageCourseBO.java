package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.custom;

import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.SuperBO;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.courseDTO;

import java.util.List;

public interface ManageCourseBO extends SuperBO {
    List<sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.courseDTO> getCourse() throws Exception;

    boolean createCourse(sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.courseDTO dto) throws Exception;

    boolean updateCourse(sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.courseDTO dto) throws Exception;

    boolean deleteCourse(String CourseID) throws Exception;

    courseDTO findCourse(String id) throws Exception;
}
