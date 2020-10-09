package br.com.tecgrub.dal.service;

import br.com.tecgrub.be.dto.EmployeeDTO;
import br.com.tecgrub.be.dto.PersonDTO;
import br.com.tecgrub.dal.factory.PersonFactory;
import br.com.tecgrub.dal.model.Client;
import br.com.tecgrub.dal.model.Employee;
import br.com.tecgrub.dal.repository.EmployeeRepository;
import br.com.tecgrub.dal.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PersonRepository personRepository;

    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee createdNewEmployee(PersonDTO personDTO){

        return employeeRepository.save(
                PersonFactory.generatedEmployeeByPerson(
                        personRepository.save(PersonFactory.generatedPersonByDTO(personDTO)),
                        personDTO
                )
        );
    }

    public Employee alterEmployee(EmployeeDTO employee){

        personRepository.save(employee.getPerson());
        return employeeRepository.save(PersonFactory.getEmployeeByDTO(employee));
    }

    public void deleteClient(long idClient) {
        Optional<Employee> client = employeeRepository.findById(idClient);
        clientRepository.deleteById(idClient);
        personRepository.deleteById(client.get().getPerson().getId());
    }

}
