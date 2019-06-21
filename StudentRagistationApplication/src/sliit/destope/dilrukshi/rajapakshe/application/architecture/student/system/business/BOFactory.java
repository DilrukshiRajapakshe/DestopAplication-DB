package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business;

import ijse.dep.dilrukshi.rajapakshe.application.architecture.student.system.business.custom.impl.*;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.custom.impl.ManageParentBOImpl;

public class BOFactory {

    public enum BOTypes{
        MANAGE_BATCH,MANAGE_COURSE,MANAGE_PARENT,MANAGE_QUALIFICATION,MANAGE_STUDENT,MANAGE_STUDENT_BATCH_COURSE,MANAGE_VIEW_REGISTER_STUDENT;
    }

    private static BOFactory boFactory;

    private BOFactory(){

    }

    public static BOFactory getInstance(){
        if (boFactory == null){
            boFactory = new BOFactory();
        }
        return boFactory;
    }

        public <T extends SuperBO> T getBO(BOTypes boType){
            switch (boType){
                case MANAGE_BATCH:
                    return (T) new sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.custom.impl.ManageBatchBOImpl();
                case MANAGE_COURSE:
                    return (T) new sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.custom.impl.ManageCourseBOImpl();
                case MANAGE_PARENT:
                    return (T) new ManageParentBOImpl();
                case MANAGE_QUALIFICATION:
                    return (T) new sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.custom.impl.ManageQualificationBOImpl();
                case MANAGE_STUDENT:
                    return (T) new sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.custom.impl.ManageStudentBOImpl();
                case MANAGE_STUDENT_BATCH_COURSE:
                    return (T) new sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.custom.impl.ManageStudentCourseBatchBOImpl();
                case MANAGE_VIEW_REGISTER_STUDENT:
                    return (T) new sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.custom.impl.ViewRegisterStudentBO();
                default:
                    return null;
            }
        }
}
