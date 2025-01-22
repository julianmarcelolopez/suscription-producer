package com.jlsolutions.product_service.model;

import lombok.Data;

@Data
public class SuscriptionEvent {
	private Suscription suscription;
	private SuscriptionEventStatus eventStatus;
}