package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.custom;

import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.SuperDAO;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.CustomEntity;

import java.util.List;
import java.util.Optional;

public interface QueryDAO extends SuperDAO {

    Optional<List<CustomEntity>> findBatchDetails(String Cid) throws Exception;
}
