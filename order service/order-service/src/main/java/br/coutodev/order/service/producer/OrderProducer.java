package br.coutodev.order.service.producer;

import br.coutodev.order.service.Dto.OrderDto;
import br.coutodev.order.service.domin.OrderModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OrderProducer {

    final RabbitTemplate rabbitTemplate;


    public OrderProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    @Value(value = "${broker.queue.order.name}")
    private String RountingKey;


    public void PublishMenssagem(OrderModel orderModel){
        var orderDto = new OrderDto();
        orderDto.setOrderId(orderModel.getOrderId());
        orderDto.setEmailTo(orderModel.getEmailTo());
        orderDto.setDescricao(orderModel.getDescricao());
        orderDto.setStatusOc(orderModel.getStatusOc());
        orderDto.setQuantidade(orderModel.getQuantidade());
        orderDto.setValor(orderModel.getValor());
        orderDto.setDataCriacao(orderModel.getDataCriacao());
        orderDto.setNumeroOc(orderModel.getNumeroOc());

        rabbitTemplate.convertAndSend("",RountingKey,orderDto);



    }
}


