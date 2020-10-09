package br.com.tecgrub.dal.service;

import br.com.tecgrub.be.dto.CarDTO;
import br.com.tecgrub.dal.factory.CarFactory;
import br.com.tecgrub.dal.model.PriceCar;
import br.com.tecgrub.dal.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;

    public Optional<PriceCar> findPriceByIdCar(Long id) {
        return priceRepository.findByCarId(id);
    }

    public PriceCar createdNewPrice(CarDTO carDTO){
        return priceRepository.save(CarFactory.getNewPriceByDTO(carDTO));
    }

    public PriceCar alterPrice(CarDTO carDTO){ return priceRepository.save(CarFactory.getNewPriceByDTO(carDTO));
    }

}
