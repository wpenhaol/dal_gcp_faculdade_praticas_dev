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
@Table(name = "venda")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venda", updatable = false, nullable = false)
    private long id;

    @Column(name = "nm_nota_fical")
    private String noteFiscal;

    @OneToOne
    @JoinColumn(name = "id_orcamento")
    private Estimate estimateId;

    @OneToOne
    @JoinColumn(name = "id_forma_pagamento")
    private PaymentType paymentTypeId;

    @NotNull
    @Column(name = "num_valor_total")
    private double valueTotalOrder;

    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Client clientId;

}

        