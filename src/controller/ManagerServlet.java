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


public class ManagerServlet extends HttpServlet  {
	/**
	 * Constructor of the object.
	 */
	public ManagerServlet() {
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
		String managername = request.getParameter("managername");	
		

		HttpSession session = request.getSession();		
		InsouManagerServImp userMgr = new InsouManagerServImp();
		if(operation.equals("del")){
			if(userMgr.deleteManager(managername)){
				request.getRequestDispatcher("/admin-sys-user-modify.jsp").forward(request, response);
			}
			else{
				PrintWriter out = response.getWriter();
				out.println("<script> alert('删除不成功');</script>");
			}
		}
		if(operation.equals("add")){
			String password = request.getParameter("password");
		    String role = request.getParameter("role");
			System.out.println("role=" + role);
			//设置构造函数的参数
			InsouManager user = new InsouManager(managername,password,Integer.parseInt(role));
			if(userMgr.addManager(user) == 2){
				request.getRequestDispatcher("/admin-sys-user-modify.jsp").forward(request, response);
			}
			else if(userMgr.addManager(user) == 1){
				PrintWriter out = response.getWriter();
				request.getRequestDispatcher("/admin-sys-user-add.jsp").forward(request, response);
			}
		}
		if(operation.equals("edit")){
			String password = request.getParameter("password");
		    String role = request.getParameter("role");
			System.out.println("managername=" + managername);
			InsouManager user = new InsouManager(managername,password,Integer.parseInt(role));
			if(userMgr.editManager(user) == 2){
				request.getRequestDispatcher("/admin-sys-user-modify.jsp").forward(request, response);
			}
			else if(userMgr.editManager(user) == 1){
				PrintWriter out = response.getWriter();
				request.getRequestDispatcher("/admin-sys-user-edit?managername=" + managername).forward(request, response);
			}
		}
		if(operation.equals("search")){
			String searchType = request.getParameter("searchType");
			String searchInput = request.getParameter("searchInput");
			System.out.println(searchType);
			System.out.println(searchInput);
			request.getRequestDispatcher("/admin-sys-user-search.jsp").forward(request, response);
		}
	}
}
