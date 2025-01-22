package com.jlsolutions.commons;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {
	private String id;
	private String name;
	private Double price;
	private String description;
	private List<String> categories;
	private String brand;
	private List<VariantDTO> variants;
}