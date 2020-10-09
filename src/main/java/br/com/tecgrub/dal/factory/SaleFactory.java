package br.com.tecgrub.dal.factory;

import br.com.tecgrub.be.dto.SaleDTO;
import br.com.tecgrub.dal.model.Client;
import br.com.tecgrub.dal.model.Estimate;
import br.com.tecgrub.dal.model.PaymentType;
import br.com.tecgrub.dal.model.Sale;

public interface SaleFactory {

    static Sale getSale(Estimate estimate, Client client, PaymentType paymentType, SaleDTO saleDTO){
        Sale sale = new Sale();
        sale.setClientId(client);
        sale.setEstimateId(estimate);
        sale.setPaymentTypeId(paymentType);
        sale.setId(saleDTO.getId());
        sale.setNoteFiscal(saleDTO.getNoteFiscal());
        sale.setValueTotalOrder(saleDTO.getValueTotalOrder());
        return sale;
    }

}
