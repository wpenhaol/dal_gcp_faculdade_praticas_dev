package br.com.tecgrub.be.controller;

import br.com.tecgrub.be.dto.CarDTO;
import br.com.tecgrub.dal.model.PriceCar;
import br.com.tecgrub.dal.service.PriceService;
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
@RequestMapping("${path.req.car.car-price}")
@ResponseStatus(HttpStatus.OK)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PriceCarController {

    @Autowired
    private PriceService priceService;

    @GetMapping("${path.req.car.id}")
    public ResponseEntity<PriceCar> findById(@PathVariable("id") long id) {
        return ResponseEntity.status(HttpStatus.OK).body(priceService.findPriceByIdCar(id).orElse(new PriceCar()));
    }

    @PutMapping("${path.req.car.id}")
    public ResponseEntity<PriceCar> alterCar(@Validated @RequestBody CarDTO car) {
        return ResponseEntity.status(HttpStatus.OK).body(priceService.alterPrice(car));
    }

    @PostMapping()
    public ResponseEntity<PriceCar> createdNewCar(@Validated @RequestBody CarDTO carDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(priceService.createdNewPrice(carDTO));
    }

}
