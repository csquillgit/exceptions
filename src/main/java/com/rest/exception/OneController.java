package com.rest.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OneController {

	@GetMapping("/one")
	public ResponseEntity<Person> getOne() {
		Person p = null;
		p.setName("Test Nullpointer");
		return ResponseEntity.ok(p);
	}

	@GetMapping("/two")
	public ResponseEntity<Person> getTwo() throws CustomCheckedException {
		throw new CustomCheckedException("Test Checked");
	}

	@GetMapping("/three")
	public ResponseEntity<Person> getThree() {
		throw new CustomRuntimeException("Test Runtime");
	}

	@GetMapping("/four")
	public ResponseEntity<Person> getFour() {
		throw new IllegalArgumentException("Test Illegal Argument");
	}

	@GetMapping("/five")
	public ResponseEntity<Person> getFive() {
		Person p = new Person();
		p.setName("Test");
		return ResponseEntity.ok(p);
	}
}
