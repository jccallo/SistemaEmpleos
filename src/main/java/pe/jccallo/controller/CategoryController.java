package pe.jccallo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		return "category/categoryList";
	}
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		return "category/categoryForm";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save() {
		return "category/categoryList";
	}
}
