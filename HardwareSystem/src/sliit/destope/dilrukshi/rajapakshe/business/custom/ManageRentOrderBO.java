package sliit.destope.dilrukshi.rajapakshe.business.custom;

import sliit.destope.dilrukshi.rajapakshe.business.SuperBO;
import ijse.dep.dilrukshi.rajapakshe.dto.paymentDTO;
import ijse.dep.dilrukshi.rajapakshe.dto.paymentRentDTO;
import ijse.dep.dilrukshi.rajapakshe.dto.rentPaymentDTO;

import java.util.List;

public interface ManageRentOrderBO extends SuperBO {

    List<rentPaymentDTO> getOrders() throws Exception;

    void createOrder(rentPaymentDTO dto) throws Exception;

    rentPaymentDTO findOrder(String billID) throws Exception;


}
