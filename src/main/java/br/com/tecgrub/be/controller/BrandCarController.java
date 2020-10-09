package br.com.tecgrub.be.controller;

import br.com.tecgrub.be.dto.CarDTO;
import br.com.tecgrub.dal.model.BrandCar;
import br.com.tecgrub.dal.service.BrandCarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("${path.req.car.car-brand}")
@ResponseStatus(HttpStatus.OK)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BrandCarController {

    @Autowired
    private BrandCarService brandCarService;

    @GetMapping()
    public ResponseEntity<Iterable<BrandCar>> findAllCar() {
        return ResponseEntity.status(HttpStatus.OK).body(brandCarService.findAllBrand());
    }

    @GetMapping("${path.req.car.id}")
    public ResponseEntity<BrandCar> findById(@PathVariable("id") long id) {
        return ResponseEntity.status(HttpStatus.OK).body(brandCarService.findByIdBrand(id).orElse(new BrandCar()));
    }

    @PutMapping("${path.req.car.id}")
    public ResponseEntity<BrandCar> alterCar(@Validated @RequestBody CarDTO car) {
        return ResponseEntity.status(HttpStatus.OK).body(brandCarService.alterBrand(car));
    }

    @PostMapping()
    public ResponseEntity<BrandCar> createdNewCar(@Validated @RequestBody CarDTO carDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(brandCarService.createdNewBrand(carDTO));
    }

    @DeleteMapping("${path.req.car.id}")
    public ResponseEntity<HttpStatus> deleteBrandById(@PathVariable("id") long id) {
        brandCarService.deleteBrand(id);
        return ResponseEntity.status(HttpStatus.OK).body(HttpStatus.OK);
    }
}
