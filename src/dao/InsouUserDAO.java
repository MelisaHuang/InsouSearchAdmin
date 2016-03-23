package dao;

import java.sql.*;
import java.util.HashMap;


import entity.InsouUser;

public class InsouUserDAO {
	
	 // 得到所有用户的列表
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
	//得到搜索用户列表，标记是通过用户名还是角色来搜索
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
				if(k.equals("0"))//通过用户名搜索
					sql = "select * from insouuser where iu_name=('" + str + "')";
				if(k.equals("1"))//通过邮箱搜索
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
	
   //增加用户,定义函数返回值为int，出现异常时利于分析是在哪一步出错
	public int addUser(InsouUser newUser) {
		int result = 0; //初始
		if (findUser(newUser)) {
			result = 1; //检查所增加用户的用户名是否已经存在，若存在返回1
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
				result = 2; //完成add操作后返回2
			}
		}
		return result;
	}
   //查找用户(通过用户)
	public boolean findUser(InsouUser user) {
		boolean result = false;
		String sql = "select * from insouuser where iu_name=('" //通过用户名来查找记录是否存在
				+ user.getUsername() + "')";
		result = ConnectionManager.hasRecord(sql);
		return result;
	}
	
	//查找用户(通过用户名)
		public boolean findUserName(String username){
			boolean result = false;
			String sql = "select * from insouuser where iu_name=('" //通过用户名来查找记录是否存在
					+ username + "')";
			result = ConnectionManager.hasRecord(sql);
			return result;
		} 
	
   //删除用户
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
   
	//修改用户
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
   //验证用户
	public int verifyUser(String username, String password) {
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
			String sql = "select * from insouuser where iu_name='" + username
					+ "' and iu_password='" + password + "'";
			stmt = conn.prepareStatement(sql);
			rset = stmt.executeQuery();
			if (rset.next()) {
				result=1;
				if(result==1)
					System.out.println("验证成功！");
				uresult = rset.getString("iu_name");
				System.out.println("username: " + uresult);
			}
			else
			{
				result=2;
				System.out.println("验证失败！");
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
