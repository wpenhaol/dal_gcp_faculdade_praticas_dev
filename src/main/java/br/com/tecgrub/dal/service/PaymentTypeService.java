package br.com.tecgrub.dal.service;

import br.com.tecgrub.be.dto.PaymentTypeDTO;
import br.com.tecgrub.dal.factory.CarFactory;
import br.com.tecgrub.dal.model.PaymentType;
import br.com.tecgrub.dal.repository.PaymentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentTypeService {

    @Autowired
    private PaymentTypeRepository paymentTypeRepository;

    public Iterable<PaymentType> findAllPaymentType() {
        return paymentTypeRepository.findAll();
    }

    public Optional< PaymentType> findByIdPaymentType(Long id) {
        return paymentTypeRepository.findById(id);
    }

    public  PaymentType createdPaymentTypel(PaymentTypeDTO paymentTypeDTO){
        return paymentTypeRepository.save(CarFactory.getNewPaymentTypeDTO(paymentTypeDTO));
    }

    public  PaymentType alterPaymentType(PaymentTypeDTO paymentTypeDTO){
        return paymentTypeRepository.save(CarFactory.getNewPaymentTypeDTO(paymentTypeDTO));
    }

}
