package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import entity.*;

public class InsouManagerDAO {
	// 得到所有用户的列表
		private HashMap<String, InsouManager> userList;
		public HashMap getManagerList() {
			HashMap userList = new HashMap();
			Connection conn = null;
			Statement stmt = null;
			ResultSet rset = null;
			InsouManager manager = null;
			try {
				conn = ConnectionManager.getConnection();
				String sql = "select * from adminuser";//管理员表
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
		//得到搜索用户列表，标记是通过用户名还是角色来搜索
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
				if(k.equals("0"))//通过用户名搜索
					sql = "select * from adminuser where au_name=('" + str + "')";
				if(k.equals("1"))//通过角色搜索
				{
					if(str.equals("管理人员"))
						roleId = 1;
					else if(str.equals("开发人员"))
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
	
		
	   //增加用户,定义函数返回值为int，出现异常时利于分析是在哪一步出错
		public int addManager(InsouManager newManager) {
			int result = 0; //初始
			if (findManager(newManager)) {
				result = 1; //检查所增加用户的用户名是否已经存在，若存在返回1
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
					result = 2; //完成add操作后返回2
				}
			}
			return result;
		}
	   //查找用户(通过用户)
		public boolean findManager(InsouManager manager) {
			boolean result = false;
			String sql = "select * from adminuser where au_name=('" //通过用户名来查找记录是否存在
					+ manager.getName() + "')";
			result = ConnectionManager.hasRecord(sql);
			return result;
		}
		
		//查找用户(通过用户名)
		public boolean findManagerName(String managername){
			boolean result = false;
			String sql = "select * from adminuser where au_name=('" //通过用户名来查找记录是否存在
					+ managername + "')";
			result = ConnectionManager.hasRecord(sql);
			return result;
		}
		 
		
	   //删除用户
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
	   
		//修改用户
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
	   //验证用户
		public int verifyManager(String managername, String password) {
			Connection conn = null;
			PreparedStatement stmt = null;
			/*
			 * 
			 PreparedStatement 不允 许 在不同的插入 时间 改 变查询 的 逻辑结 构。  
	如 验证 用 户 是否存在的 SQL语 句 为 ：  
	select count(*) from usertable where name='用 户 名 ' and pswd='密 码 '
	如果在 用 户 名字段 中 输 入 ' or '1'='1' or '1'='1
	或是在 密 码 字段 中 输 入 1' or '1'='1
	将 绕过验证 ，但 这种 手段只 对 只 对 Statement有效， 对 PreparedStatement 无效。  
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
						System.out.println("验证成功！");
					uresult = rset.getString("au_name");
					System.out.println("managername: " + uresult);
				}
				else
				{
					result=2;
					System.out.println("验证失败！");
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
