package br.com.tecgrub.dal.repository;

import br.com.tecgrub.dal.model.BrandCar;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BrandCarRepository extends PagingAndSortingRepository<BrandCar, Long> {

}