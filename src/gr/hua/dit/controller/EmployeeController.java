package gr.hua.dit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.dao.EmployeeDAO;
import gr.hua.dit.entity.Employee;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeDAO employeeDAO;

	@RequestMapping("/")
	public String getLoginPage(Model model) {

		return "employeeLogin";
	}

	@RequestMapping("/user")
	public String checkLogin(HttpServletRequest request, Model model) {

		// get the input values
		String inputUsername = request.getParameter("username");
		String inputPassword = request.getParameter("password");

		// get the employees from dao
		List<Employee> employees = employeeDAO.getEmployees();

		// check if employee exists
		try {
			for (Employee emp : employees) {
				if (inputUsername.equals(emp.getUsername()) && inputPassword.equals(emp.getPassword())) {
					if (emp.getRights() == 1) {
						return "/user/admin/administrator";
					} else if (emp.getRights() == 2) {
						return "employee";
					} else {
						return "engineer";
					}
				}
			}
		} catch (NullPointerException ex) {
			request.setAttribute("errorMessage", "Please enter username and password");
			return "employeeLogin";
		}
		request.setAttribute("errorMessage", "Invalid username or password");
		return "employeeLogin";
	}
}
