package bunn.reference.event.consumer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bunn.reference.event.Event;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v0/events")
@Tag(name = "EventConsumerController")
public class EventConsumerController {

	@GetMapping("/")
	@Operation(summary = "Up Check", description = "Returns OK if the service is up", hidden = true)
	public ResponseEntity<?> upCheck() {
		return ResponseEntity.ok("OK");
	}

	@PostMapping("/")
	@Operation(summary = "Consume Event")
	public ResponseEntity<EventConsumtionResponse> consumeEvent(@RequestBody Event event) {
		log.info("Consuming Event: {}", event);

		// Processing goes here

		EventConsumtionResponse response = EventConsumtionResponse.builder()
				.eventId(event.getId()) //
				.message("We received your messge. Thank you!") //
				.build();

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
