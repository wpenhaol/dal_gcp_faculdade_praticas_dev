package br.com.tecgrub.be.controller;

import br.com.tecgrub.be.dto.PaymentTypeDTO;
import br.com.tecgrub.dal.model.PaymentType;
import br.com.tecgrub.dal.service.PaymentTypeService;
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
@RequestMapping("${path.req.payment.all}")
@ResponseStatus(HttpStatus.OK)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PaymentTypeController {

    @Autowired
    private PaymentTypeService paymentTypeService;

    @GetMapping()
    public ResponseEntity<Iterable<PaymentType>> findAllCar() {
        return ResponseEntity.status(HttpStatus.OK).body(paymentTypeService.findAllPaymentType());
    }

    @GetMapping("${path.req.payment.id}")
    public ResponseEntity<PaymentType> findById(@PathVariable("id") long id) {
        return ResponseEntity.status(HttpStatus.OK).body(paymentTypeService.findByIdPaymentType(id).orElse(new PaymentType()));
    }

    @PutMapping("${path.req.payment.id}")
    public ResponseEntity<PaymentType> alterCar(@Validated @RequestBody PaymentTypeDTO paymentTypeDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(paymentTypeService.alterPaymentType(paymentTypeDTO));
    }

    @PostMapping()
    public ResponseEntity<PaymentType> createdNewCar(@Validated @RequestBody PaymentTypeDTO paymentTypeDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(paymentTypeService.createdPaymentTypel(paymentTypeDTO));
    }

}
