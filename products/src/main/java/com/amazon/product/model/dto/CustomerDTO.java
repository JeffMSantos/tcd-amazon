package com.amazon.product.model.dto;

import java.util.List;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {

	Integer id;
	String name;
	List<WishListDTO> wishList;
}
