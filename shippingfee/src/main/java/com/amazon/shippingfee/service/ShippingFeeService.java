package com.amazon.shippingfee.service;

import com.amazon.shippingfee.model.Shipping;

public interface ShippingFeeService {

	Shipping calculateShipping(String zipCode);
}
