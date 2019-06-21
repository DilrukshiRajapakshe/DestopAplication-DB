package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.custom.impl;

import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.Converter;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.DAOFactory;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.custom.ManageStudentBO;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.custom.StudentDAO;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.studentDTO;

import java.util.List;

public class ManageStudentBOImpl implements ManageStudentBO {
    private StudentDAO studentDAO;
    public ManageStudentBOImpl(){
        studentDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STUDENT);
    }
    @Override
    public List<sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.studentDTO> getStudent() throws Exception {
        return studentDAO.findAll().map(Converter::<sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.studentDTO>getDTOList).get();
    }

    @Override
    public boolean createStudent(sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.studentDTO dto) throws Exception {
        return studentDAO.save(Converter.getEntity(dto));
    }

    @Override
    public boolean updateStudent(sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.studentDTO dto) throws Exception {
        return studentDAO.update(Converter.getEntity(dto));
    }

    @Override
    public boolean deleteStudent(String studentID) throws Exception {
        return studentDAO.delete(studentID);
    }

    @Override
    public sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.studentDTO findStudent(String id) throws Exception {
        return studentDAO.find(id).map(Converter::<studentDTO>getDTO).orElse(null);
    }
}
