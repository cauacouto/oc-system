package br.coutodev.order.service.controller;

import br.coutodev.order.service.Dto.OrderDto;
import br.coutodev.order.service.domin.OrderModel;
import br.coutodev.order.service.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerOrder {

    private final OrderService orderService;

    public ControllerOrder(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/Oc")
    public ResponseEntity<OrderModel> criarOc(@RequestBody OrderDto orderDto){
        var oderModel = new OrderModel();
        BeanUtils.copyProperties(oderModel,oderModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.criarOrder(orderDto));
    }
}
