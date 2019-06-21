package sliit.destope.dilrukshi.rajapakshe.business.custom.Impl;

import ijse.dep.dilrukshi.rajapakshe.business.Converter;
import sliit.destope.dilrukshi.rajapakshe.business.custom.ManageDamageItemBO;
import ijse.dep.dilrukshi.rajapakshe.dao.DAOFactory;
import ijse.dep.dilrukshi.rajapakshe.dao.custom.DamageDAO;
import ijse.dep.dilrukshi.rajapakshe.dto.damageStockDTO;

import java.util.List;

public class ManageDamageItemBOImpl implements ManageDamageItemBO {

    private DamageDAO  damageDAO;

    public ManageDamageItemBOImpl() {
        damageDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.DAMAGE);
    }

    @Override
    public List<damageStockDTO> getDamageItem() throws Exception {
        return damageDAO.findAll().map(Converter::<damageStockDTO>getDTOList).get();
    }

    @Override
    public boolean createDamageItem(damageStockDTO dto) throws Exception {
        return damageDAO.save(Converter.getEntity(dto));
    }

    @Override
    public boolean updateDamageItem(damageStockDTO dto) throws Exception {
        return damageDAO.update(Converter.getEntity(dto));
    }

    @Override
    public boolean deleteDamageItem(String Iid) throws Exception {
        return damageDAO.delete(Iid);
    }

    @Override
    public damageStockDTO findDamageItem(String Iid) throws Exception {
        return damageDAO.find(Iid).map(Converter::<damageStockDTO>getDTO).orElse(null);
    }
}
