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
@Table(name = "pessoa")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pessoa", updatable = false, nullable = false)
    private long id;

    @NotNull
    @Column(name = "nm_nome")
    private String namePerson;

    @NotNull
    @Column(name = "num_rg")
    private String numRGPerson;

    @Column(name = "num_phone")
    private String numPhonePerson;
}
