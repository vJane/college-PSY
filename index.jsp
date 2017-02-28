<%@ page language="java" import="java.util.*" import="java.text.SimpleDateFormat;" pageEncoding="utf-8"%>

<%
  String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
 %>
<!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="keywords" content="测试,大学生心理测试系统,河北科技师范学院,hevttc,科师"/>
	<meta name="description" content="河北科技师范学院大学生心理测试"/>
	<title>大学生心理测试系统</title>
	<link rel="stylesheet" type="text/css" href="style/reset.css">
	<link rel="stylesheet" type="text/css" href="style/main.css">
	<link rel="shortcut icon" href="images/favicon.ico"> 
  </head>
  <body style="background-color: #e1e9f4;">
  	<div class="header clearfix">
		<div class="logo fl"></div>
		<div class="title fl">
			<p class="chi">大学生心理测试系统</p>
			<hr>
			<p class="eng">College Students' Psychological Test System</p>
		</div>
	</div>
	<div class="container">
		<div class="images">
			<div class="image">
				<img src="images/1.png" alt="科师印象一">
			</div>
			<div class="image">
				<img src="images/2.png" alt="科师印象二">
			</div>
			<div class="image">
				<img src="images/3.png" alt="科师印象三">
			</div>
		</div>

		<div class="loginBox">
			<div class="loginTop clearfix">
				<a href="#" class="active" id="test1">入学复试测试</a>
				<a href="#" id="test2">研究生测试</a>
			</div>
			<form action="StudentIndex" method="post" >
				<div class="loginBottom" id="loginLeft">
					<span>身份证号:</span><input type="text" id="IDcard" name="cardID"><span class="must" id="IDcard_msg">*</span><br>
					<span>姓  名:</span><input type="text" id="name" name="name"><span class="must" id="name_msg">*</span><br>
					<span>院  系:</span><input type="text" name="dept"><span class="must"></span><br>
					<input type="submit" value="登录" class="submit1" name="submit1">
					<input type="reset" value="重置" class="submit1">
				</div>
			</form>
			<form action="StudentIndex" method="post">
				<div class="loginBottom" id="loginRight">
					<span>学号:</span><input type="text" id="num" name="studentID"><span class="must" id="num_msg">*</span><br>
					<span>姓名:</span><input type="text" id="name2" name="name"><span class="must" id="name2_msg">*</span><br>
					<input type="submit" value="登录" class="submit1" name="submit2">
					<input type="reset" value="重置" class="submit1">
				</div>
			</form>
		</div>
		<%if(session.getAttribute("index_error")!=null){
       	   String index_error=session.getAttribute("index_error").toString();
        %>
           <div class="error_msg"><i class="errorIcon" style="*float:left;"></i><p><%=index_error %></p></div>
       <%session.setAttribute("index_error",null);} %>
		<div class="abtm">
			<a href="admin.jsp">后台管理</a> |
			<a href="http://www.hevttc.edu.cn/">河北科技师范学院</a>
		</div>
	</div>
	<div class="footer"></div>
	<script>
		window.onload=function(){
			var test1=document.getElementById("test1");
			var test2=document.getElementById("test2");
			var loginLeft=document.getElementById("loginLeft");
			var loginRight=document.getElementById("loginRight");

			test1.onclick=function(){
				test2.className="";
				test1.className="active";
				loginRight.style.display="none";
				loginLeft.style.display="block";
			}
			test2.onclick=function(){ 
				test1.className="";
				test2.className="active";
				loginLeft.style.display="none";
				loginRight.style.display="block";
			}
		}
	</script>
	<!--[if IE 6]>
		<script type="text/javascript" src="js/DD_belatedPNG_0.0.8a-min.js"></script>
		<script type="text/javascript" src="js/ie6Fixpng.js"></script>
	<![endif]-->
  </body>
</html>  	
<%session.invalidate(); %>