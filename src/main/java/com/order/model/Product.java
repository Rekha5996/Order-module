package com.order.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@Table(name="product_table")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
	
	@Id
	private long pid;
	private String pname;
	private String pdesc;
	private int price;
	private int quantity; 
	

}
