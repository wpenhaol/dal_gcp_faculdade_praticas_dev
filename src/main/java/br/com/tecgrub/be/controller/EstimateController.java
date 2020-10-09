package br.com.tecgrub.be.controller;

import br.com.tecgrub.be.dto.EstimateDTO;
import br.com.tecgrub.dal.model.Estimate;
import br.com.tecgrub.dal.service.EstimateService;
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
@RequestMapping("${path.req.estimate.all}")
@ResponseStatus(HttpStatus.OK)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EstimateController {

    @Autowired
    private EstimateService estimateService;

    @GetMapping()
    public ResponseEntity<Iterable<Estimate>> findAllClient() {
        return ResponseEntity.status(HttpStatus.OK).body(estimateService.findAllEstimate());
    }

    @PostMapping()
    public ResponseEntity<Estimate> createdNewEstimate(@Validated @RequestBody EstimateDTO estimateDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(estimateService.createdEstimate(estimateDTO));
    }

    @GetMapping("${path.req.estimate.id}")
    public ResponseEntity<Estimate> findEstimateById(@PathVariable("id") long id) {
        return ResponseEntity.status(HttpStatus.OK).body(estimateService.findByIdEstimate(id).orElse(new Estimate()));
    }

    @PutMapping("${path.req.estimate.id}")
    public ResponseEntity<Estimate> alterEstimateById(@Validated @RequestBody EstimateDTO estimateDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(estimateService.alterEstimate(estimateDTO));
    }

}
