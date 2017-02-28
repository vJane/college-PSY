package cn.edu.hevttc.psy.strategies;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.hevttc.psy.bean.Temporary;
import cn.edu.hevttc.psy.dao.StrategyDAO;
import cn.edu.hevttc.psy.util.Page;

public class UPIServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UPIServlet() {
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
		Page page= (Page)session.getAttribute("page");
		StrategyDAO strategy = new StrategyDAO();
		String tableName=session.getAttribute("tableName").toString();
		HashMap<Integer, String> map = (HashMap<Integer, String>)session.getAttribute("hashMap");
        int sum=0;
        int[] wei={5,20,35,50};
        int weiCount=0;
        for(int i=1;i<=60;i++){
			 if(map.get(i)!=null&&i!=5&&i!=20&&i!=35&&i!=50){
			  String answer =map.get(i);
			 // System.out.println(answer);
			  if(answer.equals("A")){
				  sum+=1;
			  }
			 }
         }
        for(int i=0;i<wei.length;i++){
        	if(map.get(wei[i]).equals("A")) weiCount++;
        }
        String zixun=map.get(64);
        boolean flag=false;
        if(zixun!=null && !zixun.equals("") ){
        	flag=true;
        }
        int fuzhu=0;
        for(int i=61;i<=63;i++){
        	if(map.get(i).equals("A")){
        		fuzhu+=1;
        	}
        }
        int fuzhu2=0;
        if(map.get(8).equals("A"))  fuzhu2+=1;
        if(map.get(16).equals("A"))  fuzhu2+=1;
        if(map.get(26).equals("A"))  fuzhu2+=1;
    	 String msg="";
    	 if(sum>=25 || map.get(25).equals("A") || fuzhu>=2 || flag){
    	 	msg="该生属于A类，需要继续进行心理咨询或心理治疗。";
    	 	if(flag){
    	 		msg=msg+"该生咨询问题为:"+zixun;
    	 	}
    	 }else if(sum>=16 && sum<25 || fuzhu2>=1 || fuzhu==1){
    	 	msg="该生属于B类，可以过一段时间再联系。";
    	 }else{ 
    		 msg="该生属于C类，没有特别问题。";
    	 }
         if(weiCount<2 && sum<=6 || weiCount>=3&&sum>=50){
        	 msg=msg+"该生问卷答案矛盾，建议重新测试！";
         }
 		String name=session.getAttribute("name").toString();
 		String startDate = session.getAttribute("startDate").toString();
 		String endDate = session.getAttribute("endDate").toString();
 		String resultDate=session.getAttribute("resultDate").toString();
    	 if(session.getAttribute("studentID")!=null){
     		String studentID=session.getAttribute("studentID").toString();
     		String sql="insert into result(studentID,tableName,resultInfo,resultABCD,resultDate,startDate,endDate)"
     				+ "values('"+studentID+"','"+tableName+"','"+msg+"','"+map+"','"+resultDate+"','"+startDate+"','"+endDate+"')";
      		if(strategy.insertResult(sql)){  
      	     	response.sendRedirect("success.jsp");
      	    }	
         	
     	}else if(session.getAttribute("temp")!=null){
    		Temporary temp=(Temporary)session.getAttribute("temp");
	 		String cardID=temp.getCardID();
	 		String dept=temp.getDept();
     		String sql="insert into temporaryresult(name,cardID,tableName,resultInfo,resultABCD,dept,resultDate,startDate,endDate)"
     				+ "values('"+name+"','"+cardID+"','"+tableName+"','"+msg+"','"+map+"','"+dept+"','"+resultDate+"','"+startDate+"','"+endDate+"')";
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

		doPost(request,response);
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
