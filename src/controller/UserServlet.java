package controller;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.*;
import serviceImp.*;


public class UserServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		processRequest(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request,response);
		
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String operation = request.getParameter("operation");
		String username = request.getParameter("username");	
		
		HttpSession session = request.getSession();		
		InsouUserServImp userMgr = new InsouUserServImp();
		if(operation.equals("del")){
			if(userMgr.deleteUser(username)){
				request.getRequestDispatcher("/admin-sys-generalUser.jsp").forward(request, response);
			}
			else{
				PrintWriter out = response.getWriter();
				out.println("<script> alert('删除不成功');</script>");
			}
		}
		if(operation.equals("add")){
			
			
			String password = request.getParameter("password");

			String email = request.getParameter("email");
			//设置构造函数的参数
			InsouUser user = new InsouUser(username,password,18,"学生",email);
			if(userMgr.addUser(user) ==2){
				request.getRequestDispatcher("/admin-sys-generalUser.jsp").forward(request, response);
			}
			else if(userMgr.addUser(user) ==1){
				PrintWriter out = response.getWriter();
				request.getRequestDispatcher("/admin-sys-user-generalUser-add.jsp").forward(request, response);
			}
		}
		if(operation.equals("edit")){
			System.out.println("username=" + username);


			String ed_password = request.getParameter("password");

			String ed_email = request.getParameter("email");
			InsouUser user = new InsouUser(username,ed_password,18,"学生",ed_email);
			//改成了无参 username,"888888",realname,Integer.parseInt(userType),Integer.parseInt(sex)
			if(userMgr.editUser(user) ==2){
				request.getRequestDispatcher("/admin-sys-generalUser.jsp").forward(request, response);
			}
			else if(userMgr.addUser(user) ==1){
				PrintWriter out = response.getWriter();
				request.getRequestDispatcher("/admin-sys-user-generalUser-edit.jsp?username=" + username).forward(request, response);
			}
		}
		if(operation.equals("search")){
			String searchType = request.getParameter("searchType");
			String searchInput = request.getParameter("searchInput");
			System.out.println(searchType);
			System.out.println(searchInput);
			request.getRequestDispatcher("/admin-sys-user-generalUser-Search.jsp").forward(request, response);
		}
	}
}