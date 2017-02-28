package cn.edu.hevttc.psy.strategies;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.hevttc.psy.bean.Standard;
import cn.edu.hevttc.psy.bean.Temporary;
import cn.edu.hevttc.psy.dao.StrategyDAO;
import cn.edu.hevttc.psy.util.Page;

public class IQtestServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public IQtestServlet() {
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
		HttpSession session=request.getSession();
		Page page= (Page)session.getAttribute("examPage");
		String tableName=session.getAttribute("tableName").toString();
		String StandardName=tableName+"Standard";
		HashMap<Integer, String> map = (HashMap<Integer, String>)session.getAttribute("hashMap");
        StrategyDAO strategy = new StrategyDAO();
        List<String> standard = strategy.getScore(1,StandardName);
        int sum=0;
        for(int i=1;i<=page.getRecordCount();i++){
			 if(map.get(i)!=null){
			  String answer =map.get(i);
			  if(answer.equals(standard.get(i-1))){
				  sum+=5;
			  }
			 }
         }
         sum=sum/10;
    	 String msg="";
    	 switch (sum){
    	    case 14:
    	    case 13:
    	    case 12:
    	      msg="最优秀";
    	    break;
    	    case 11:
    	    case 10:
    	    msg="优秀";
    	    break;
    	    case 9:
    	    msg="正常";
    	    break;
    	    case 8:
    	    msg="稍差";
    	    default:
    	    msg="弱智";      
    	  }
  		String results="您的IQ（智商）测试结果为："+msg;
 		String startDate = session.getAttribute("startDate").toString();
 		String name = session.getAttribute("name").toString();
 		String endDate = session.getAttribute("endDate").toString();
 		String resultDate=session.getAttribute("resultDate").toString();
    	if(session.getAttribute("studentID")!=null){
    		String studentID=session.getAttribute("studentID").toString();
    		String sql="insert into result(studentID,tableName,resultInfo,resultABCD,resultDate,startDate,endDate)"
    				+ "values('"+studentID+"','"+tableName+"','"+results+"','"+map+"','"+resultDate+"','"+startDate+"','"+endDate+"')";
     		if(strategy.insertResult(sql)){  
     	     	response.sendRedirect("success.jsp");
     	    }	
        	
    	}else if(session.getAttribute("temp")!=null){
    		Temporary temp=(Temporary)session.getAttribute("temp");
	 		String cardID=temp.getCardID();
	 		String dept=temp.getDept();
    		String sql="insert into temporaryresult(name,cardID,tableName,resultInfo,resultABCD,dept,resultDate,startDate,endDate)"
    				+ "values('"+name+"','"+cardID+"','"+tableName+"','"+results+"','"+map+"','"+dept+"','"+resultDate+"','"+startDate+"','"+endDate+"')";
    		if(strategy.insertResult(sql)){  
     	     	response.sendRedirect("success.jsp");
     	    }
    	}
 		
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
