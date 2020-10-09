package br.com.tecgrub.be.dto;

import lombok.Data;

@Data
public class CarDTO {

    private long brandId;
    private String nameBrand;
    private String cnpjBrand;
    private String enderecoBrand;
    private String telefoneBrand;

    private long modelId;
    private String nameModel;
    private long yearFactory;
    private String color;
    private long carId;
    private String nameChassi;
    private String namePlaca;
    private long priceId;
    private double price;
}
