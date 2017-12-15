package gr.hua.dit.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.dao.EmployeeDAO;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeDAO empDAO;

	@RequestMapping("/user/employee/newCustomer")
	public String createCustomer() {
		return "/user/employee/newCustomer";
	}

	@RequestMapping("/user/employee/saveNewCustomer")
	public String saveNewCustomer(HttpServletRequest request, Model model) {

		empDAO.insertNewCustomer(request);

		model.addAttribute("message", "Customer has been successfully created!!");
		return "/user/employee/newCustomer";
	}

}
