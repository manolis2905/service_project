package gr.hua.dit.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.dao.AdminDAO;

@Controller
@RequestMapping("/user/admin")
public class AdministratorController {

	@Autowired
	private AdminDAO adminDAO;
	
	@RequestMapping("/administrator")
	public String getAdminPage() {
		return "/user/admin/administrator";
	}

	@RequestMapping("/createUser")
	public String createUserPage() {
		return "/user/admin/createUser";
	}

	@RequestMapping("/saveNewUser")
	public String saveNewUser(HttpServletRequest request) {
		adminDAO.createUser(request);

		request.setAttribute("message", "User has been successfully created!!");
		return "createUser";
	}

}