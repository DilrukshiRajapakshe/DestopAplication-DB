package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.custom.impl;

import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.Converter;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.DAOFactory;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.custom.Re_CourseDAO;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.custom.ManageStudentCourseBatchBO;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.choose_courseDTO;

import java.util.List;

public class ManageStudentCourseBatchBOImpl implements ManageStudentCourseBatchBO {
    private Re_CourseDAO re_CourseDAO;
    public ManageStudentCourseBatchBOImpl(){
        re_CourseDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STU_COURSE_INFO);
    }

    @Override
    public List<sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.choose_courseDTO> getRegistationCourse() throws Exception {
        return re_CourseDAO.findAll().map(Converter::<sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.choose_courseDTO>getDTOList).get();
    }

    @Override
    public boolean createRegistationCourse(sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.choose_courseDTO dto) throws Exception {
        return re_CourseDAO.save(Converter.getEntity(dto));
    }

    @Override
    public boolean updateRegistationCourse(sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.choose_courseDTO dto) throws Exception {
        return re_CourseDAO.update(Converter.getEntity(dto));
    }

    @Override
    public boolean deleteRegistationCourse(String studentID, String CourseID) throws Exception {
        return re_CourseDAO.deleteCourse(studentID,CourseID);
    }

    @Override
    public sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.choose_courseDTO findRegistationCourse(String id) throws Exception {
        return re_CourseDAO.find(id).map(Converter::<choose_courseDTO>getDTO).orElse(null);
    }


}
