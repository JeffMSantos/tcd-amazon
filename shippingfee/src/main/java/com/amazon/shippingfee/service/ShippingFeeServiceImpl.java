package com.amazon.shippingfee.service;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.amazon.shippingfee.model.Shipping;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrixRow;
import com.google.maps.model.TravelMode;

@Service
@Profile("prod")
public class ShippingFeeServiceImpl implements ShippingFeeService {

	@Override
	public Shipping calculateShipping(String zipCode) {

		if (!zipCode.isEmpty()) {
			zipCode = formatString(zipCode.trim(), "#####-###");
		}

		GeoApiContext context = new GeoApiContext().setApiKey("INSERT API KEY GOOGLE");
		String FIAP = "FIAP, Av. Paulista, 1106 - 7º andar - Cerqueira César, São Paulo - SP, 01311-000";
		Shipping shipping = new Shipping();

		try {
			DistanceMatrixRow rows[] = DistanceMatrixApi
					.getDistanceMatrix(context, new String[] { FIAP }, new String[] { zipCode })
					.mode(TravelMode.DRIVING).await().rows;

			shipping.setOrigin(FIAP);
			shipping.setDestiny(zipCode);
			shipping.setDistance(rows[0].elements[0].distance.toString());
			calculateValue(rows, shipping);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return shipping;
	}

	private void calculateValue(DistanceMatrixRow[] rows, Shipping shipping) {

		Long inMeters = rows[0].elements[0].distance.inMeters;

		if (inMeters <= 50000) {
			shipping.setValue(15);
			shipping.setNote("Próximo a região");
		} else if (inMeters > 50000 && inMeters <= 200000) {
			shipping.setValue(60);
			shipping.setNote("distante da região");
		} else {
			shipping.setValue(0);
			shipping.setNote("Não entregamos nesta região");
		}
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
