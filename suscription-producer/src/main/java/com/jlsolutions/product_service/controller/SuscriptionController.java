package com.jlsolutions.product_service.controller;

import com.jlsolutions.product_service.model.Suscription;
import com.jlsolutions.product_service.service.SuscriptionService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/suscriptions")
@RequiredArgsConstructor
public class SuscriptionController {

	private final SuscriptionService service;

	@GetMapping
	public List<Suscription> getAllSubscriptions() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Suscription> getSubscriptionById(@PathVariable Long id) {
		return service.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Suscription> createSubscription(@RequestBody Suscription subscription) {
		return ResponseEntity.ok(service.create(subscription));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Suscription> updateSubscription(@PathVariable Long id,
														  @RequestBody Suscription subscription) {
		return ResponseEntity.ok(service.update(id, subscription));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSubscription(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}