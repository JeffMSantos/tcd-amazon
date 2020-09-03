package com.amazon.orderstatus.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class OrderStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer idCustomer;
	private String nameCustomer;
	private String trackingNumber;
	@Enumerated(EnumType.STRING)
	private Status status;
	@ManyToOne(cascade = CascadeType.ALL)
	private Resume resume;
	@ManyToOne(cascade = CascadeType.ALL)
	private Address address;
}
