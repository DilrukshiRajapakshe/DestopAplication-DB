package sliit.destope.dilrukshi.rajapakshe.business.custom.Impl;

import ijse.dep.dilrukshi.rajapakshe.business.Converter;
import sliit.destope.dilrukshi.rajapakshe.business.custom.ManageStockItemBO;
import ijse.dep.dilrukshi.rajapakshe.dao.DAOFactory;
import sliit.destope.dilrukshi.rajapakshe.dao.custom.StockItemDAO;
import ijse.dep.dilrukshi.rajapakshe.dto.stockItemDTO;
import ijse.dep.dilrukshi.rajapakshe.entity.payment;
import ijse.dep.dilrukshi.rajapakshe.entity.stock_item;

import java.util.List;

public class ManageStockItemBOImpl implements ManageStockItemBO {

    private StockItemDAO stockItemDAO;

    public ManageStockItemBOImpl() {
        stockItemDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STOCK_ITEM);

    }

    @Override
    public List<stockItemDTO> getStockItem() throws Exception {
        return stockItemDAO.findAll().map(Converter::<stockItemDTO>getDTOList).get();
    }

    @Override
    public boolean createStockItem(stockItemDTO dto) throws Exception {
        return stockItemDAO.save(Converter.getEntity(dto));
    }

    @Override
    public boolean updateStockItem(stockItemDTO dto) throws Exception {
        return stockItemDAO.update(Converter.getEntity(dto));
    }

    @Override
    public boolean deleteStockItem(String Iid) throws Exception {
        return stockItemDAO.delete(Iid);
    }

    @Override
    public stockItemDTO findStockItem(String Iid) throws Exception {
        return stockItemDAO.find(Iid).map(Converter::<stockItemDTO>getDTO).orElse(null);
    }

    @Override
    public String generateStockId() throws Exception {
        String id= stockItemDAO.findLastRowData();
        String a = "Stock0";
        String ItemID;
        if(id==null){
            ItemID = a + "1";
        }else{
            String[] parts = id.split("0");
            int b = Integer.parseInt(parts[1]);
            ItemID = a +( b + 1);
        }
        return  ItemID;
    }
}
