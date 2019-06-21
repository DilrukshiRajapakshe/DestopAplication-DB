package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.custom.impl;

import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dao.custom.ViewRegisterStudentImpl;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.student;

import java.util.List;
import java.util.Optional;

public class ViewRegisterStudentDAOImpl implements ViewRegisterStudentImpl {
    @Override
    public Optional<sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.student> find(String key) throws Exception {
        return Optional.empty();
    }

    @Override
    public Optional<List<sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.student>> findAll() throws Exception {
        return Optional.empty();
    }

    @Override
    public boolean save(sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.student entity) throws Exception {
        return false;
    }

    @Override
    public boolean update(student entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String key) throws Exception {
        return false;
    }
}
