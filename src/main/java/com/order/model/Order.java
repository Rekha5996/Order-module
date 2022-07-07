package com.order.model;

import java.text.SimpleDateFormat;
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
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long oid;
	private Date order_date;
	private Date delivery_date;       
	private String order_status;
	private String order_details;
	private int bill_amount;
	private int user_id;
	
	@OneToMany(targetEntity = Product.class  ,cascade = CascadeType.ALL)
	@JoinColumn(name = "order_fk", referencedColumnName = "oid")
	private List<Product> product;
	
    public static void main(String[] args) {
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    	Calendar cal= Calendar.getInstance();
    	cal.add(Calendar.DAY_OF_MONTH,7);
    	String delivery_date= sdf.format(cal.getTime());
	}
	
	

}
