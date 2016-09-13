package com.test.po;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.internal.util.privilegedactions.GetClassLoader;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.StringUtils;
import org.springframework.util.xml.XmlValidationModeDetector;
import org.w3c.dom.Document;

public class TestUser {

	public static void main(String[] args) throws IOException {
//		Resource resource = new ClassPathResource("ApplicationContext.xml");
//		System.out.println(resource);
//		BeanFactory bf = new XmlBeanFactory(resource);
//		User user = bf.getBean("user", User.class);
//		System.out.println(user.getPassword());
		
//		Resource resource = new ClassPathResource("db.properties");
//		InputStream is = resource.getInputStream();
		
		
		InputStream is = TestUser.class.getClassLoader().getResourceAsStream("test.xml");
//		byte[] bs = new byte[100];
//		is.read(bs);
//		System.out.println(new String(bs));
		
//		XmlValidationModeDetector detetor = new XmlValidationModeDetector();
//		int mode = detetor.detectValidationMode(is);
//		System.out.println(mode);
		
//		System.out.println(StringUtils.hasText(null));
		String s = " a ";
		long start = System.currentTimeMillis();
//		s.trim();
		StringUtils.trimWhitespace(s);
		System.out.println(s);
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		
		
		
	}
}
