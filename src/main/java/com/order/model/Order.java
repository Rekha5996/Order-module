package com.order.model;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.jms.JmsProperties.DeliveryMode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@Table(name="order_table")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long oid;
	private Date order_date;
	private Date delivery_date;
    //private LocalDate delivery_date = LocalDate.plusDays(date(7));       
	private String order_status;
	private String order_details;
	private int bill_amount;
	private int user_id;
	
	@OneToMany(targetEntity = Product.class  ,cascade = CascadeType.ALL)
	@JoinColumn(name = "order_fk", referencedColumnName = "oid")
	private List<Product> product;

	public Order(long oid, Date order_date, LocalDate delivery_date, String order_status, String order_details,
			int bill_amount, int user_id, List<Product> product) {
		super();
		this.oid = oid;
		this.order_date = order_date;
		this.delivery_date = new Date();
		this.order_status = order_status;
		this.order_details = order_details;
		this.bill_amount = bill_amount;
		this.user_id = user_id;
		this.product = product;
	}

	
}

