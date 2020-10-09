package br.com.tecgrub.be.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EstimateDTO {

    private long idEstimate;
    private long idEmployee;
    private LocalDateTime dttm;
}
