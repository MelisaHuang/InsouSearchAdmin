package serviceImp;
import java.sql.*;
import java.util.HashMap;

import service.InsouManagerService;
import service.InsouUserService;
import dao.*;
import entity.InsouManager;

public class InsouManagerServImp implements InsouManagerService {

	public InsouManagerServImp() {
		super();
	}
	private InsouManagerDAO managerDao = new InsouManagerDAO();
	
	
	
	public int verifyManager(String managername, String password) {
		return managerDao.verifyManager(managername, password);
	}

	
	public int addManager(InsouManager newManager) {
		return managerDao.addManager(newManager);
	}

	
	public boolean deleteManager(String managername) {		
		return managerDao.deleteManager(managername);
	}

	
	public boolean findManager(InsouManager manager) {
		return managerDao.findManager(manager);
	}

	
	public int editManager(InsouManager manager) {
		return managerDao.editManager(manager);
	}

	
	public HashMap getManagerList() {
		return managerDao.getManagerList();
	}

	
	public HashMap getsearchManagerList(String str,String k) {		
		return managerDao.getsearchManagerList(str,k);
	}



	public InsouManager getManager(String managername) {
		return managerDao.getManager(managername);
	}
	
			

}
