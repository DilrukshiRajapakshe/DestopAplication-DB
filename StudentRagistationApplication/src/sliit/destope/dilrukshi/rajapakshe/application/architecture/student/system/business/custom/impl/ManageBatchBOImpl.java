package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.custom.impl;

import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.Converter;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.custom.ManageBatchBO;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.DAOFactory;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.custom.BatchDAO;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.batchDTO;


import java.util.List;

public class ManageBatchBOImpl implements ManageBatchBO {
    private BatchDAO batchDAO;
    public ManageBatchBOImpl(){
       batchDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STORE_BATCH);
    }
    @Override
    public List<sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.batchDTO> getBatch() throws Exception {
        return batchDAO.findAll().map(Converter::<sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.batchDTO>getDTOList).get();
    }

    @Override
    public boolean createBatch(sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.batchDTO dto) throws Exception {
        return  batchDAO.save(Converter.getEntity(dto));
    }

    @Override
    public boolean updateBatch(sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.batchDTO dto) throws Exception {
        return batchDAO.update(Converter.getEntity(dto));
    }

    @Override
    public boolean deleteBatch(String BatchID) throws Exception {
        return batchDAO.delete(BatchID);
    }

    @Override
    public sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.batchDTO findBatch(String id) throws Exception {
        return batchDAO.find(id).map(Converter::<batchDTO>getDTO).orElse(null);
    }
}
