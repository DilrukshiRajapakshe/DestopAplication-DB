package sliit.destope.dilrukshi.rajapakshe.business.custom.Impl;

import ijse.dep.dilrukshi.rajapakshe.business.Converter;
import sliit.destope.dilrukshi.rajapakshe.business.custom.ManageSupplerBO;
import ijse.dep.dilrukshi.rajapakshe.dao.DAOFactory;
import ijse.dep.dilrukshi.rajapakshe.dao.custom.SupplerDAO;
import sliit.destope.dilrukshi.rajapakshe.dto.supplerDTO;

import java.util.List;

public class ManageSupplerBOImpl implements ManageSupplerBO {

    private SupplerDAO supplerDAO;

    public ManageSupplerBOImpl() {
        supplerDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SUPPLER);
    }

    @Override
    public List<supplerDTO> getSuppler() throws Exception {
        return supplerDAO.findAll().map(Converter::<supplerDTO>getDTOList).get();
    }

    @Override
    public boolean createSuppler(supplerDTO dto) throws Exception {
        return supplerDAO.save(Converter.getEntity(dto));
    }

    @Override
    public boolean updateSuppler(supplerDTO dto) throws Exception {
        return supplerDAO.update(Converter.getEntity(dto));
    }

    @Override
    public boolean deleteSuppler(String Sid) throws Exception {
        return supplerDAO.delete(Sid);
    }

    @Override
    public supplerDTO findSuppler(String Sid) throws Exception {
        return supplerDAO.find(Sid).map(Converter::<supplerDTO>getDTO).orElse(null);
    }
}
