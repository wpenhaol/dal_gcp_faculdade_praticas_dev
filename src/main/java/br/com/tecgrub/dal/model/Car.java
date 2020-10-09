package br.com.tecgrub.dal.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "carro")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carro", updatable = false, nullable = false)
    private long id;

    @NotNull
    @Column(name = "num_chassi")
    private String chassi;

    @NotNull
    @Column(name = "nm_placa")
    private String placa;

    @NotNull
    @Column(name = "id_modelo_carro")
    private long modelCarId;

}
