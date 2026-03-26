package br.coutodev.order.service.repository;

import br.coutodev.order.service.domin.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderModel,Long> {
}
