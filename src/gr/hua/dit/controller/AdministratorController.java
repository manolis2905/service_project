package gr.hua.dit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.entity.ApplicationUser;
import gr.hua.dit.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdministratorController {

	private int id;

	// inject the admin service
	@Autowired
	private AdminService adminService;

	@GetMapping("/createUser")
	public String createUserPage(Model model) {
		// create model attribute to get form data
		ApplicationUser appUser = new ApplicationUser();
		model.addAttribute("appUser", appUser);

		// add page title
		model.addAttribute("pageTitle", "Create New User");

		return "user/admin/createUser";
	}

	@PostMapping("/saveNewUser")
	public String saveNewUser(@ModelAttribute("appUser") ApplicationUser appUser) {
		// save the appUser using the service
		adminService.createUser(appUser);

		return "redirect:/admin/createUser";
	}

	@GetMapping("/deleteUser")
	public String deleteUserPage(Model model) {
		// create model attribute to get form data
		ApplicationUser appUser = new ApplicationUser();
		model.addAttribute("appUser", appUser);
		
		// add page title
		model.addAttribute("pageTitle", "Delete User");

		return "user/admin/deleteUser";
	}

	@PostMapping("/deleteuser")
	public String deleteUser(@ModelAttribute("appUser") ApplicationUser appUser) {
		adminService.deleteUser(appUser.getId());

		return "redirect:/admin/deleteUser";
	}

	/*
	 * @RequestMapping("/user/admin/modifyUser") public String modifyUserPage() {
	 * return "/user/admin/modifyUser"; }
	 * 
	 * @RequestMapping("/user/admin/findId") public String
	 * modifyUser(HttpServletRequest request, Model model) { List<ApplicationUser>
	 * user = adminService.getUserById(request);
	 * 
	 * this.id = user.get(0).getId();
	 * 
	 * model.addAttribute("username", user.get(0).getUsername());
	 * model.addAttribute("password", user.get(0).getPassword());
	 * model.addAttribute("rights", user.get(0).getRights());
	 * 
	 * return "/user/admin/modifyUser"; }
	 * 
	 * @RequestMapping("/user/admin/saveModifiedUser") public String
	 * saveModifiedUser(HttpServletRequest request, Model model) {
	 * adminService.modifyUser(this.id);
	 * 
	 * model.addAttribute("message", "User has been successfully modified"); return
	 * "/user/admin/modifyUser";
	 * 
	 * }
	 */

}