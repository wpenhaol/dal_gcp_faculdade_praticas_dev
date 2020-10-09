package br.com.tecgrub.dal.repository;

import br.com.tecgrub.dal.model.Client;
import br.com.tecgrub.dal.model.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClientRepository extends PagingAndSortingRepository<Client, Long> {

    Client findByPerson(Person person);

}