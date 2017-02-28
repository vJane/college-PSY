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
import cn.edu.hevttc.psy.bean.Result;
import cn.edu.hevttc.psy.bean.Result;
import cn.edu.hevttc.psy.dao.ResultDAO;
import cn.edu.hevttc.psy.util.FileUtil;
import cn.edu.hevttc.psy.util.Page;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class ResultSer1 extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ResultSer1() {
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
		String rz=request.getParameter("rz");
		String pageNo=request.getParameter("pageNo");
		String startDate=request.getParameter("startDate");
		String endDate=request.getParameter("endDate");
		String keyword;
		if(request.getParameter("keyword")==null) keyword="";
		else keyword=request.getParameter("keyword");
		String examName;
		if(request.getParameter("examName")==null) examName="全部试卷";
		else examName=request.getParameter("examName");
		HttpSession session = request.getSession();
		int tiaozhuan=0;
		if(rz.equals("4")){
			List<Result> delList=(List<Result>)session.getAttribute("delList");
			ServletContext application=this.getServletContext();   
			String filePath=application.getRealPath("/uploadFiles/"); 
			String fileName=FileUtil.exportResult1(delList,filePath);
			try {
     	        SmartUpload mySmartUpload = new SmartUpload();       
     	        mySmartUpload.initialize(this.getServletConfig(),request,response);
     	        request.setCharacterEncoding("utf-8");
     	        mySmartUpload.setContentDisposition(null);
					mySmartUpload.downloadFile("/uploadFiles/"+fileName+".xls");
				} catch (SmartUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 	        tiaozhuan=1;
		}
		if(rz.equals("3")){
		    List<Result> delList=(List<Result>)session.getAttribute("delList");
		    String sql=null;
		    String studentID;
		    String tableName;
		    String resultDate;
		    int count=0;
		    for(int i=0;i<delList.size();i++){
		    	studentID=delList.get(i).getStudentID();
		    	tableName=delList.get(i).getTableName();
		    	resultDate=delList.get(i).getResultDate();
		    	sql="update result set del=0 where studentID='"+studentID+"' and tableName='"+tableName+"'"
						+ " and resultDate='"+resultDate+"' ";
		    	//System.out.println(sql);
				if(ResultDAO.updateResult(sql)){
					count++;
				}
		    }
			session.setAttribute("messager","删除成功"+count+"条记录！");
			session.setAttribute("resultListr",null);
			tiaozhuan=1;
		    response.sendRedirect("ResultTitle");
		}
		if(rz.equals("2")){
			String studentID=request.getParameter("studentID");
			String tableName=request.getParameter("tableName");
			String resultDate=request.getParameter("resultDate");
			String sql="select * from result,examinfo,student where result.studentID='"+studentID+"' and examinfo.tableName='"+tableName+"'"
					+ " and resultDate='"+resultDate+"' and result.tableName=examinfo.tableName and student.studentID=result.studentID";
			//System.out.println(sql);
			List<Result> list=ResultDAO.find1(sql);
			session.setAttribute("resultListr1",list);
			tiaozhuan=1;
			response.sendRedirect("resultDetail1.jsp");
		}
		if(rz.equals("1")){
			String studentID=request.getParameter("studentID");
			String tableName=request.getParameter("tableName");
			String resultDate=request.getParameter("resultDate");
			String sql="update result set del=0 where studentID='"+studentID+"' and tableName='"+tableName+"'"
					+ " and resultDate='"+resultDate+"' ";
			//System.out.println(sql);
			if(ResultDAO.updateResult(sql)){
				//session.setAttribute("messager","删除成功！");
			}
		}
		if(rz.equals("0")||tiaozhuan==0){
			Admin admin=(Admin)session.getAttribute("admin");
			String name=admin.getName();
			int type=admin.getType();
			//System.out.println(name+""+type+","+pageNo);
			String sql;
			sql="select * from result,examinfo,student"
						+ " where result.tableName=examinfo.tableName and student.studentID=result.studentID and result.del=1";
				//System.out.println(sql);
			if(!(keyword.equals("")||keyword==null)){
				sql=sql+ " and (name like '%"+keyword+"%' or result.studentID like '%"+keyword+"%' or examName like '%"+keyword+"%'"
										+ "or resultInfo like '%"+keyword+"%' or dept like '%"+keyword+"%'  )";
				//System.out.println(sql);
				
			}
			if(!(startDate==null||endDate==null||startDate.equals("年-月-日")||endDate.equals("年-月-日"))){
				sql=sql+" and resultDate between '"+startDate+"' and '"+endDate+"'";
				//System.out.println(sql);
			}
			if(!examName.equals("全部试卷")){
				sql=sql+" and examName='"+examName+"'";
				//System.out.println(sql);
			}
			if(type>=2){
				sql=sql+" and tutor='"+name+"'";
				//System.out.println(sql);
			}
			List<Result> list=ResultDAO.find1(sql);
			if(list.size()>0){
			    List<Result> list1 =new ArrayList<Result>();
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
				session.setAttribute("delList",list);
				session.setAttribute("resultListr",list1);
			}else{
				session.setAttribute("resultListr",null);
				session.setAttribute("resultError","查无此人，请重新输入关键字！");
			}
			response.sendRedirect("ResultTitle");
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
