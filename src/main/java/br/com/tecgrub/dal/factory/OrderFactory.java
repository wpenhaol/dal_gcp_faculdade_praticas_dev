package br.com.tecgrub.dal.factory;

import br.com.tecgrub.be.dto.OrderDTO;
import br.com.tecgrub.dal.model.Car;
import br.com.tecgrub.dal.model.Estimate;
import br.com.tecgrub.dal.model.Order;

public interface OrderFactory {

    static Order getOrder(Estimate estimate, Car car, OrderDTO orderDto){

        Order order =  new Order();
        order.setCar(car);
        order.setEstimate(estimate);
        order.setId(orderDto.getId());
        order.setAmountCars(orderDto.getAmountCars());
        order.setValueTotalOrder(order.getValueTotalOrder());

        return order;
    }

}
