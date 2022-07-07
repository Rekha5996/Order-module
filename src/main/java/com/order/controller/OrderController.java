package com.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.dto.OrderDto;
import com.order.exception.ResourceNotFoundException;
import com.order.model.Order;
import com.order.repository.OrderRepo;


@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderRepo orepo;
	
	//get order details based on user id
	@GetMapping("/orderdetails")
	public List<Order> getOrderDetails(){
		List<Order> lst=orepo.findAll();
				return lst;
	}
	//place an order
		@PostMapping("/placeorder")
		public String CreateProduct(@RequestBody OrderDto order) {
			 orepo.save(order.getOrder());
               return "Your order is placed";	
		}
		//update order details
		@PutMapping("/updateorder/{oid}")
		public Order updateUser(@RequestBody Order order, @PathVariable("oid") long id) {
			Order oorder=orepo.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Order not found with id:"+id)); 			
			oorder.setDelivery_date(order.getDelivery_date());
			oorder.setOrder_date(order.getOrder_date());
			oorder.setOrder_details(order.getOrder_details());
			oorder.setOrder_status(order.getOrder_status());
			oorder.setBill_amount(order.getBill_amount());
			oorder.setProduct(order.getProduct());
			return orepo.save(oorder);
			
			}
		//cancel the order
			@DeleteMapping("/cancelorder/{oid}")
			public ResponseEntity<Order> deleteUser(@PathVariable("oid")long id) {
				Order oorder=orepo.findById(id)
						.orElseThrow(() -> new ResourceNotFoundException("Order not found with id:"+id));
				orepo.delete(oorder);
				return ResponseEntity.ok().build();
			}
		
}
