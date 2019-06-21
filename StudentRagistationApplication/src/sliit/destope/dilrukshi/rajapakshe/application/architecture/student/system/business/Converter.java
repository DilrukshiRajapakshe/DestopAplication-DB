package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business;

import ijse.dep.dilrukshi.rajapakshe.application.architecture.student.system.dto.*;
import ijse.dep.dilrukshi.rajapakshe.application.architecture.student.system.entity.*;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.SuperDTO;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.choose_course;

import java.util.List;
import java.util.stream.Collectors;

public class Converter {
public static <T extends sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.SuperDTO> T getDTO(sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.SuperEntity entity) {
        if (entity instanceof sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.batch) {
            sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.batch b = (sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.batch) entity;
            return (T) new sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.batchDTO(b.getBid(),b.getCid(),b.getSdate(),b.getBdisc(),b.getSamount());
        } else if (entity instanceof sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.choose_course) {
            sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.choose_course c = (sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.choose_course) entity;
            return (T) new sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.choose_courseDTO(c.getSid(),c.getCid(),c.getBid());
        }else if (entity instanceof sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.course) {
            sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.course c = (sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.course) entity;
           return (T) new sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.courseDTO(c.getCid(),c.getCname(),c.getCdis(),c.getCdura());
        }else if (entity instanceof sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.parent) {
            sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.parent p = (sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.parent) entity;
           return (T) new sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.parentDTO(p.getSid(),p.getPname(),p.getMtel(),p.getPtel(),p.getPemail(),p.getPposition(),p.getPworkPlase(),p.getPaddress());
        }else if (entity instanceof sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.qulification) {
           sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.qulification q = (sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.qulification) entity;
          return (T) new sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.qulificationDTO(q.getSid(),q.getFiled(),q.getYear(),q.getResult(),q.getInstitiute(),q.getAny());
        }else if (entity instanceof sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.student) {
           sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.student s = (sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.student) entity;
          return (T) new sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.studentDTO(s.getSid(),s.getSinName(),s.getSfuName(),s.getSadd(),s.getScity(),s.getHtel(),s.getMtel(),s.getEmail(),s.getDofB(),s.getGender());
        }else {
            throw new RuntimeException("This entity can't be converted to a DTO");
        }
    }
//
    public static <T extends sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.SuperEntity> T getEntity(sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.SuperDTO dto) {
        if (dto instanceof sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.batchDTO) {
            sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.batchDTO b = (sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.batchDTO) dto;
            return (T) new sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.batch(b.getBid(),b.getCid(),b.getSdate(),b.getBdisc(),b.getSamount());
        } else if (dto instanceof sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.choose_courseDTO) {
            sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.choose_courseDTO c = (sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.choose_courseDTO) dto;
            return (T) new choose_course(c.getSid(),c.getCid(),c.getBid());
        }else if (dto instanceof sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.courseDTO) {
            sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.courseDTO c = (sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.courseDTO) dto;
           return (T) new sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.course(c.getCid(),c.getCname(),c.getCdis(),c.getCdura());
        }else if (dto instanceof sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.parentDTO) {
            sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.parentDTO p = (sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.parentDTO) dto;
           return (T) new sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.parent(p.getSid(),p.getPname(),p.getMtel(),p.getPtel(),p.getPemail(),p.getPposition(),p.getPworkPlase(),p.getPaddress());
        }else if (dto instanceof sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.qulificationDTO) {
           sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.qulificationDTO q = (sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.qulificationDTO) dto;
          return (T) new sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.qulification(q.getSid(),q.getFiled(),q.getYear(),q.getResult(),q.getInstitiute(),q.getAny());
        }else if (dto instanceof sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.studentDTO) {
           sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.studentDTO s = (sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.studentDTO) dto;
          return (T) new sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.student(s.getSid(),s.getSinName(),s.getSfuName(),s.getSadd(),s.getScity(),s.getHtel(),s.getMtel(),s.getEmail(),s.getDofB(),s.getGender());
        }else {
            throw new RuntimeException("This entity can't be converted to a DTO");
        }
    }

    public static <T extends sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.SuperDTO> List<T> getDTOList(List<? extends sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.SuperEntity> entities) {
        return entities.stream().map(Converter::<T>getDTO).collect(Collectors.toList());
    }

    public static <T extends sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.SuperEntity> List<T> getEntityList(List<? extends sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.SuperDTO> dtos) {
        return dtos.stream().map(Converter::<T>getEntity).collect(Collectors.toList());

    }

    // =========================================================================

    public static <T extends sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.SuperDTO> T getDTO(sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.CustomEntity entity, Class<T> dtoClass) {
        if (dtoClass == sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.batchDTO.class) {
            return (T) new sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.batchDTO(entity.getBid(), entity.getCid(),entity.getSdate(),entity.getBdisc(),entity.getSamount());
        } else if (dtoClass == sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.courseDTO.class) {
            return (T) new sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.courseDTO(entity.getCid(), entity.getCname(), entity.getCdis(), entity.getCdura());
        } else {
            throw new RuntimeException("Not Supported DTO");
        }
    }

    public static <T extends SuperDTO> List<T> getDTOList(List<sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.entity.CustomEntity> list, Class<T> dtoClass) {
        return list.stream().map(c -> getDTO(c, dtoClass)).collect(Collectors.toList());
    }
}
