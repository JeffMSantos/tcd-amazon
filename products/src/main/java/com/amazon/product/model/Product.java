package com.amazon.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Product {

	@Id	
	private Integer id;
	private String name;
	private String detail;
	@Column(columnDefinition = "integer default 0")
	private Integer preview;
	@ManyToOne
	private Category category;
	@ManyToOne
	private Genre genre;
}
