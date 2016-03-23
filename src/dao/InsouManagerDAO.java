package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import entity.*;

public class InsouManagerDAO {
	// �õ������û����б�
		private HashMap<String, InsouManager> userList;
		public HashMap getManagerList() {
			HashMap userList = new HashMap();
			Connection conn = null;
			Statement stmt = null;
			ResultSet rset = null;
			InsouManager manager = null;
			try {
				conn = ConnectionManager.getConnection();
				String sql = "select * from adminuser";//����Ա��
				stmt = conn.createStatement();
				rset = stmt.executeQuery(sql);
				while (rset.next()) {
					manager = new InsouManager(
							rset.getString("au_name"), 
							rset.getString("au_password"),
							rset.getInt("r_id")
							);
					
					userList.put(rset.getString("au_name"), manager);
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
		public HashMap getsearchManagerList(String str,String k) {
			HashMap userList = new HashMap();
			Connection conn = null;
			Statement stmt = null;
			ResultSet rset = null;
			InsouManager manager = null;
			int roleId = 0;
			
			try {
				conn = ConnectionManager.getConnection();	
				String sql = null;
				if(k.equals("0"))//ͨ���û�������
					sql = "select * from adminuser where au_name=('" + str + "')";
				if(k.equals("1"))//ͨ����ɫ����
				{
					if(str.equals("������Ա"))
						roleId = 1;
					else if(str.equals("������Ա"))
						roleId = 2;
					sql = "select * from adminuser where r_id = (" + roleId + ")";
				}
				
				stmt = conn.createStatement();
				rset = stmt.executeQuery(sql);
				while (rset.next()) {
					manager = new InsouManager(
							rset.getString("au_name"), 
							rset.getString("au_password"),
							rset.getInt("r_id")
							);
					userList.put(rset.getString("au_name"), manager);
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
		public int addManager(InsouManager newManager) {
			int result = 0; //��ʼ
			if (findManager(newManager)) {
				result = 1; //����������û����û����Ƿ��Ѿ����ڣ������ڷ���1
			} 
			else {
				String sql = "insert into adminuser(au_name,au_password,r_id)values('"
						+ newManager.getName()
						+ "','"
						+ newManager.getPassword()
						+ "','"
						+ newManager.getRoleId()
					    + "')";

				if (ConnectionManager.update(sql)) {
					result = 2; //���add�����󷵻�2
				}
			}
			return result;
		}
	   //�����û�(ͨ���û�)
		public boolean findManager(InsouManager manager) {
			boolean result = false;
			String sql = "select * from adminuser where au_name=('" //ͨ���û��������Ҽ�¼�Ƿ����
					+ manager.getName() + "')";
			result = ConnectionManager.hasRecord(sql);
			return result;
		}
		
		//�����û�(ͨ���û���)
		public boolean findManagerName(String managername){
			boolean result = false;
			String sql = "select * from adminuser where au_name=('" //ͨ���û��������Ҽ�¼�Ƿ����
					+ managername + "')";
			result = ConnectionManager.hasRecord(sql);
			return result;
		}
		 
		
	   //ɾ���û�
		public boolean deleteManager(String managername) {
			boolean result = false;
			String sql = "delete from adminuser where au_name=('" + managername
					+ "')";
			result = ConnectionManager.delete(sql);
			System.out.println("delete manager:" + sql);
			return result;
		}
	   
		
		public InsouManager getManager(String managername) {
			String sql = "select * from adminuser where au_name=('" + managername
					+ "')";
			InsouManager manager = null;
			Connection conn = null;
			Statement stmt = null;
			ResultSet rset = null;

			try {
				conn = ConnectionManager.getConnection();
				stmt = conn.createStatement();
				rset = stmt.executeQuery(sql);
				int i = 0;
				while (rset.next()) {
					manager = new InsouManager(
							rset.getString("au_name"), 
							rset.getString("au_password"),
							rset.getInt("r_id")
							);
				}

			} catch (SQLException e) {
				e.printStackTrace();

			} finally {
				ConnectionManager.closeConnection(conn, stmt, rset);
			}
			return manager;
		}
	   
		//�޸��û�
		public int editManager(InsouManager manager) {
			int result = 1;
			String sql = "update adminuser set "
					+ "au_name ='"
			        + manager.getName()
					+ "',r_id='"
			        + manager.getRoleId()
			        + "' " 
					+"where au_name=('"
					+ manager.getName() 
					+ "')";
			System.out.println("edit manager:" + sql);
			if (ConnectionManager.update(sql)) {
				result = 2; 
			}

			return result;
		}
	   //��֤�û�
		public int verifyManager(String managername, String password) {
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
				String sql = "select * from adminuser where au_name='" + managername
						+ "' and au_password='" + password + "'";
				stmt = conn.prepareStatement(sql);
				rset = stmt.executeQuery();
				if (rset.next()) {
					result=1;
					if(result==1)
						System.out.println("��֤�ɹ���");
					uresult = rset.getString("au_name");
					System.out.println("managername: " + uresult);
				}
				else
				{
					result=2;
					System.out.println("��֤ʧ�ܣ�");
				}
				
			} 
			catch (SQLException e) {
				System.out.println("SQLException inside verify manager");
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
