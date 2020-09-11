package com.amazon.shippingfee.service;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.amazon.shippingfee.model.Shipping;

@Service
@Profile("dev")
public class ShippingFeeServiceMockImpl implements ShippingFeeService {

	@Override
	public Shipping calculateShipping(String zipCode) {

		if (!zipCode.isEmpty()) {
			zipCode = formatString(zipCode.trim(), "#####-###");
		}

		String FIAP = "FIAP, Av. Paulista, 1106 - 7º andar - Cerqueira César, São Paulo - SP, 01311-000";
		Shipping shipping = new Shipping();

		shipping.setOrigin(FIAP);
		shipping.setDestiny(zipCode);
		shipping.setDistance("26km");
		shipping.setValue(15);
		shipping.setNote("VALOR MOCK FAVOR INSERIR KEY API GOOGLE");
		return shipping;
	}

	private String formatString(String value, String pattern) {
		MaskFormatter mf;
		try {
			mf = new MaskFormatter(pattern);
			mf.setValueContainsLiteralCharacters(false);
			return mf.valueToString(value);
		} catch (ParseException ex) {
			return value;
		}
	}
}
