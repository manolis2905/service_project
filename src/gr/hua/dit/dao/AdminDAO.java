package gr.hua.dit.dao;

import javax.servlet.http.HttpServletRequest;

public interface AdminDAO {
	public void createUser(HttpServletRequest request);
	public void deleteUser(HttpServletRequest request);
	public void modifyUser(HttpServletRequest request);
}
