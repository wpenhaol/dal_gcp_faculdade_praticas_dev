package br.com.tecgrub.dal.repository;

import br.com.tecgrub.dal.model.PaymentType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PaymentTypeRepository extends PagingAndSortingRepository<PaymentType, Long> {

}