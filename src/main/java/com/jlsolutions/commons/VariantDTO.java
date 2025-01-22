package com.jlsolutions.commons;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VariantDTO {
	private String variantId;
	private String color;
	private String size;
	private String sku;
}
