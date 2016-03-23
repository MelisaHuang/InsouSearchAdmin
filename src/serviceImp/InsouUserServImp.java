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
	  ��֤�û�������0��ʾδִ�в���������1��ʾͨ����֤������2��ʾδͨ����֤
	**/
	public int verifyUser(String username, String password) {
		return userDao.verifyUser(username, password);
	}

	/**
	 * �����û���δ��������0����������1���ɹ�����2
	 */
	public int addUser(InsouUser newUser) {
		return userDao.addUser(newUser);
	}

	/**
	 * ɾ���û����ɹ�����true��ʧ�ܷ���false
	 */
	public boolean deleteUser(String username) {
		return userDao.deleteUser(username);
	}

	/**
	 * �����û����ɹ�Ϊtrue,ʧ��Ϊfalse
	 */
	public boolean findUser(InsouUser user) {	
		return userDao.findUser(user);
	}

	/**
	 * �༭�޸��û����ɹ�����2��ʧ�ܷ���1
	 */
	public int editUser(InsouUser user) {
		return userDao.editUser(user);
	}
	
    /**
     * �����û��б�
     */
	public HashMap getUserList() {	
		return userDao.getUserList();
	}

	 /**
     * ͨ���û��������������û��б�
     */	
	public HashMap getsearchUserList(String str,String k) {		
		return userDao.getsearchUserList(str,k);
	}

	
	public InsouUser getUser(String username) {
		return userDao.getUser(username);
	}

	


	
}