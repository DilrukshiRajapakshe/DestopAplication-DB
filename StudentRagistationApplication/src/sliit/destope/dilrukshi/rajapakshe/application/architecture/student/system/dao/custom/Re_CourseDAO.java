package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.custom;

import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.CrudDAO;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.choose_course;

public interface Re_CourseDAO extends CrudDAO<choose_course, String> {
    boolean deleteCourse(String Sid,String CourseID) throws Exception;
}
