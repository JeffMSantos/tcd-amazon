package com.amazon.shippingfee.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Shipping {

	private String origin;
	private String destiny;
	private String distance;
	private double value;
	private String note;
}
