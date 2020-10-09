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
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "orcamento")
public class Estimate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orcamento", updatable = false, nullable = false)
    private long id;

    @OneToOne
    @JoinColumn(name = "id_funcionario")
    private Employee employee;

    @NotNull
    @Column(name = "dttm_orcamento")
    private LocalDateTime dttmOrcamento;

}

