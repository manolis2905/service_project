package gr.hua.dit.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.dao.AdminDAO;
import gr.hua.dit.entity.ApplicationUser;

@Service
public class AdminServiceImpl implements AdminService {

	// inject the CustomerDAO
	@Autowired
	private AdminDAO adminDAO;

	@Override
	@Transactional
	public void createUser(ApplicationUser appUser) {
		adminDAO.createUser(appUser);
	}

	@Override
	@Transactional
	public void deleteUser(int id) {
		adminDAO.deleteUser(id);

	}

	@Override
	@Transactional
	public void modifyUser(int id) {
		adminDAO.modifyUser(id);
	}

	@Override
	@Transactional
	public ApplicationUser getUser(int id) {
		return adminDAO.getUser(id);
	}

}
