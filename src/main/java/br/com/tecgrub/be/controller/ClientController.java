package br.com.tecgrub.be.controller;

import br.com.tecgrub.be.dto.PersonDTO;
import br.com.tecgrub.dal.model.Client;
import br.com.tecgrub.dal.model.Person;
import br.com.tecgrub.dal.service.ClientService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("${path.req.client.all}")
@ResponseStatus(HttpStatus.OK)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping()
    public ResponseEntity<Iterable<Client>> findAllClient() {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findAll());
    }

    @GetMapping("${path.req.client.id}")
    public ResponseEntity<Client> findById(@PathVariable("id") long id) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findById(id).orElse(new Client()));
    }

    @PostMapping()
    public ResponseEntity<Client> createClient(@Validated @RequestBody PersonDTO personDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.createdNewClient(personDTO));
    }

    @PutMapping("${path.req.client.id}")
    public ResponseEntity<Client> alterClient(@PathVariable("id") long id, @Validated @RequestBody Person person) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.alterClient(person));
    }

    @DeleteMapping("${path.req.client.id}")
    public ResponseEntity<HttpStatus> deleteClient(@PathVariable("id") long id) {
        clientService.deleteClient(id);
        return ResponseEntity.status(HttpStatus.OK).body(HttpStatus.OK);
    }

}
