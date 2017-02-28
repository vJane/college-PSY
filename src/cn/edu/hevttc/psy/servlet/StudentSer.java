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

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import cn.edu.hevttc.psy.bean.Admin;
import cn.edu.hevttc.psy.bean.Student;
import cn.edu.hevttc.psy.dao.StudentDAO;
import cn.edu.hevttc.psy.util.Page;

public class StudentSer extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public StudentSer() {
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
		String sql;
		int tiaozhuan=0;
		//删除学生信息
		if(request.getParameter("tz").equals("1")){
			String studentID=request.getParameter("studentID");
			sql="update student set del=0 where studentID='"+studentID+"' and del=1";
			//System.out.println(sql);
			if(StudentDAO.updateStudent(sql)){
				session.setAttribute("message7", "删除成功！");
			}
		}
		if(request.getParameter("tz").equals("3")){
			String name=request.getParameter("Sname");
			String studentID=request.getParameter("studentID");
		    String studentID1=request.getParameter("studentID1");
			String sex=request.getParameter("sex");
			String dept=request.getParameter("dept");
			String major=request.getParameter("major");
			String tutor=request.getParameter("tutor");
			String year=request.getParameter("year");
			String grade=request.getParameter("grade");
			String phone=request.getParameter("phone");
			sql="update student set name='"+name+"',"
					+ "studentID='"+studentID1+"', sex='"+sex+"',"
							+ "dept='"+dept+"',major='"+major+"',"
									+ "tutor='"+tutor+"',year='"+year+"',grade='"+grade+"',phone='"+phone+"'"
											+ " where studentID='"+studentID+"'";
			//System.out.println(sql);
			if(StudentDAO.updateStudent(sql)){
				session.setAttribute("message7", ""+name+"的信息修改成功！");
			}
		}
		//查询要修改的学生信息
		if(request.getParameter("tz").equals("2")){
			String studentID=request.getParameter("studentID");
			sql="select * from student where studentID='"+studentID+"'";
			//System.out.println(sql);
			List<Student> list1 =StudentDAO.find(sql);
			session.setAttribute("studentList1", list1);	
			tiaozhuan=1;
			response.sendRedirect("alertStudent.jsp");
		}
		 if(request.getParameter("tz").equals("4")){
 	        try {
     	        SmartUpload mySmartUpload = new SmartUpload();       
     	        mySmartUpload.initialize(this.getServletConfig(),request,response);
     	        request.setCharacterEncoding("utf-8");
     	        mySmartUpload.setContentDisposition(null);
					mySmartUpload.downloadFile("/muban/student模板.xls");
				} catch (SmartUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 	        tiaozhuan=1;
		    }
		 if(request.getParameter("tz").equals("5")){
				String studentID=request.getParameter("chaxun");
				sql="select * from student where studentID like '%"+studentID+"%'";
				//System.out.println(sql);
				List<Student> list1 =StudentDAO.find(sql);
				session.setAttribute("studentList",list1);	
				session.setAttribute("pageSize",1);
				session.setAttribute("totalPage",1);
				session.setAttribute("currentPage",1);
				tiaozhuan=1;
				response.sendRedirect("student.jsp");
			}
		if(request.getParameter("tz").equals("0")||tiaozhuan==0){
			Admin admin=(Admin)session.getAttribute("admin");
			String tutor=admin.getName();
			if(admin.getType()==2){
				sql="select * from student where tutor='"+tutor+"' and del=1";
			}else{
				sql="select * from student where del=1";
			}
			//System.out.println(sql);
			List<Student> list =StudentDAO.find(sql);
			if(list.size()>0){
			    List<Student> list1 =new ArrayList<Student>();
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
				session.setAttribute("currentPage", page.getCurrPageNo());
				session.setAttribute("studentList",list1);
			}else{
				session.setAttribute("studentList",null);
			}
			response.sendRedirect("student.jsp");
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
