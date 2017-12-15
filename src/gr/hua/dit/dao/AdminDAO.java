package gr.hua.dit.dao;

import gr.hua.dit.entity.ApplicationUser;

public interface AdminDAO {
	public void createUser(ApplicationUser appUser);

	public void deleteUser(int id);

	public void modifyUser(int id);

	public ApplicationUser getUser(int id);
}
