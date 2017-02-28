package cn.edu.hevttc.psy.servlet;

import java.io.IOException;
import java.util.*;

import cn.edu.hevttc.psy.bean.*;
import cn.edu.hevttc.psy.dao.*;
import cn.edu.hevttc.psy.util.Page;

import javax.servlet.ServletException;
import javax.servlet.http.*;
public class TitleServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public TitleServlet() {
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
		HttpSession session = request.getSession();
		String examListID=request.getParameter("examListID");
		//System.out.println(examListID);
		if(examListID!=null){
			List<ExamInfo> list=(List<ExamInfo>)session.getAttribute("examInfoS");
			String tableName=list.get(Integer.parseInt(examListID)).getTableName();	
			Question question = new Question();
			question.setId(0);
			question.setTableName(tableName);
			question.setType(0);
			question.setAnswer(null);
			question.setQuestionTitle(list.get(Integer.parseInt(examListID)).getNation());
			List<Question> questionList = new ArrayList<Question>();
			questionList.add(question);
			session.setAttribute("question",questionList);
			session.setAttribute("tableName",tableName);
			session.setAttribute("examName",list.get(Integer.parseInt(examListID)).getExamName());
			response.sendRedirect("test.jsp");
		}else{
			session.setAttribute("error","·Ç·¨Ìø×ª");
			response.sendRedirect("error.jsp");
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
