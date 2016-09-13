package com.test.demo.controller;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.xml.sax.InputSource;

public class Main {

	public static void main(String[] args) throws IOException {
		ClassPathResource resource = new ClassPathResource("");
		
		InputStream inputStream = resource.getInputStream();
		
		InputSource inputSource = new InputSource(inputStream);
		
//		inputSource.
	}
}
