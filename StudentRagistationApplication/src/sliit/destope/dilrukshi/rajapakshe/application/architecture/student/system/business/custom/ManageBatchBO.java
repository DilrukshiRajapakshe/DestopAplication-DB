package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.custom;

import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.SuperBO;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.batchDTO;

import java.util.List;

public interface ManageBatchBO extends SuperBO {

     List<sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.batchDTO> getBatch() throws Exception;

     boolean createBatch(sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.batchDTO dto) throws Exception;

     boolean updateBatch(sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.batchDTO dto) throws Exception;

     boolean deleteBatch(String BatchID) throws Exception;

     batchDTO findBatch(String id) throws Exception;
}
