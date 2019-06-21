package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao;//package lk.ijse.dep.app.dao;

import ijse.dep.dilrukshi.rajapakshe.application.architecture.student.system.dao.custom.impl.*;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.custom.impl.StudentDAOImpl;

public class DAOFactory {

    private static DAOFactory daoFactory;
    public enum DAOTypes{
        STUDENT,STORE_COURSE,STORE_BATCH, PARENT, QUALIFICATION,STU_COURSE_INFO,STU_BATCH_INFO,MANAGE_STUDENT,MANAGE_PARENT,
        MANAGE_QUALIFICATION,MANAGE_STU_COURSE_INFO,VIEW_REGISTER_STUDENT,QUERYDAO;
    }

    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public <T extends SuperDAO> T getDAO(DAOTypes daoType) {
        switch (daoType) {
            case STUDENT:
                return (T) new StudentDAOImpl();
            case STORE_COURSE:
                return (T) new sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.custom.impl.CourseDAOImpl();
            case STORE_BATCH:
                return (T) new sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.custom.impl.BatchDAOImpl();
            case PARENT:
                return (T) new sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.custom.impl.ParentDetailDAOImpl();
            case QUALIFICATION:
                return (T) new sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.custom.impl.QualificationDAOImpl();
            case STU_COURSE_INFO:
                return (T) new sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.custom.impl.StudentCourseDAOImpl();
            case STU_BATCH_INFO:
                return (T) new sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.custom.impl.QueryDAOImpl();
            case VIEW_REGISTER_STUDENT:
                return (T) new sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.custom.impl.ViewRegisterStudentDAOImpl();
            case QUERYDAO :
                return (T) new sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.custom.impl.QueryDAOImpl();
            default:
                return null;
        }
    }


}
