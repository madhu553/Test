package com.example.demo.controller;

import com.example.demo.service.SumService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SumController {
	private final SumService sumService;

	public SumController(SumService sumService) {
		this.sumService = sumService;
	}

	@GetMapping("/api/sum")
	public int sum(@RequestParam int first, @RequestParam int second) {
		return sumService.sum(first, second);
	}
}