package cn.edu.hevttc.psy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.hevttc.psy.bean.Admin;
import cn.edu.hevttc.psy.bean.ExamInfo;
import cn.edu.hevttc.psy.dao.AdminDAO;
import cn.edu.hevttc.psy.dao.ExamInfoDAO;
import cn.edu.hevttc.psy.util.Page;

public class ExamSer extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ExamSer() {
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
		String pageNo=request.getParameter("pageNo");
		String ez=request.getParameter("ez");
		int tiaozhuan=0;
		if(ez.equals("1")){
			String tableName=request.getParameter("tableName");
			String sql="select * from examinfo where tableName='"+tableName+"'";
			//System.out.println(sql);
			ExamInfoDAO examinfo=new ExamInfoDAO();
			List<ExamInfo> list=examinfo.find(sql);
			session.setAttribute("examDetail", list);
			tiaozhuan=1;
			response.sendRedirect("examDetail.jsp");
		}
		if(ez.equals("0")||tiaozhuan==0){
		    ExamInfoDAO eIDAO = new ExamInfoDAO();
			List<ExamInfo> list =eIDAO.find();
			if(list.size()>0){
				List<ExamInfo> list1 =new ArrayList<ExamInfo>();
				Page page = new Page();
				if(list.size()<10) page.setPageSize(list.size());
				else page.setPageSize(10);
				page.setRecordCount(list.size());
				page.setCurrPageNo(Integer.parseInt(pageNo));
				page.setTotalPageCountByRs();
				for(int i=page.getStartRow()-1;i<page.getEndRow();i++){
					list1.add(list.get(i));
				}
				session.setAttribute("pageSize", page.getPageSize());
				session.setAttribute("totalPage",page.getTotalPageCount());
				session.setAttribute("currentPage",page.getCurrPageNo());
				session.setAttribute("ExamInfoList", list1);
//				System.out.println(list1);
			}
			response.sendRedirect("examInfo.jsp");
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
