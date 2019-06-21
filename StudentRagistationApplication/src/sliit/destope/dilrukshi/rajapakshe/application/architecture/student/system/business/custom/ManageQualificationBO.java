package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.custom;

import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.SuperBO;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.qulificationDTO;

import java.util.List;

public interface ManageQualificationBO extends SuperBO {
    List<sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.qulificationDTO> getBatch() throws Exception;

    boolean createQualification(sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.qulificationDTO dto) throws Exception;

    boolean updateQualification(sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.qulificationDTO dto) throws Exception;

    boolean deleteQualification(String studentID) throws Exception;

    qulificationDTO findCourse(String id) throws Exception;
}
