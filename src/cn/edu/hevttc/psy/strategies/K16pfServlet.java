package cn.edu.hevttc.psy.strategies;

import cn.edu.hevttc.psy.bean.Standard;
import cn.edu.hevttc.psy.bean.Temporary;
import cn.edu.hevttc.psy.dao.StrategyDAO;
import cn.edu.hevttc.psy.strategies.Calculate;
import cn.edu.hevttc.psy.util.Page;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class K16pfServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public K16pfServlet() {
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
		int[] score = new int[187];
		Page page= (Page)session.getAttribute("examPage");
		//System.out.println(page.getRecordCount());
		String tableName=session.getAttribute("tableName").toString();
		HashMap<Integer, String> map = (HashMap<Integer, String>)session.getAttribute("hashMap");
		StrategyDAO strategy = new StrategyDAO();
        List<Standard> standard = strategy.getScore("k16pfStandard");
		for(int i=1;i<=page.getRecordCount();i++){
			 if(map.get(i)!=null){
			  String answer =map.get(i);
			  if(answer.equals("0")){
				  score[i]=standard.get(i).getA();
			  }else if(answer.equals("1")){
				  score[i]=standard.get(i).getB();
			  }else if(answer.equals("2")){  
				  score[i]=standard.get(i).getC();
			  }
			 }
          }
		Calculate calculate = new Calculate(score);
		String elementA=calculate.elementA();
		String elementB=calculate.elementB();
		String elementC=calculate.elementC();
		String elementE=calculate.elementE();
		String elementF=calculate.elementF();
		String elementG=calculate.elementG();
		String elementH=calculate.elementH();
		String elementI=calculate.elementI();
		String elementL=calculate.elementL();
		String elementM=calculate.elementM();
		String elementN=calculate.elementN();
		String elementO=calculate.elementO();
		String elementQ1=calculate.elementQ1();
		String elementQ2=calculate.elementQ2();
		String elementQ3=calculate.elementQ3();
		String elementQ4=calculate.elementQ4();
		String X1 = calculate.X1();
		String X2 = calculate.X2();
		String X3 = calculate.X3();
		String X4 = calculate.X4();
		String Y1 = calculate.Y1();
		String Y2 = calculate.Y2();
		String Y3 = calculate.Y3();
		String Y4 = calculate.Y4();

		String name=session.getAttribute("name").toString();
	//	String examName=session.getAttribute("examName").toString();
		String startDate = session.getAttribute("startDate").toString();
		String endDate = session.getAttribute("endDate").toString();
		String resultDate=session.getAttribute("resultDate").toString();
		String results=elementA+elementB+elementC+elementE+elementF+elementG+elementH+elementI+elementL+elementM+elementN+elementO+elementQ1+elementQ2+elementQ3+elementQ4+X1+X2+X3+X4+Y1+Y2+Y3+Y4;
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
    		String sql="insert into temporaryresult(name,cardID,tableName,resultInfo,resultABCD,tutor,dept,resultDate,startDate,endDate)"
    				+ "values('"+name+"','"+cardID+"','"+tableName+"','"+results+"','"+map+"','"+dept+"','"+resultDate+"','"+startDate+"','"+endDate+"')";
    		if(strategy.insertResult(sql)){  
     	     	response.sendRedirect("success.jsp");
     	    }
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
