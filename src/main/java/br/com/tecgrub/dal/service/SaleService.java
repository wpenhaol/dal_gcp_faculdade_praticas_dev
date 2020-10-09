package br.com.tecgrub.dal.service;

import br.com.tecgrub.be.dto.SaleDTO;
import br.com.tecgrub.dal.factory.SaleFactory;
import br.com.tecgrub.dal.model.Sale;
import br.com.tecgrub.dal.repository.ClientRepository;
import br.com.tecgrub.dal.repository.EstimateRepository;
import br.com.tecgrub.dal.repository.PaymentTypeRepository;
import br.com.tecgrub.dal.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private EstimateRepository estimateRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PaymentTypeRepository paymentTypeRepository;

    public Iterable<Sale> findAllSale() {
        return saleRepository.findAll();
    }

    public Optional<Sale> findByIdSale(Long id) {
        return saleRepository.findById(id);
    }

    public Sale createdSale(SaleDTO saleDTO){

        return saleRepository.save(
                SaleFactory.getSale(
                        estimateRepository.findById(saleDTO.getEstimateId()).get(),
                        clientRepository.findById(saleDTO.getClientId()).get(),
                        paymentTypeRepository.findById(saleDTO.getPaymentTypeId()).get(),
                        saleDTO
                )
        );
    }

    public Sale alterSale(SaleDTO saleDTO){
        return saleRepository.save(
                SaleFactory.getSale(
                        estimateRepository.findById(saleDTO.getEstimateId()).get(),
                        clientRepository.findById(saleDTO.getClientId()).get(),
                        paymentTypeRepository.findById(saleDTO.getPaymentTypeId()).get(),
                        saleDTO
                )
        );
    }

}
