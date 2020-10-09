package br.com.tecgrub.be.controller;

import br.com.tecgrub.be.dto.CarDTO;
import br.com.tecgrub.dal.model.ModelCar;
import br.com.tecgrub.dal.service.ModelCarService;
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
@RequestMapping("${path.req.car.car-model}")
@ResponseStatus(HttpStatus.OK)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ModelCarController {

    @Autowired
    private ModelCarService modelCarService;

    @GetMapping()
    public ResponseEntity<Iterable<ModelCar>> findAllCar() {
        return ResponseEntity.status(HttpStatus.OK).body(modelCarService.findAllModel());
    }

    @GetMapping("${path.req.car.id}")
    public ResponseEntity<ModelCar> findById(@PathVariable("id") long id) {
        return ResponseEntity.status(HttpStatus.OK).body(modelCarService.findByIdModel(id).orElse(new ModelCar()));
    }

    @PutMapping("${path.req.car.id}")
    public ResponseEntity<ModelCar> alterCar(@Validated @RequestBody CarDTO car) {
        return ResponseEntity.status(HttpStatus.OK).body(modelCarService.alterModel(car));
    }

    @PostMapping()
    public ResponseEntity<ModelCar> createdNewCar(@Validated @RequestBody CarDTO carDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(modelCarService.createdNewModel(carDTO));
    }

}
