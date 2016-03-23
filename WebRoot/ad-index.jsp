<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <base href="<%=basePath%>">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insou后台登录界面</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/sign_in.css">
</head>

<body>
	<div class="signin">
		<div class="signin-head"><img src="images/logo.png" alt="" class="img-circle"></div>
		<form class="form-signin" role="form" name="loginform" method="post" action="controller/LoginServlet">
			<input name="username" type="text" class="form-control" placeholder="用户名" required autofocus />
			<input name="password" type="password" class="form-control" placeholder="密码" required />
			<button name="Submit" value="登录" class="btn btn-lg btn-warning btn-block" type="submit" onclick="admin-sys-generalUser.jsp">登录</button>
			<label class="checkbox">
				<input type="checkbox" value="remember-me"> 记住我
			</label>
		</form>
	</div>
	<div class="foot">
			<p>Copyright ©2015 Insou  |  后台管理<br></p>
	</div>
</body>
</html>
