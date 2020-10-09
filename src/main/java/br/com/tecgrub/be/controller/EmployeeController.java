package br.com.tecgrub.be.controller;

import br.com.tecgrub.be.dto.EmployeeDTO;
import br.com.tecgrub.be.dto.PersonDTO;
import br.com.tecgrub.dal.model.Employee;
import br.com.tecgrub.dal.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("${path.req.employee.all}")
@ResponseStatus(HttpStatus.OK)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping()
    public ResponseEntity<Iterable<Employee>> findAllClient() {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.findAll());
    }

    @PostMapping()
    public ResponseEntity<Employee> createdNewEmployee(@Validated @RequestBody PersonDTO personDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.createdNewEmployee(personDTO));
    }

    @GetMapping("${path.req.employee.id}")
    public ResponseEntity<Employee> findById(@PathVariable("id") long id) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.findById(id).orElse(new Employee()));
    }

    @PutMapping("${path.req.employee.id}")
    public ResponseEntity<Employee> alterEmployee(@Validated @RequestBody EmployeeDTO employee) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.alterEmployee(employee));
    }

    @DeleteMapping("${path.req.client.id}")
    public ResponseEntity<HttpStatus> deleteClient(@PathVariable("id") long id) {
        employeeService.de(id);
        return ResponseEntity.status(HttpStatus.OK).body(HttpStatus.OK);
    }

}
