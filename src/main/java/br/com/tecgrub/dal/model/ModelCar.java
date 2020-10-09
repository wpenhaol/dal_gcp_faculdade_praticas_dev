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
@Table(name = "modelo_carro")
public class ModelCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_modelo_carro", updatable = false, nullable = false)
    private long id;

    @NotNull
    @Column(name = "nm_modelo_carro")
    private String nameModel;

    @NotNull
    @Column(name = "id_marca_carro")
    private long brandId;

    @NotNull
    @Column(name = "num_ano_fabricacao")
    private long yearFactory;

    @NotNull
    @Column(name = "nm_cor")
    private String color;

}
