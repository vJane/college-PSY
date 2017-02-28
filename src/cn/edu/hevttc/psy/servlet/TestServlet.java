package cn.edu.hevttc.psy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.hevttc.psy.bean.ExamInfo;
import cn.edu.hevttc.psy.bean.Question;
import cn.edu.hevttc.psy.dao.ExamDAO;
import cn.edu.hevttc.psy.util.Page;

public class TestServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public TestServlet() {
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
		long startTime;
		long nowTime;
		long spendTime;
		int minutes;
		int seconds;
		if("开始测试".equals(request.getParameter("submit"))){
			startTime=System.currentTimeMillis();
			Date now = new Date(); 
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String startDate = dateFormat.format(now); 
			session.setAttribute("startDate",startDate);
			session.setAttribute("startTime", startTime);
			List<Question> question=(List<Question>)session.getAttribute("question");
			String tableName=question.get(0).getTableName();
			ExamDAO eDAO = new ExamDAO();
			List<Question> exam = eDAO.findExam(tableName);
			Page page = new Page();
			page.setPageSize(1);
			page.setRecordCount(exam.size());
			page.setCurrPageNo(0);
			List<Question> questionList = new ArrayList<Question>();
			for(int i=0 ;i<page.getPageSize();i++){
				questionList.add(exam.get(page.getCurrPageNo()-1));
				page.setCurrPageNo(page.getCurrPageNo()+1);
			}
			Map<Integer,String> hashMap = new HashMap<Integer,String>();
			session.setAttribute("hashMap",hashMap);
			
			session.setAttribute("studentAnswer",new ArrayList<String>());
			session.setAttribute("exam",exam);
			session.setAttribute("examPage",page);
			session.setAttribute("question",questionList);
			response.sendRedirect("test.jsp");
		}else if("下一题".equals(request.getParameter("submit"))){
			startTime=(Long)session.getAttribute("startTime");
			nowTime=System.currentTimeMillis();
			spendTime=(long)nowTime-(long)startTime;
			minutes=(int)spendTime/1000/60;
		    seconds=(int)(spendTime/1000-minutes*60);
			session.setAttribute("minutes",minutes);
			session.setAttribute("seconds", seconds);
			Page page=(Page)session.getAttribute("examPage");
			Map<Integer,String> hashMap =(HashMap<Integer,String>)session.getAttribute("hashMap");
			String answer = request.getParameter("radio");
//			if(answer==null || answer.equals("")){
//				answer="1";
//			}
			String eType=request.getParameter("eType");
			//System.out.println(eType);
			if(eType.equals("1") && (answer==null || answer.equals(""))){
				session.setAttribute("error2","请选择一个答案！");
				response.sendRedirect("test.jsp");
				
			}else{
			
			if(eType.equals("1")){
				answer=(char)(Integer.parseInt(answer)+65)+"";
			}
			hashMap.put(page.getCurrPageNo()-1,answer);
			session.setAttribute("hashMap",hashMap);			
			List<Question> exam=(List<Question>)session.getAttribute("exam");
			List<Question> questionList = new ArrayList<Question>();
			for(int i=0 ;i<page.getPageSize() ;i++){
				questionList.add(exam.get(page.getCurrPageNo()-1));
				page.setCurrPageNo(page.getCurrPageNo()+1);
			}
			session.setAttribute("exam",exam);
			session.setAttribute("examPage",page);
			session.setAttribute("question",questionList);
			response.sendRedirect("test.jsp");
			}
		}else if("完成答题".equals(request.getParameter("submit"))){
			Date now = new Date(); 
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String endDate = dateFormat.format(now); 
			dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	        session.setAttribute("resultDate",dateFormat.format(now));
			session.setAttribute("endDate",endDate);
			Page page=(Page)session.getAttribute("examPage");
			Map<Integer,String> hashMap =(HashMap<Integer,String>)session.getAttribute("hashMap");
			String answer = request.getParameter("radio");
//			if(answer==null || answer.equals("")){
//				answer="1";
//			}
			String eType=request.getParameter("eType");
			if(eType.equals("1") && (answer==null || answer.equals(""))){
				session.setAttribute("error2","请选择一个答案！");
				response.sendRedirect("test.jsp");
				
			}else{
			if(eType.equals("1")){
				answer=(char)(Integer.parseInt(answer)+65)+"";
			}
			hashMap.put(page.getCurrPageNo()-1,answer);
			session.setAttribute("hashMap",hashMap);
			
			String tableName=((List<Question>)(session.getAttribute("exam"))).get(0).getTableName();
			String servletName=tableName+"Servlet";
			//System.out.println(servletName);
			response.sendRedirect(servletName);
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
