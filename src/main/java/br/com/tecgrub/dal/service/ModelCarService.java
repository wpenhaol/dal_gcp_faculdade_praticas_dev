package br.com.tecgrub.dal.service;

import br.com.tecgrub.be.dto.CarDTO;
import br.com.tecgrub.dal.factory.CarFactory;
import br.com.tecgrub.dal.model.ModelCar;
import br.com.tecgrub.dal.repository.ModelCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ModelCarService {

    @Autowired
    private ModelCarRepository modelCarRepository;

    public Iterable<ModelCar> findAllModel() {
        return modelCarRepository.findAll();
    }

    public Optional<ModelCar> findByIdModel(Long id) {
        return modelCarRepository.findById(id);
    }

    public ModelCar createdNewModel(CarDTO carDTO){
        return modelCarRepository.save(CarFactory.getNewModelByDTO(carDTO));
    }

    public ModelCar alterModel(CarDTO carDTO){
        return modelCarRepository.save(CarFactory.getNewModelByDTO(carDTO));
    }

}
