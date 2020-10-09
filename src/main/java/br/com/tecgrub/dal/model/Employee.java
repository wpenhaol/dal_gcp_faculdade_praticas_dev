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

@Entity
@Data
@Table(name = "funcionario")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcionario", updatable = false, nullable = false)
    private long id;

    @OneToOne
    @JoinColumn(name = "id_pessoa")
    private Person person;

    @Column(name = "num_anos_experiencia")
    private int yearsExperiences;

}
