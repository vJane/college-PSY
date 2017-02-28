package cn.edu.hevttc.psy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.hevttc.psy.bean.Admin;
import cn.edu.hevttc.psy.bean.Question;
import cn.edu.hevttc.psy.bean.Student;
import cn.edu.hevttc.psy.dao.StudentDAO;
import cn.edu.hevttc.psy.dao.UploadDAO;
import cn.edu.hevttc.psy.util.FileUtil;
import cn.edu.hevttc.psy.util.Page;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class AddStudentSer extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddStudentSer() {
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
            int su=0;
            System.out.println(1);
			SmartUpload mySmartUpload = new SmartUpload();  
	        try {
		        mySmartUpload.initialize(this.getServletConfig(),request,response);
				mySmartUpload.upload();
				mySmartUpload.save("/uploadFiles/");
			} catch (SmartUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        String fileName = mySmartUpload.getFiles().getFile(0).getFileName();
	        System.out.println(fileName);
	        if(fileName==null||fileName.equals("")){
	        	session.setAttribute("message6","文件不能为空！");
	        }
	        else{
	        	System.out.println(2);
	        ServletContext application=this.getServletContext();   
	        FileUtil fileUtil = new FileUtil();
	        String filePath=application.getRealPath("/uploadFiles/"+fileName);  
	        List<Student> list=fileUtil.getStudent(filePath);
	        for(int i=0;i<list.size();i++){
	        	String name=list.get(i).getName();
	        	String studentID=list.get(i).getStudentID();
	        	String sex=list.get(i).getSex();
	        	String dept=list.get(i).getDept();
	        	String major=list.get(i).getMajor();
	        	String tutor=list.get(i).getTutor();
	        	int year=list.get(i).getYear();
	        	int grade=list.get(i).getGrade();
	        	String phone=list.get(i).getPhone();
	        	 sql="insert into student(name,studentID,sex,dept,major,tutor,year,grade,phone)"
	        	 		+ "values('"+name+"','"+studentID+"','"+sex+"','"+dept+"','"+major+"','"+tutor+"','"+year+"','"+grade+"','"+phone+"')";
	        	//System.out.println(sql);
	        	 if(StudentDAO.updateStudent(sql)){
	        		 su++;
	        	 }
	        }
	        int sheng=list.size()-su;
	        session.setAttribute("message6","共上传成功"+su+"条记录,上传失败"+sheng+"条记录");
	    
	        Admin admin=(Admin)session.getAttribute("admin");
			String tutor=admin.getName();
			if(admin.getType()==2){
				sql="select * from student where tutor='"+tutor+"' and del=1";
			}else{
				sql="select * from student where del=1";
			}
			//System.out.println(sql);
			List<Student> list1 =StudentDAO.find(sql);
			//System.out.println(sql);
			session.setAttribute("studentList", list1);
			if(list.size()>0){
			    List<Student> list2 =new ArrayList<Student>();
				Page page = new Page();
				if(list.size()<10) page.setPageSize(3);
				else page.setPageSize(10);
				page.setRecordCount(list.size());
				page.setCurrPageNo(1);
				page.setTotalPageCountByRs();
				for(int i=page.getStartRow()-1;i<page.getEndRow();i++){
					list2.add(list1.get(i));
				}
				session.setAttribute("pageSize",page.getPageSize());
				session.setAttribute("totalPage",page.getTotalPageCount());
				session.setAttribute("currentPage",page.getCurrPageNo());
				//System.out.println(page.getPageSize()+"---"+page.getTotalPageCount()+"---"+page.getCurrPageNo());
				session.setAttribute("studentList",list2);
				}
	        }
	        response.sendRedirect("student.jsp");
		       
		
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
