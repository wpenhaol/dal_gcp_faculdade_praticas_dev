package br.com.tecgrub.be.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PersonDTO {

    private long idPerson;

    @NotNull
    private String namePerson;

    @NotNull
    private String numRGPerson;

    private String numPhonePerson;
    private int yearsExperiences;
}
