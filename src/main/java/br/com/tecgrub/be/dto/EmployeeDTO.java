package br.com.tecgrub.be.dto;

import br.com.tecgrub.dal.model.Person;
import lombok.Data;

@Data
public class EmployeeDTO {

    private long id;
    private Person person;
    private int yearsExperiences;
}
