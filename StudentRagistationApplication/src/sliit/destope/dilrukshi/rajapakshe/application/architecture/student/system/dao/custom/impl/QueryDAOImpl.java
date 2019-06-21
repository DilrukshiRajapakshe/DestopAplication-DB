package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.custom.impl;

import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.custom.QueryDAO;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.CustomEntity;

import java.util.List;
import java.util.Optional;

public class QueryDAOImpl  implements QueryDAO {

    @Override
    public Optional<List<CustomEntity>> findBatchDetails(String Cid) throws Exception {
        return Optional.empty();
    }
}
