package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.custom.impl;

import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.Converter;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.custom.ManageQualificationBO;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.DAOFactory;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.custom.QualificationDAO;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.qulificationDTO;

import java.util.List;

public class ManageQualificationBOImpl implements ManageQualificationBO {
    private QualificationDAO qualificationDAO;
    public ManageQualificationBOImpl(){
        qualificationDAO= DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUALIFICATION);
    }
    @Override
    public List<qulificationDTO> getBatch() throws Exception {
        return qualificationDAO.findAll().map(Converter::<qulificationDTO>getDTOList).get();
    }

    @Override
    public boolean createQualification(qulificationDTO dto) throws Exception {
        return qualificationDAO.save(Converter.getEntity(dto));
    }

    @Override
    public boolean updateQualification(qulificationDTO dto) throws Exception {
        return qualificationDAO.update(Converter.getEntity(dto));
    }

    @Override
    public boolean deleteQualification(String studentID) throws Exception {
        return qualificationDAO.delete(studentID);
    }

    @Override
    public qulificationDTO findCourse(String id) throws Exception {
        return qualificationDAO.find(id).map(Converter::<qulificationDTO>getDTO).orElse(null);
    }
}
