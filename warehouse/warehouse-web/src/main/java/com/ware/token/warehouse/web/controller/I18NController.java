package com.ware.token.warehouse.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/international")
public class I18NController {

	@ResponseBody
	@RequestMapping("/switchLanguage")
	public Map<String, Object> switchLanguage(String locale, HttpSession session) {
		System.out.println("..................................................................");
		if (locale == null || locale.isEmpty()) {
			session.setAttribute("locale", "zh_CN");
		} else {
			session.setAttribute("locale", locale);
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", "success");
		return result;
	}
}
