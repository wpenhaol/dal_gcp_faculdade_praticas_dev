package br.com.tecgrub.dal.service;

import br.com.tecgrub.be.dto.PersonDTO;
import br.com.tecgrub.dal.factory.PersonFactory;
import br.com.tecgrub.dal.model.Client;
import br.com.tecgrub.dal.model.Person;
import br.com.tecgrub.dal.repository.ClientRepository;
import br.com.tecgrub.dal.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PersonRepository personRepository;

    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    public Client createdNewClient(PersonDTO personDTO){

        return clientRepository.save(
                PersonFactory.generatedClientByPerson(
                        personRepository.save(PersonFactory.generatedPersonByDTO(personDTO))
                )
        );
    }

    public Client alterClient(Person person){
        return clientRepository.findByPerson(personRepository.save(person));
    }

    public void deleteClient(long idClient) {
        Optional<Client> client = clientRepository.findById(idClient);
        clientRepository.deleteById(idClient);
        personRepository.deleteById(client.get().getPerson().getId());
    }
}
