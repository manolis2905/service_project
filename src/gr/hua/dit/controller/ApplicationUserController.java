package gr.hua.dit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.entity.ApplicationUser;
import gr.hua.dit.service.ApplicationUserService;

@Controller
@RequestMapping("/login")
public class ApplicationUserController {

	@Autowired
	private ApplicationUserService appUserService;
	
	@GetMapping("/loginAs")
	public String getHomePage(Model model) {
		model.addAttribute("pageTitle", "Home Page");
		return "login/loginAs";
	}

	@GetMapping("/adminLogin")
	public String getAdminLoginPage(Model model) {
		model.addAttribute("pageTittle", "Administrator Login");

		ApplicationUser appUser = new ApplicationUser();
		model.addAttribute("appUser", appUser);

		return "login/adminLogin";
	}

	@GetMapping("/employeeLogin")
	public String getEmployeeLoginPage(Model model) {
		model.addAttribute("pageTittle", "Employee Login");
		
		ApplicationUser appUser = new ApplicationUser();
		model.addAttribute("appUser", appUser);
		
		return "login/employeeLogin";
	}

	@GetMapping("/engineerLogin")
	public String getEngineerLoginPage(Model model) {
		model.addAttribute("pageTittle", "Engineer Login");
		
		ApplicationUser appUser = new ApplicationUser();
		model.addAttribute("appUser", appUser);
		
		return "login/engineerLogin";
	}

	@PostMapping("/checkAdminLogin")
	public String adminLogin(@ModelAttribute("appUser") ApplicationUser appUser, Model model) {

		// get the administrators from dao
		List<ApplicationUser> admins = appUserService.getAdministrators(1);

		// check if administrator exists
		try {
			for (ApplicationUser admin : admins) {
				if (appUser.getUsername().equals(admin.getUsername())&& appUser.getPassword().equals(admin.getPassword())) {
					appUser.setId(admin.getId());
					appUser.setRights(admin.getRights());
					return "user/admin/administrator";
				}
			}
			// model.addAttribute("errorMessage", "Invalid username or password");
			return "redirect:/login/adminLogin";
		} catch (NullPointerException ex) {
			// model.addAttribute("errorMessage", "Invalid username or password");
			return "redirect:/login/adminLogin";
		}
	}

	@PostMapping("/checkEmployeeLogin")
	public String employeeLogin(@ModelAttribute("appUser") ApplicationUser appUser, Model model) {
		// get the employees from dao
		List<ApplicationUser> employees = appUserService.getAdministrators(2);

		// check if employee exists
		try {
			for (ApplicationUser employee : employees) {
				if (appUser.getUsername().equals(employee.getUsername())
						&& appUser.getPassword().equals(employee.getPassword())) {
					appUser.setId(employee.getId());
					appUser.setRights(employee.getRights());
					return "user/employee/employee";
				}
			}
			// model.addAttribute("errorMessage", "Invalid username or password");
			return "redirect:/login/employeeLogin";
		} catch (NullPointerException ex) {
			// model.addAttribute("errorMessage", "Invalid username or password");
			return "redirect:/login/employeeLogin";
		}
	}
	
	@PostMapping("/checkEngineerLogin")
	public String engineerLogin(@ModelAttribute("appUser") ApplicationUser appUser, Model model) {
		// get the engineers from dao
		List<ApplicationUser> engineers = appUserService.getAdministrators(3);

		// check if engineer exists
		try {
			for (ApplicationUser engineer : engineers) {
				if (appUser.getUsername().equals(engineer.getUsername())
						&& appUser.getPassword().equals(engineer.getPassword())) {
					appUser.setId(engineer.getId());
					appUser.setRights(engineer.getRights());
					return "user/engineer/engineer";
				}
			}
			// model.addAttribute("errorMessage", "Invalid username or password");
			return "redirect:/login/engineerLogin";
		} catch (NullPointerException ex) {
			// model.addAttribute("errorMessage", "Invalid username or password");
			return "redirect:/login/engineerLogin";
		}
	}
}
