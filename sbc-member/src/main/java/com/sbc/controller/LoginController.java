package com.sbc.controller;import java.io.UnsupportedEncodingException;import java.net.URLDecoder;import java.util.HashMap;import java.util.Map;import org.json.JSONObject;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.web.bind.annotation.PostMapping;import org.springframework.web.bind.annotation.RequestBody;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.ResponseBody;import org.springframework.web.bind.annotation.RestController;import com.sbc.data.Employee;import com.sbc.mapper.EmployeeMapper;@RestController@RequestMapping("api")public class LoginController {	@Autowired	EmployeeMapper employeeMapper;	@PostMapping(value = "user/login")	@ResponseBody	public Map<String, Object> test(@RequestBody String userInfo) throws UnsupportedEncodingException {		String b = URLDecoder.decode(userInfo, "utf-8");		JSONObject j = new JSONObject(b);		System.out.println("---" + j.get("username"));		Map<String, Object> result = new HashMap<String, Object>();		result.put("code", 20000);		result.put("data", "OK");		return result;	}	@PostMapping(value = "user/login2")	@ResponseBody	public Map<String, Object> login2(String username, String password) throws UnsupportedEncodingException {		Employee e = employeeMapper.getEmployeeById(1);		System.out.println("---" + e.getFirstName());		System.out.println("---" + username);		System.out.println("---" + password);		Map<String, Object> result = new HashMap<String, Object>();		result.put("code", 20000);		result.put("data", "OK`1");		return result;	}}