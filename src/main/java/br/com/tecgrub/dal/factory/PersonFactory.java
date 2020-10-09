package br.com.tecgrub.dal.factory;

import br.com.tecgrub.be.dto.EmployeeDTO;
import br.com.tecgrub.be.dto.PersonDTO;
import br.com.tecgrub.dal.model.Client;
import br.com.tecgrub.dal.model.Employee;
import br.com.tecgrub.dal.model.Person;

public interface PersonFactory {

    static Client generatedClientByPerson(Person person){
        Client client = new Client();
        client.setPerson(person);
        return client;
    }

    static Employee generatedEmployeeByPerson(Person person, PersonDTO personDTO){
        Employee employee = new Employee();
        employee.setPerson(person);
        employee.setYearsExperiences(personDTO.getYearsExperiences());
        return employee;
    }

    static Person generatedPersonByDTO(PersonDTO personDTO){
        Person person = new Person();
        person.setId(personDTO.getIdPerson());
        person.setNamePerson(personDTO.getNamePerson());
        person.setNumPhonePerson(personDTO.getNumPhonePerson());
        person.setNumRGPerson(personDTO.getNumRGPerson());
        return person;
    }

    static Employee getEmployeeByDTO(EmployeeDTO employeeDTO){
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setPerson(employeeDTO.getPerson());
        employee.setYearsExperiences(employeeDTO.getYearsExperiences());
        return employee;
    }

}
