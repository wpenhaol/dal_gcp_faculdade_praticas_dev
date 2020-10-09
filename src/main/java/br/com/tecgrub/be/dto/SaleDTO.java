package br.com.tecgrub.be.dto;

import lombok.Data;

@Data
public class SaleDTO {

    private long id;
    private String noteFiscal;
    private long estimateId;
    private long paymentTypeId;
    private double valueTotalOrder;
    private long clientId;

}
