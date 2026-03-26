package br.coutodev.order.service.service;

import br.coutodev.order.service.Dto.OrderDto;
import br.coutodev.order.service.domin.OrderModel;
import br.coutodev.order.service.enums.StatusOc;
import br.coutodev.order.service.producer.OrderProducer;
import br.coutodev.order.service.repository.OrderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository repository;

    private final OrderProducer orderProducer;

    public OrderService(OrderRepository repository, OrderProducer orderProducer) {
        this.repository = repository;
        this.orderProducer = orderProducer;
    }

    public OrderModel criarOrder(OrderDto orderDto){
        var order = new OrderModel();
        BeanUtils.copyProperties(orderDto,order);
        order.setStatusOc(StatusOc.CRIADO);
        repository.save(order);
        orderProducer.PublishMenssagem(order);
        return order;



    }
}
