package br.com.tecgrub.dal.factory;

import br.com.tecgrub.dal.model.Employee;
import br.com.tecgrub.dal.model.Estimate;

import java.time.LocalDateTime;

public interface EstimateFactory {

    static Estimate getEstimate(Employee employee, Long idEstimate, LocalDateTime dttm){
        Estimate estimate = new Estimate();
        estimate.setDttmOrcamento(dttm);
        estimate.setEmployee(employee);
        estimate.setId(idEstimate);
        return estimate;
    }

}
