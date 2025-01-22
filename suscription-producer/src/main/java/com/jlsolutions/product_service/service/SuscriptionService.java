package com.jlsolutions.product_service.service;

import com.jlsolutions.product_service.model.Suscription;
import com.jlsolutions.product_service.model.SuscriptionEvent;
import com.jlsolutions.product_service.model.SuscriptionEventStatus;
import com.jlsolutions.product_service.repository.SuscriptionRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SuscriptionService {
	private final SuscriptionRepository repository;
	private final KafkaTemplate<String, SuscriptionEvent> kafkaTemplate;

	@Value("${kafka.suscription-topic}")
	private String topic;

	public List<Suscription> findAll() {
		return repository.findAll();
	}

	public Optional<Suscription> findById(Long id) {
		return Optional.ofNullable(repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Suscription not found")));
	}

	public Suscription create(Suscription suscription) {
		suscription.setFechaAlta(LocalDateTime.now());
		suscription.setFechaActualizacion(LocalDateTime.now());
		Suscription saved = repository.save(suscription);

		sendKafkaEvent(saved, SuscriptionEventStatus.SUSCRIPTION_CREATED);
		return saved;
	}

	public Suscription update(Long id, Suscription suscription) {
		Suscription existing = findById(id).get();
		existing.setEstado(suscription.getEstado());
		existing.setNasdaqSiStatusReason(suscription.getNasdaqSiStatusReason());
		existing.setMdwStatusCode(suscription.getMdwStatusCode());
		existing.setMdwBusinessMessageId(suscription.getMdwBusinessMessageId());
		existing.setMdwResponseMessage(suscription.getMdwResponseMessage());
		existing.setMdwResponseDatetime(suscription.getMdwResponseDatetime());
		existing.setNasdaqSiStatus(suscription.getNasdaqSiStatus());
		existing.setFechaActualizacion(LocalDateTime.now());

		Suscription updated = repository.save(existing);
		sendKafkaEvent(updated, SuscriptionEventStatus.SUSCRIPTION_UPDATED);
		return updated;
	}

	public void delete(Long id) {
		Suscription suscription = findById(id).get();
		repository.deleteById(id);
		sendKafkaEvent(suscription, SuscriptionEventStatus.SUSCRIPTION_DELETED);
	}

	private void sendKafkaEvent(Suscription suscription, SuscriptionEventStatus status) {
		SuscriptionEvent event = new SuscriptionEvent();
		event.setSuscription(suscription);
		event.setEventStatus(status);

		kafkaTemplate.send(topic, event);
	}
}
