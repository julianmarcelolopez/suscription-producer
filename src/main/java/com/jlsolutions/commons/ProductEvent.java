package com.jlsolutions.commons;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductEvent {
	private String id; // Identificador único del evento
	private ProductEventType eventType;
	private ProductDTO productDTO;
	private LocalDateTime timestamp;
	private String source; // Origen del evento (microservicio)
}