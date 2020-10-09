package br.com.tecgrub.dal.repository;

import br.com.tecgrub.dal.model.PriceCar;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface PriceRepository extends PagingAndSortingRepository<PriceCar, Long> {

    Optional<PriceCar> findByCarId(long id);
}