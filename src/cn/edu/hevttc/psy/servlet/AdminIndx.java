package cn.edu.hevttc.psy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.hevttc.psy.bean.Admin;
import cn.edu.hevttc.psy.bean.Student;
import cn.edu.hevttc.psy.dao.AdminDAO;
import cn.edu.hevttc.psy.dao.StudentDAO;

public class AdminIndx extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AdminIndx() {
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

		doPost(request,response);
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
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String sql;
		if("∫ÛÃ®µ«¬º".equals(request.getParameter("submit"))){
			String userid = request.getParameter("userid");
			String userpwd = request.getParameter("userpwd");
			Admin admin = new Admin();
			admin.setUser(userid);
			admin.setPwd(userpwd);
			AdminDAO aDao = new AdminDAO();
			admin=aDao.findAdmin(admin);
			if(admin!=null){
				session.setAttribute("admin", admin);
				response.sendRedirect("backstage.jsp");
			}else{
				session.setAttribute("back_error","’À∫≈ªÚ√‹¬Î¥ÌŒÛ"); ;
				response.sendRedirect("admin.jsp");
			}
		}else{
			session.invalidate();
			response.sendRedirect("index.jsp");
		}
		
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
