package br.com.tecgrub.dal.service;

import br.com.tecgrub.be.dto.EstimateDTO;
import br.com.tecgrub.dal.factory.EstimateFactory;
import br.com.tecgrub.dal.model.Estimate;
import br.com.tecgrub.dal.repository.EmployeeRepository;
import br.com.tecgrub.dal.repository.EstimateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstimateService {

    @Autowired
    private EstimateRepository estimateRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public Iterable<Estimate> findAllEstimate() {
        return estimateRepository.findAll();
    }

    public Optional<Estimate> findByIdEstimate(Long id) {
        return estimateRepository.findById(id);
    }

    public  Estimate createdEstimate(EstimateDTO estimateDTO){

        return estimateRepository.save(
                EstimateFactory.getEstimate(
                    employeeRepository.findById(estimateDTO.getIdEmployee()).get(),
                    estimateDTO.getIdEstimate(),
                    estimateDTO.getDttm()
                )
        );
    }

    public  Estimate alterEstimate(EstimateDTO estimateDTO){
        return estimateRepository.save(
                EstimateFactory.getEstimate(
                        employeeRepository.findById(estimateDTO.getIdEmployee()).get(),
                        estimateDTO.getIdEstimate(),
                        estimateDTO.getDttm()
                )
        );
    }

}
