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
import cn.edu.hevttc.psy.util.FileUtil;
import cn.edu.hevttc.psy.util.Page;
import cn.edu.hevttc.psy.util.CopyFile;
import cn.edu.hevttc.psy.bean.ExamInfo;
import cn.edu.hevttc.psy.dao.UploadDAO;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class UploadSer extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UploadSer() {
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
		    String uz=request.getParameter("uz");
		    String shijuanError="";
		    if(uz.equals("4")){
		    	try {
	     	        SmartUpload mySmartUpload = new SmartUpload();       
	     	        mySmartUpload.initialize(this.getServletConfig(),request,response);
	     	        request.setCharacterEncoding("utf-8");
	     	        mySmartUpload.setContentDisposition(null);
						mySmartUpload.downloadFile("/muban/试卷模板.xls");
					} catch (SmartUploadException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    }
		    if(uz.equals("1")){
				FileUtil fileUtil = new FileUtil();
				ServletContext application=this.getServletContext();   
				String filePath="";
				String examName1;
				String examNation1;
			    int type;
			    try {
			        SmartUpload mySmartUpload = new SmartUpload();       
			        //mySmartUpload.setAllowedFilesList("class,xls,xlsx");
			        mySmartUpload.initialize(this.getServletConfig(),request,response);
			        mySmartUpload.upload();
			        examName1=mySmartUpload.getRequest().getParameter("examName1");
			        examNation1=mySmartUpload.getRequest().getParameter("examNation1");
			        type=Integer.parseInt(mySmartUpload.getRequest().getParameter("type"));
			        if(examName1.equals("")||examName1==null||examNation1.equals("")||examNation1==null){
			        	shijuanError="请填写必要的信息！";
			        }else{
				        String ext="";
				        List<String> fileName=new ArrayList<String>();
				        String saveUrl="";
				        for(int i=0;i<mySmartUpload.getFiles().getCount();i++){
					        com.jspsmart.upload.File myFile=mySmartUpload.getFiles().getFile(i);
					        fileName.add(myFile.getFileName());
					        if(!myFile.isMissing()){
						        ext=myFile.getFileExt();
						        saveUrl="/uploadFiles/"+fileName.get(i);
						        myFile.saveAs(saveUrl);
					        }else{
					        	if(i==0){
					        		shijuanError="上传失败，请选择一套试题！";
					               }
					        	if(i==2){
					        		shijuanError+="请选择判分标准！";
					        	}
					        }
					        
				        }
				        if(shijuanError.equals("")) {
							
							 if(fileUtil.getFileNameNoEx(fileName.get(0)).equals("xls")||fileUtil.getFileNameNoEx(fileName.get(0)).equals("xlsx")){
						    		filePath=application.getRealPath("/uploadFiles/"+fileName.get(0));  
						    		List<Question> question = fileUtil.getExamFromXls(filePath); 
						    		UploadDAO uploaddao=new UploadDAO();
						    		ExamInfo examinfo = new ExamInfo();
						    		examinfo.setExamName(examName1);
							        examinfo.setNation(examNation1);
							        examinfo.setTableName(question.get(1).getTableName());					        
							        examinfo.setType(type);
							        examinfo.setCount(question.size());
							        examinfo=uploaddao.insertInfo(examinfo);
							        List<String> sqls=new ArrayList();
							        if(examinfo!=null){
							        	for(int i=0;i<question.size();i++){
							        		sql="insert into exam (tableName,type,QuestionTitle,";
							        		for(int j=0;j<question.get(i).getAnswer().size();j++){
							        			char ch=(char)(j+97);
							        			if(j==0) sql=sql+ch;
							        		    else  sql=sql+","+ch;
							        			}
							        		sql=sql+ ")values(?,?,";
						        			for(int j=0;j<question.get(i).getAnswer().size();j++){
							        			  sql=sql+"?,";
							        			}
							        		sql=sql+"?)";
							        		if(question.get(i).getAnswer().size()==0){
							        			sql="insert into exam (tableName,type,QuestionTitle) values(?,?,?)";
							        		}	
							        		sqls.add(sql);				        	
							        	}
							        	if(uploaddao.insertExam(sqls,question)){
							        		shijuanError="试卷上传成功!";
							        	}else{
							        		shijuanError="试卷上传失败!";
							        	}
							        	
							        }else{
							        	shijuanError="上传失败!";
							        }
							        	
							        }
							 
							 if(fileUtil.getFileNameNoEx(fileName.get(1)).equals("xls")||fileUtil.getFileNameNoEx(fileName.get(1)).equals("xlsx")){
						    		filePath=application.getRealPath("/uploadFiles/"+fileName.get(1));  
						    		String tableName=fileUtil.getFileNamea(fileName.get(1));
							    	List<String> standTitle=fileUtil.getExamTitle(filePath);
							    	List<Question> question = fileUtil.getExamFromXls1(filePath);
						    		UploadDAO uploaddao=new UploadDAO();
						    		List<String> sqls=new ArrayList();
						    		if(uploaddao.createTable(tableName,standTitle)){
						    			sql="insert into "+tableName+" values(";
						    			for(int i=0;i<standTitle.size()-1;i++){
						    				sql=sql+"?,";
						    			}
						    			sql=sql+"?)";
						    			sqls.add(sql);
						    			//System.out.println(sql);
						    			if(uploaddao.insertExamStand(sqls,question)){
							    			shijuanError+="试卷答案上传成功!";
						    			}else{
						    				shijuanError+="试卷答案上传失败!";
						    			}
						    		}else{
						    			shijuanError+="试卷答案建表失败!";
						    		}
							 }
							 if(fileUtil.getFileNameNoEx(fileName.get(2)).equals("class")){
					    			filePath=application.getRealPath("/uploadFiles/"+fileName.get(2));
					    			String destPath=application.getRealPath("/WEB-INF/classes/cn/edu/hevttc/psy/strategies/"+fileName.get(2));
					    			if(CopyFile.CopyFileStream(filePath,destPath)){
					    				shijuanError+="判分标准上传成功.";
				    				}else{
				    					shijuanError+="判分标准上传失败.";
				    				}
					    	 }
				        }
					 }
			        session.setAttribute("shijuanError",shijuanError);
			        response.sendRedirect("shijuan.jsp");
		        }catch(Exception e){
		        	e.printStackTrace();  
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
