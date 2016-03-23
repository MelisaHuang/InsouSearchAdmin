package dao;

import java.sql.*;
import java.util.HashMap;


import entity.InsouUser;

public class InsouUserDAO {
	
	 // �õ������û����б�
	private HashMap<String, InsouUser> userList;
	public HashMap getUserList() {
		HashMap userList = new HashMap();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		InsouUser user = null;
		try {
			conn = ConnectionManager.getConnection();
			String sql = "select * from insouuser";
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			while (rset.next()) {
				user = new InsouUser(
						rset.getString("iu_name"), 
						rset.getString("iu_password"),

						rset.getInt("iu_age"),
						rset.getString("iu_job"),
						rset.getString("iu_email")
						);
				
				userList.put(rset.getString("iu_name"), user);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return userList;
	}
	//�õ������û��б������ͨ���û������ǽ�ɫ������
		public HashMap getsearchUserList(String str,String k){
		HashMap userList = new HashMap();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		InsouUser user = null;
		
		double i=0;
	try {
				conn = ConnectionManager.getConnection();	
				String sql = null;
				if(k.equals("0"))//ͨ���û�������
					sql = "select * from insouuser where iu_name=('" + str + "')";
				if(k.equals("1"))//ͨ����������
					sql = "select * from insouuser where iu_email =('" + str + "')";
			
				stmt = conn.createStatement();
				rset = stmt.executeQuery(sql);
			while (rset.next()) {
						user = new InsouUser(
						rset.getString("iu_name"), 
						rset.getString("iu_password"),
						
						rset.getInt("iu_age"),
						rset.getString("iu_job"),
						rset.getString("iu_email")
						);
				userList.put(rset.getString("iu_name"), user);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return userList;
	}
	
   //�����û�,���庯������ֵΪint�������쳣ʱ���ڷ���������һ������
	public int addUser(InsouUser newUser) {
		int result = 0; //��ʼ
		if (findUser(newUser)) {
			result = 1; //����������û����û����Ƿ��Ѿ����ڣ������ڷ���1
		} 
		else {
			String sql = "insert into insouuser(iu_name,iu_password,iu_age,iu_job,iu_email)values('"
					+ newUser.getUsername()
					+ "','"
					+ newUser.getPassword()
					+ "','"
					
					+ newUser.getAge()
					+ "','" 
					+ newUser.getJob()
					+ "','"
					+ newUser.getEmail()
				    + "')";

			if (ConnectionManager.update(sql)) {
				result = 2; //���add�����󷵻�2
			}
		}
		return result;
	}
   //�����û�(ͨ���û�)
	public boolean findUser(InsouUser user) {
		boolean result = false;
		String sql = "select * from insouuser where iu_name=('" //ͨ���û��������Ҽ�¼�Ƿ����
				+ user.getUsername() + "')";
		result = ConnectionManager.hasRecord(sql);
		return result;
	}
	
	//�����û�(ͨ���û���)
		public boolean findUserName(String username){
			boolean result = false;
			String sql = "select * from insouuser where iu_name=('" //ͨ���û��������Ҽ�¼�Ƿ����
					+ username + "')";
			result = ConnectionManager.hasRecord(sql);
			return result;
		} 
	
   //ɾ���û�
	public boolean deleteUser(String username) {
		boolean result = false;
		String sql = "delete from insouuser where iu_name=('" + username
				+ "')";
		result = ConnectionManager.delete(sql);
		System.out.println("delete user:" + sql);
		return result;
	}
   
	
	public InsouUser getUser(String username) {
		String sql = "select * from insouuser where iu_name=('" + username
				+ "')";
		InsouUser user = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		try {
			conn = ConnectionManager.getConnection();
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			int i = 0;
			while (rset.next()) {
				user = new InsouUser(
						rset.getString("iu_name"), 
						rset.getString("iu_password"),
					
						rset.getInt("iu_age"),
						rset.getString("iu_job"),
						rset.getString("iu_email")
						);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			ConnectionManager.closeConnection(conn, stmt, rset);
		}
		return user;
	}
   
	//�޸��û�
	public int editUser(InsouUser user) {
		int result = 1;
		String sql = "update insouuser set "
				+ "iu_name ='" 
				+ user.getUsername()
			    + "',iu_password ='" 
				+ user.getPassword()
				+ "',iu_age=' "
				+ user.getAge()
				+ "',iu_job='"
				+ user.getJob()
				+ "',iu_email='"
				+ user.getEmail()
				+ "' " 
				+"where iu_name=('"
				+ user.getUsername() + "')";
		System.out.println("edit user:" + sql);
		if (ConnectionManager.update(sql)) {
			result = 2; 
		}

		return result;
	}
   //��֤�û�
	public int verifyUser(String username, String password) {
		Connection conn = null;
		PreparedStatement stmt = null;
		/*
		 * 
		 PreparedStatement ���� �� �ڲ�ͬ�Ĳ��� ʱ�� �� ���ѯ �� �߼��� ����  
�� ��֤ �� �� �Ƿ���ڵ� SQL�� �� Ϊ ��  
select count(*) from usertable where name='�� �� �� ' and pswd='�� �� '
����� �� �� ���ֶ� �� �� �� ' or '1'='1' or '1'='1
������ �� �� �ֶ� �� �� �� 1' or '1'='1
�� �ƹ���֤ ���� ���� �ֶ�ֻ �� ֻ �� Statement��Ч�� �� PreparedStatement ��Ч��  
		 * 
		 */
		ResultSet rset = null;
		int result = 0;
		String uresult = null;
		try {
			conn = ConnectionManager.getConnection();
			String sql = "select * from insouuser where iu_name='" + username
					+ "' and iu_password='" + password + "'";
			stmt = conn.prepareStatement(sql);
			rset = stmt.executeQuery();
			if (rset.next()) {
				result=1;
				if(result==1)
					System.out.println("��֤�ɹ���");
				uresult = rset.getString("iu_name");
				System.out.println("username: " + uresult);
			}
			else
			{
				result=2;
				System.out.println("��֤ʧ�ܣ�");
			}
			
		} 
		catch (SQLException e) {
			System.out.println("SQLException inside verify user");
			e.printStackTrace();
			result = 2;
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
}
