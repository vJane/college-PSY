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
import cn.edu.hevttc.psy.dao.AdminDAO;
import cn.edu.hevttc.psy.util.Page;

public class AdminSer extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AdminSer() {
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
		//System.out.println(pageNo);
		String sql;
		int tiaozhuan=0;
		//删除管理员信息
		if(request.getParameter("cz").equals("1")){
			String user=request.getParameter("user");
			sql="update admins set del=0 where user='"+user+"' and del=1";
			//System.out.println(sql);
			if(AdminDAO.updateAdmin(sql)){
				session.setAttribute("message7", "删除成功！");
			}
		}
		//修改管理员信息
		if(request.getParameter("cz").equals("3")){
			String type=request.getParameter("type");
			String user=request.getParameter("user");
			String user1=request.getParameter("user1");
			String pwd=request.getParameter("pwd");
			String name=request.getParameter("name");
			String dept=request.getParameter("dept");
			String phone=request.getParameter("phone");
			sql="update admins set name='"+name+"',"
					+ "type='"+type+"',phone='"+phone+"',"
							+ "dept='"+dept+"',"
									+ "user='"+user1+"',pwd='"+pwd+"'"
											+ " where user='"+user+"'";
			//System.out.println(sql);
			if(AdminDAO.updateAdmin(sql)){
//				int type1=Integer.parseInt(type);
//				Admin admin=new Admin();
//				admin.setType(type1);
//				session.setAttribute("admin", admin);
				session.setAttribute("message7", ""+name+"的信息修改成功！");
			}
		}
		if(request.getParameter("cz").equals("4")){
			String user=request.getParameter("user");
			String pwd=request.getParameter("pwd");
			String name=request.getParameter("name");
			String type=request.getParameter("type");
			String dept=request.getParameter("dept");
			String phone=request.getParameter("phone");
			sql="insert into admins(user,pwd,name,type,dept,phone) values"
					+ "('"+user+"','"+pwd+"','"+name+"','"+type+"','"+dept+"','"+phone+"')";
			//System.out.println(sql);
			if(AdminDAO.updateAdmin(sql)){
				session.setAttribute("message7", "添加管理员信息成功！");
			}
		}
		//查询要修改的管理员信息
		if(request.getParameter("cz").equals("2")){
			String user=request.getParameter("user");
			sql="select * from admins where user='"+user+"'";
			//System.out.println(sql);
			List<Admin> list1 =AdminDAO.find(sql);
			session.setAttribute("adminList1", list1);	
			tiaozhuan=1;
			response.sendRedirect("alertAdmin.jsp");
		}
		//显示所有管理员信息
		if(request.getParameter("cz").equals("0")||tiaozhuan==0){
			Admin admin=(Admin)session.getAttribute("admin");
			String tutor=admin.getName();
			int type=admin.getType();
		    sql="select * from admins where del=1 and type>"+type+"";
			//System.out.println(sql);
			List<Admin> list =AdminDAO.find(sql);
			if(list.size()>0){
			List<Admin> list1 =new ArrayList<Admin>();
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
			session.setAttribute("adminList", list1);
			}
			response.sendRedirect("admin1.jsp");
			
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
