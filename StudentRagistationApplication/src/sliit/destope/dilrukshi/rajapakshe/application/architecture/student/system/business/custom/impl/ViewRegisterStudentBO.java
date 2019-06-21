package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.custom.impl;

import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.custom.ManageStudentBO;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.studentDTO;

import java.util.List;

public class ViewRegisterStudentBO implements ManageStudentBO {

    @Override
    public List<sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.studentDTO> getStudent() throws Exception {
        return null;
    }

    @Override
    public boolean createStudent(sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.studentDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean updateStudent(sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.studentDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean deleteStudent(String studentID) throws Exception {
        return false;
    }

    @Override
    public studentDTO findStudent(String id) throws Exception {
        return null;
    }
}
