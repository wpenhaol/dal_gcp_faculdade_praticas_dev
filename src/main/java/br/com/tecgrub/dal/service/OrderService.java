package br.com.tecgrub.dal.service;

import br.com.tecgrub.be.dto.OrderDTO;
import br.com.tecgrub.dal.factory.OrderFactory;
import br.com.tecgrub.dal.model.Order;
import br.com.tecgrub.dal.repository.CarRepository;
import br.com.tecgrub.dal.repository.EstimateRepository;
import br.com.tecgrub.dal.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private EstimateRepository estimateRepository;

    public Iterable<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> findByIdOrder(Long id) {
        return orderRepository.findById(id);
    }

    public Order createdOrder(OrderDTO orderDTO){
        return orderRepository.save(
                OrderFactory.getOrder(
                        estimateRepository.findById(orderDTO.getEstimateId()).get(),
                        carRepository.findById(orderDTO.getCarId()).get(),
                        orderDTO
                )
        );
    }

    public Order alterOrder(OrderDTO orderDTO){
        return orderRepository.save(
                OrderFactory.getOrder(
                        estimateRepository.findById(orderDTO.getEstimateId()).get(),
                        carRepository.findById(orderDTO.getCarId()).get(),
                        orderDTO
                )
        );
    }

}
