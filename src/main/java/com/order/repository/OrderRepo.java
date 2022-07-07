package com.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.model.Order;

public interface OrderRepo extends JpaRepository<Order, Long>{

}
