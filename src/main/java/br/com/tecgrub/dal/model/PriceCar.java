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
@Table(name = "preco")
public class PriceCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_preco", updatable = false, nullable = false)
    private long id;

    @NotNull
    @Column(name = "id_carro")
    private long carId;

    @NotNull
    @Column(name = "num_valor_carro")
    private double valueCar;


}
