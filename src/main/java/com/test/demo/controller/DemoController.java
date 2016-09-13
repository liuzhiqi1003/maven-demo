package com.test.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.demo.exception.CustomException;
import com.test.demo.po.User;

@Controller
public class DemoController {

	@ResponseBody
	@RequestMapping("/getMsg/{m}")
	public Map<String, Object> getMsg(@PathVariable String m) throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("success", true);
		map.put("msg", "成功了！");
		System.out.println("说点中国话啊。。。。。。");
		if("m".equals(m)){
			throw new CustomException("就是试一下");
		}else if("n".equals(m)){
			throw new Exception();
		}
		return map;
	}
	
	@RequestMapping("/addUser")
	public void addUser(@Validated User user,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			List<ObjectError> errors = bindingResult.getAllErrors();
			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}
		}
	}
	
	@ResponseBody
	@RequestMapping("/testJson")
	public Map<String, Object> testJson() throws IOException{
		
//		InputStream inputStream = Object.class.getResourceAsStream("/test.properties");
		File conf = new File(System.getProperty("catalina.base"), "conf");
//		File appConf = new File(conf, "app.properties");
//		Properties p = loadProperties(appConf);
//		Properties properties = new Properties();
//		properties.load(inputStream);
		System.out.println("----------------------------------");
//		System.out.println(properties.getProperty("a"));
		System.out.println(conf);
		System.out.println("----------------------------------");
		
		Map<String, Object> map = new HashMap<String,Object>();
		
		map.put("201608", "1");
		map.put("201607", "2");
		map.put("201508", "3");
		
		return map;
	}
}
