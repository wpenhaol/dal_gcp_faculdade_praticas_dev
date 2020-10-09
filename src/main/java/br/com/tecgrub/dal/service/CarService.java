package br.com.tecgrub.dal.service;

import br.com.tecgrub.be.dto.CarDTO;
import br.com.tecgrub.dal.factory.CarFactory;
import br.com.tecgrub.dal.model.Car;
import br.com.tecgrub.dal.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Iterable<Car> findAllCar() {
        return carRepository.findAll();
    }

    public Optional<Car> findByIdCar(Long id) {
        return carRepository.findById(id);
    }

    public Car createdNewCar(CarDTO carDTO){
        return carRepository.save(CarFactory.getNewCarByDTO(carDTO));
    }

    public Car alterCar(CarDTO carDTO){

        return carRepository.save(CarFactory.getNewCarByDTO(carDTO));
    }

}
