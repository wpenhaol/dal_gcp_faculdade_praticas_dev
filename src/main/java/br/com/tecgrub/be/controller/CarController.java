package br.com.tecgrub.be.controller;

import br.com.tecgrub.be.dto.CarDTO;
import br.com.tecgrub.dal.model.Car;
import br.com.tecgrub.dal.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("${path.req.car.all}")
@ResponseStatus(HttpStatus.OK)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping()
    public ResponseEntity<Iterable<Car>> findAllCar() {
        return ResponseEntity.status(HttpStatus.OK).body(carService.findAllCar());
    }

    @GetMapping("${path.req.car.id}")
    public ResponseEntity<Car> findById(@PathVariable("id") long id) {
        return ResponseEntity.status(HttpStatus.OK).body(carService.findByIdCar(id).orElse(new Car()));
    }

    @PutMapping("${path.req.car.id}")
    public ResponseEntity<Car> alterCar(@Validated @RequestBody CarDTO car) {
        return ResponseEntity.status(HttpStatus.OK).body(carService.alterCar(car));
    }

    @PostMapping()
    public ResponseEntity<Car> createdNewCar(@Validated @RequestBody CarDTO carDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(carService.createdNewCar(carDTO));
    }

}
