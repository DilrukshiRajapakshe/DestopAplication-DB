package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.custom;

import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.SuperBO;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.parentDTO;

import java.util.List;

public interface ManageParentBO extends SuperBO {

    List<sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.parentDTO> getParent() throws Exception;

    boolean createParent(sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.parentDTO dto) throws Exception;

    boolean updateParent(sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.parentDTO dto) throws Exception;

    boolean deleteParent(String studentID) throws Exception;

    parentDTO findParent(String id) throws Exception;
}
