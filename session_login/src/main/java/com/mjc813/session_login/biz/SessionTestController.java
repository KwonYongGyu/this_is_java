package com.mjc813.session_login.biz;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SessionTestController {

	@GetMapping("/session/make")
	public String make(HttpSession session
			, @RequestParam("name") String name
			, @RequestParam("value") String value, Model model)
	{
		session.setAttribute("name", value);
		session.setMaxInactiveInterval(3600);
		model.addAttribute("name", name);
		model.addAttribute("value", session.getAttribute(name).toString());
		return "info/info";
	}

	@GetMapping("/session/get")
	public String get(HttpServletRequest request
			, @RequestParam("name") String name, Model model)
	{
		Object value = request.getSession().getAttribute(name);
		model.addAttribute("name", name);
		model.addAttribute("value", value.toString());
		return "info/info";
	}


	@GetMapping("/session/delete")
	public String delete(HttpServletResponse response
			, @RequestParam("name") String name, Model model)
	{
		request.getSessoin().invalidate();
		model.addAttribute("cookie_time", "");
		model.addAttribute("cookie_name", "");
		model.addAttribute("cookie_value", "");
		return "info/info";
	}
}
