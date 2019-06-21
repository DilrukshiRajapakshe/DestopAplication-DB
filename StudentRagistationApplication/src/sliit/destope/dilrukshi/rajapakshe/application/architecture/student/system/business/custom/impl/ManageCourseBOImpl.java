package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.custom.impl;

import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.Converter;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.DAOFactory;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.custom.CourseDAO;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.custom.ManageCourseBO;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.courseDTO;

import java.util.List;

public class ManageCourseBOImpl implements ManageCourseBO {
    private CourseDAO courseDAO;

    public ManageCourseBOImpl(){
        courseDAO= DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STORE_COURSE);
    }


    @Override
    public List<sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.courseDTO> getCourse() throws Exception {
        return courseDAO.findAll().map(Converter::<sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.courseDTO>getDTOList).get();
    }

    @Override
    public boolean createCourse(sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.courseDTO dto) throws Exception {
        return courseDAO.save(Converter.getEntity(dto));
    }

    @Override
    public boolean updateCourse(sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.courseDTO dto) throws Exception {
        return courseDAO.update(Converter.getEntity(dto));
    }

    @Override
    public boolean deleteCourse(String CourseID) throws Exception {
        return courseDAO.delete(CourseID);
    }

    @Override
    public sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.courseDTO findCourse(String id) throws Exception {
        return courseDAO.find(id).map(Converter::<courseDTO>getDTO).orElse(null);
    }
}
