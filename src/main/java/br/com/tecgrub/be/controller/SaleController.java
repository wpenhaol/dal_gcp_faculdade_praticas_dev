package br.com.tecgrub.be.controller;

import br.com.tecgrub.be.dto.SaleDTO;
import br.com.tecgrub.dal.model.Sale;
import br.com.tecgrub.dal.service.SaleService;
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
@RequestMapping("${path.req.sale.all}")
@ResponseStatus(HttpStatus.OK)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping()
    public ResponseEntity<Iterable<Sale>> findAllClient() {
        return ResponseEntity.status(HttpStatus.OK).body(saleService.findAllSale());
    }

    @PostMapping()
    public ResponseEntity<Sale> createdNewEstimate(@Validated @RequestBody SaleDTO saleDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(saleService.createdSale(saleDTO));
    }

    @GetMapping("${path.req.sale.id}")
    public ResponseEntity<Sale> findEstimateById(@PathVariable("id") long id) {
        return ResponseEntity.status(HttpStatus.OK).body(saleService.findByIdSale(id).orElse(new Sale()));
    }

    @PutMapping("${path.req.sale.id}")
    public ResponseEntity<Sale> alterEstimateById(@Validated @RequestBody SaleDTO saleDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(saleService.alterSale(saleDTO));
    }

}
