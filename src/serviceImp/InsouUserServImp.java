package serviceImp;

import java.sql.*;
import java.util.HashMap;

import service.InsouUserService;
import dao.*;
import entity.InsouUser;


public class InsouUserServImp implements InsouUserService
{
	
	public InsouUserServImp() {
		super();
	}
	private InsouUserDAO userDao = new InsouUserDAO();
	
	
	/**
	  验证用户。返回0表示未执行操作，返回1表示通过验证，返回2表示未通过验证
	**/
	public int verifyUser(String username, String password) {
		return userDao.verifyUser(username, password);
	}

	/**
	 * 增加用户，未操作返回0，重名返回1，成功返回2
	 */
	public int addUser(InsouUser newUser) {
		return userDao.addUser(newUser);
	}

	/**
	 * 删除用户，成功返回true，失败返回false
	 */
	public boolean deleteUser(String username) {
		return userDao.deleteUser(username);
	}

	/**
	 * 查找用户，成功为true,失败为false
	 */
	public boolean findUser(InsouUser user) {	
		return userDao.findUser(user);
	}

	/**
	 * 编辑修改用户，成功返回2，失败返回1
	 */
	public int editUser(InsouUser user) {
		return userDao.editUser(user);
	}
	
    /**
     * 返回用户列表
     */
	public HashMap getUserList() {	
		return userDao.getUserList();
	}

	 /**
     * 通过用户名，返回搜索用户列表
     */	
	public HashMap getsearchUserList(String str,String k) {		
		return userDao.getsearchUserList(str,k);
	}

	
	public InsouUser getUser(String username) {
		return userDao.getUser(username);
	}

	


	
}