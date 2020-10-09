package br.com.tecgrub.be.dto;

import lombok.Data;

@Data
public class OrderDTO {

    private long id;
    private long estimateId;
    private long carId;
    private int amountCars;
    private double valueTotalOrder;

}
