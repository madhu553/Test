package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class SumServiceImpl implements SumService {
	@Override
	public int sum(int first, int second) {
		return first + second;
	}
}