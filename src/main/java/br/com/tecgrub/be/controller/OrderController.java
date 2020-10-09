package br.com.tecgrub.be.controller;

import br.com.tecgrub.be.dto.OrderDTO;
import br.com.tecgrub.dal.model.Order;
import br.com.tecgrub.dal.service.OrderService;
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
@RequestMapping("${path.req.order.all}")
@ResponseStatus(HttpStatus.OK)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping()
    public ResponseEntity<Iterable<Order>> findAllClient() {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findAllOrders());
    }

    @PostMapping()
    public ResponseEntity<Order> createdNewEstimate(@Validated @RequestBody  OrderDTO orderDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.createdOrder(orderDTO));
    }

    @GetMapping("${path.req.order.id}")
    public ResponseEntity<Order> findEstimateById(@PathVariable("id") long id) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findByIdOrder(id).orElse(new Order()));
    }

    @PutMapping("${path.req.order.id}")
    public ResponseEntity<Order> alterEstimateById(@Validated @RequestBody OrderDTO orderDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.alterOrder(orderDTO));
    }

}
