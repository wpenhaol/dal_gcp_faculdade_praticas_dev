package br.com.tecgrub.dal.service;

import br.com.tecgrub.be.dto.CarDTO;
import br.com.tecgrub.dal.factory.CarFactory;
import br.com.tecgrub.dal.model.BrandCar;
import br.com.tecgrub.dal.repository.BrandCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BrandCarService {

    @Autowired
    private BrandCarRepository brandCarRepository;

    public Iterable<BrandCar> findAllBrand() {
        return brandCarRepository.findAll();
    }

    public Optional<BrandCar> findByIdBrand(Long id) {
        return brandCarRepository.findById(id);
    }

    public BrandCar createdNewBrand(CarDTO carDTO){
        return brandCarRepository.save(CarFactory.getNewBrandByDTO(carDTO));
    }

    public BrandCar alterBrand(CarDTO carDTO){
        return brandCarRepository.save(CarFactory.getNewBrandByDTO(carDTO));
    }

    public void deleteBrand(long id){
        brandCarRepository.deleteById(id);
    }

}
