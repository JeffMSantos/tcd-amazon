package com.amazon.orderstatus.model.dto;

import com.amazon.orderstatus.model.Status;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OderStausDTO {

	private Status status;
	private String trackingNumber;
}
