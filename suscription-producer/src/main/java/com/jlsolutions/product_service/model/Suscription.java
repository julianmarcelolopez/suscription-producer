package com.jlsolutions.product_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
public class Suscription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String estado;
	private LocalDateTime fechaAlta;
	private LocalDateTime fechaActualizacion;
	private String nasdaqSiStatusReason;
	private int mdwStatusCode;
	private String mdwBusinessMessageId;
	private String mdwResponseMessage;
	private String mdwResponseDatetime;
	private String nasdaqSiStatus;
}