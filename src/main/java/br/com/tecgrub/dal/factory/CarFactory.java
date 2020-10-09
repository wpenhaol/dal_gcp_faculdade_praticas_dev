package br.com.tecgrub.dal.factory;

import br.com.tecgrub.be.dto.CarDTO;
import br.com.tecgrub.be.dto.PaymentTypeDTO;
import br.com.tecgrub.dal.model.BrandCar;
import br.com.tecgrub.dal.model.Car;
import br.com.tecgrub.dal.model.ModelCar;
import br.com.tecgrub.dal.model.PaymentType;
import br.com.tecgrub.dal.model.PriceCar;

public interface CarFactory {

    static Car getNewCarByDTO(CarDTO carDTO){
        Car car = new Car();
        car.setId(carDTO.getCarId());
        car.setPlaca(carDTO.getNamePlaca());
        car.setChassi(carDTO.getNameChassi());
        car.setModelCarId(carDTO.getModelId());
        return car;
    }

    static BrandCar getNewBrandByDTO(CarDTO carDTO){
        BrandCar brandCar = new BrandCar();
        brandCar.setId(carDTO.getBrandId());
        brandCar.setNameBrand(carDTO.getNameBrand());
        brandCar.setCnpj(carDTO.getCnpjBrand());
        brandCar.setEndereco(carDTO.getEnderecoBrand());
        brandCar.setTelefone(carDTO.getTelefoneBrand());
        return brandCar;
    }

    static ModelCar getNewModelByDTO(CarDTO carDTO){
        ModelCar modelCar = new ModelCar();
        modelCar.setId(carDTO.getModelId());
        modelCar.setBrandId(carDTO.getBrandId());
        modelCar.setColor(carDTO.getColor());
        modelCar.setNameModel(carDTO.getNameModel());
        modelCar.setYearFactory(carDTO.getYearFactory());
        return modelCar;
    }

    static PriceCar getNewPriceByDTO(CarDTO carDTO) {
        PriceCar priceCar = new PriceCar();
        priceCar.setId(carDTO.getPriceId());
        priceCar.setCarId(carDTO.getCarId());
        priceCar.setValueCar(carDTO.getPrice());
        return priceCar;
    }

    static PaymentType getNewPaymentTypeDTO(PaymentTypeDTO paymentTypeDTO){
        PaymentType paymentType = new PaymentType();
        paymentType.setId(paymentTypeDTO.getId());
        paymentType.setNamePaymentType(paymentTypeDTO.getNamePaymentType());
        return paymentType;
    }
}
