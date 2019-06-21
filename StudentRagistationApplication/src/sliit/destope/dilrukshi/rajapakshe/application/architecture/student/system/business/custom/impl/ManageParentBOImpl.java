package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.custom.impl;

import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.Converter;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.custom.ManageParentBO;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.DAOFactory;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.custom.ParentDAO;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.parentDTO;

import java.util.List;

public class ManageParentBOImpl implements ManageParentBO {
    private ParentDAO manageParentDetailDAO;
    public ManageParentBOImpl(){
        manageParentDetailDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.MANAGE_PARENT);
    }
    @Override
    public List<parentDTO> getParent() throws Exception {
        return manageParentDetailDAO.findAll().map(Converter::<parentDTO>getDTOList).get();
    }

    @Override
    public boolean createParent(parentDTO dto) throws Exception {
        return manageParentDetailDAO.save(Converter.getEntity(dto));
    }

    @Override
    public boolean updateParent(parentDTO dto) throws Exception {
        return manageParentDetailDAO.update(Converter.getEntity(dto));
    }

    @Override
    public boolean deleteParent(String studentID) throws Exception {
        return manageParentDetailDAO.delete(studentID);
    }

    @Override
    public parentDTO findParent(String id) throws Exception {
        return manageParentDetailDAO.find(id).map(Converter::<parentDTO>getDTO).orElse(null);
    }
}
