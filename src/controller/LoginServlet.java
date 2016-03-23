package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import serviceImp.InsouManagerServImp;

public class LoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
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

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		System.out.println("要验证用户=" + username);
		//System.out.println("password=" + password);
		InsouManagerServImp userMgr = new InsouManagerServImp();
		int result = 2;
		result = userMgr.verifyManager(username, password);
		switch (result) { 
		
		case 1://通过验证
			//PrintWriter t= response.getWriter();
			//t.println("<script> alert('登录成功！');</script>");
			
			request.getRequestDispatcher("/admin-firstPage.jsp").forward(request, response);
		
			/*
			 PrintWriter t= response.getWriter();
			t.println("<script> alert('登录成功！');</script>");
			*/
			break;
		case 2 :
		PrintWriter out = response.getWriter();
		out.println("<script> alert('登录不成功');</script>");
		request.getRequestDispatcher("../index.jsp").forward(request, response);
		/*
		case 0://未进行操作
			PrintWriter ou = response.getWriter();
			ou.println("<script> alert('未进行操作script>");
			break;
		case 2://未通过验证
			//request.getRequestDispatcher("unpass.jsp").forward(request, response);
			PrintWriter out = response.getWriter();
			out.println("<script> alert('登录不成功');</script>");
			break;
		*/
		}	
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

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
