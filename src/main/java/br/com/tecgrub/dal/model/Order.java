package br.com.tecgrub.dal.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "pedido")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido", updatable = false, nullable = false)
    private long id;

    @OneToOne
    @JoinColumn(name = "id_orcamento")
    private Estimate estimate;

    @OneToOne
    @JoinColumn(name = "id_carro")
    private Car car;

    @NotNull
    @Column(name = "num_qtd_carro")
    private int amountCars;

    @NotNull
    @Column(name = "num_valor_total")
    private double valueTotalOrder;
}

        