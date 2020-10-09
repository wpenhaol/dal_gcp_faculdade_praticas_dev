package br.com.tecgrub.dal.repository;

import br.com.tecgrub.dal.model.Estimate;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EstimateRepository extends PagingAndSortingRepository<Estimate, Long> {

}