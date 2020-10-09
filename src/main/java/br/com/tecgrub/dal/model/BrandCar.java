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
@Table(name = "marca_carro")
public class BrandCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marca_carro", updatable = false, nullable = false)
    private long id;

    @NotNull
    @Column(name = "nm_marca")
    private String nameBrand;

    @Column(name = "nm_cnpj")
    private String cnpj;

    @Column(name = "nm_endereco")
    private String endereco;

    @Column(name = "num_telefone")
    private String telefone;

}
