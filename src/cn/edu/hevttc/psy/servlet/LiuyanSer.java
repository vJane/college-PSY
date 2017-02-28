package cn.edu.hevttc.psy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.hevttc.psy.dao.MsgDao;

public class LiuyanSer extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LiuyanSer() {
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

		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();	
		String message=null;
		String name=request.getParameter("name");
		String note=request.getParameter("note");
		String tel=request.getParameter("tel");
		String email=request.getParameter("email");
		
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String date = dateFormat.format(now); 
		if(note==null || note.equals("")){
			message="¡Ù—‘ƒ⁄»›≤ªƒ‹Œ™ø’£°";
		}else{
	        String sql="insert into liuyan (name,email,tel,note,date)"
	        		+ "values('"+name+"','"+email+"','"+tel+"','"+note+"','"+date+"')";
	        MsgDao msg = new MsgDao();
	        if(msg.insertMessages(sql)){
	        	message="¡Ù—‘≥…π¶£°";
	        }else{
	        	message="¡Ù—‘ ß∞‹£°";
	        }
		}
		session.setAttribute("message3", message);
		response.sendRedirect("contact.jsp");
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

		doGet(request,response);
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
