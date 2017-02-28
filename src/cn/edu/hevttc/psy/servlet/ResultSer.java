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

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import cn.edu.hevttc.psy.bean.Admin;
import cn.edu.hevttc.psy.bean.Student;
import cn.edu.hevttc.psy.bean.Temporary;
import cn.edu.hevttc.psy.dao.ResultDAO;
import cn.edu.hevttc.psy.util.FileUtil;
import cn.edu.hevttc.psy.util.Page;

public class ResultSer extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ResultSer() {
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
		HttpSession session = request.getSession();
		int tiaozhuan=0;
		if(rz.equals("4")){
			List<Temporary> delList=(List<Temporary>)session.getAttribute("delList1");
			ServletContext application=this.getServletContext();   
			String filePath=application.getRealPath("/uploadFiles/"); 
			String fileName=FileUtil.exportResult(delList,filePath);
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
		    List<Temporary> delList=(List<Temporary>)session.getAttribute("delList1");
		    String sql=null;
		    String cardID;
		    String resultDate;
		    int count=0;
		    for(int i=0;i<delList.size();i++){
		    	cardID=delList.get(i).getCardID();
		    	resultDate=delList.get(i).getResultDate();
		    	sql="update temporaryresult set del=0 where cardID='"+cardID+"'"
						+ " and resultDate='"+resultDate+"' ";
		    	//System.out.println(sql);
				if(ResultDAO.updateResult(sql)){
					count++;
				}
		    }
			session.setAttribute("message11","删除成功"+count+"条记录！");
		
			session.setAttribute("resultList1",null);
			tiaozhuan=1;
		    response.sendRedirect("result.jsp");
		}
		if(rz.equals("2")){
			String cardID=request.getParameter("cardID");
			String resultDate=request.getParameter("resultDate");
			String sql="select * from temporaryresult where cardID='"+cardID+"'"
					+ " and resultDate='"+resultDate+"'";
			//System.out.println(sql);
			List<Temporary> list=ResultDAO.find(sql);
			session.setAttribute("resultList1",list);
			tiaozhuan=1;
			response.sendRedirect("resultDetail.jsp");
		}
		if(rz.equals("1")){
			String cardID=request.getParameter("cardID");
			String resultDate=request.getParameter("resultDate");
			String sql="update temporaryresult set del=0 where cardID='"+cardID+"' "
					+ " and resultDate='"+resultDate+"' ";
			//System.out.println(sql);
			if(ResultDAO.updateResult(sql)){
				//session.setAttribute("message11","删除成功！");
			}
		}
		if(rz.equals("0")||tiaozhuan==0){
			Admin admin=(Admin)session.getAttribute("admin");
			String name=admin.getName();
			int type=admin.getType();
			String sql;
			sql="select name,cardID,resultInfo,dept,resultDate "
						+ "from temporaryresult where del=1";
				//System.out.println(sql);
			if(!(keyword.equals("")||keyword==null)){
				sql=sql+ " and (name like '%"+keyword+"%' or cardID like '%"+keyword+"%' "
										+ "or resultInfo like '%"+keyword+"%' or dept like '%"+keyword+"%'  )";
				//System.out.println(sql);
				
			}
			if(!(startDate==null||endDate==null||startDate.equals("年-月-日")||endDate.equals("年-月-日"))){
				sql=sql+" and resultDate between '"+startDate+"' and '"+endDate+"'";
				//System.out.println(sql);
			}
			List<Temporary> list=ResultDAO.find(sql);
			if(list.size()>0){
			    List<Temporary> list1 =new ArrayList<Temporary>();
				Page page = new Page();
				if(list.size()<10) page.setPageSize(list.size());
				else page.setPageSize(10);
				page.setRecordCount(list.size());
				page.setCurrPageNo(Integer.parseInt(pageNo));
				page.setTotalPageCountByRs();
				for(int i=page.getStartRow()-1;i<page.getEndRow();i++){
					list1.add(list.get(i));
				}
				session.setAttribute("pageSize1", page.getPageSize());
				session.setAttribute("totalPage1",page.getTotalPageCount());
				session.setAttribute("currentPage1", page.getCurrPageNo());
				session.setAttribute("delList1",list);
				session.setAttribute("resultList1",list1);
			}else{
				session.setAttribute("resultList1",null);
				session.setAttribute("resultError1","查无此人，请重新输入关键字！");
			}
			response.sendRedirect("result.jsp");
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
