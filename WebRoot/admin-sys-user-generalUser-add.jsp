<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>Insou 后台管理 增加新用户</title>

<link rel="stylesheet" type="text/css"  href="css/admin-accordion-menu.css"/>
<link rel="stylesheet" type="text/css"  href="css/admin-font-awesome.css"/>
<link rel="stylesheet" type="text/css" href="css/admin-right-base.css" />
<link rel="stylesheet" type="text/css" href="css/admin-sys-user-add.css">
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/admin-accordion-menu.js"></script>
<script type="text/javascript" src="js/admin-transvert-bar.js"></script>
</head>

<body>
<div class="all">
	<div class="head">
		<div class="logo">
			<center>
				<img src="images/logo.png">
			</center>
		</div>
		<div class="head-font">
			后台管理
		</div>

	</div>
	<div id="left">
		<div class="sidebar">
			<div id="jquery-accordion-menu" class="jquery-accordion-menu red">
				<div class="jquery-accordion-menu-header" id="form"></div>
				<ul id="demo-list">
			 	  <li class="active"><a href="admin-firstPage.jsp"><i class="fa fa-home"></i>首页</a></li>
					<li><a href="#"><i class="fa fa-cog"></i>系统管理</a>
						<ul class="submenu">
							<li><a href="admin-sys-generalUser.jsp">普通用户</a>
							</li>
							<li><a href="#">后台用户</a>
								<ul class="submenu">
									<li><a href="admin-sys-user-add.jsp">增加新用户 </a></li>
									<li><a href="admin-sys-user-modify.jsp">查删改用户</a></li>
									<li><a href="admin-sys-user-introduce.jsp">角色介绍</a></li>
								</ul>
							</li>	
						</ul>
					</li>
					<li><a href="#"><i class="fa fa-glass"></i>数据管理 </a>
						<ul class="submenu">
							<li><a href="admin-data-filtration.jsp">内容过滤</a></li>
							<li><a href="admin-data-rubbish.jsp">垃圾数据</a></li>
							<li><a href="admin-data-sort.jsp">排序规则</a></li>
							<li><a href="#">搜索统计</a>
								<ul class="submenu">
									<li><a href="#">关键词统计</a></li>
									<li><a href="#">搜索量统计</a></li>
									<li><a href="#">分类统计</a></li>
								</ul>
							</li>			
						</ul>
					</li>
					<li><a href="#"><i class="fa fa-suitcase"></i>连接管理</a>
						<ul class="submenu">
							<li><a href="admin-link-submit.jsp">链接提交</a><span class="jquery-accordion-menu-label">10 </span>
							</li>
							<li><a href="admin-link-deadLink.jsp">死链提交</a></li>
							<li><a href="admin-link-frequency.jsp">抓取频次</a></li>
						</ul>
					</li>
					<li><a href="#"><i class="fa fa-user"></i>About </a></li>
					<li><a href="#"><i class="fa fa-envelope"></i>Contact </a></li>   
				</ul>
				<div class="jquery-accordion-menu-footer">
				Footer
				</div>
			</div>
		</div>
	</div>
	<div id="right">
		<div class="right-top">
			<span class="title-bar">&gt;&gt;系统管理&gt;&gt;普通用户 &gt;&gt;增加新用户
			
			</span>
			<div class="title-r">
			    <div class="bar-ab">
					<div class=" bar-a"><li class="bar-aa">
					<center>sb</center></li></div>
					<div class="bar-b"><li class="bar-bb">管理人员</li></div>
				</div>
				<div class="bar-c"><li class="bar-right"><a href="#">注销</a></li></div>
			</div>
		</div>
		<div class="right-content">
			<div class="right-c1">
			<form name="addUserform" method="post" action="controller/UserServlet">
			 <input name="operation" type="hidden" id="operation" value="add">
             	用户名 ：
             	<input type="text" name="username" id="username" autofocus required style="margin-left:9px"/>*必填 
            	 <br /><br />
            	 密   码：
             	<input type="password" name="password" id="password" autofocus required style="margin-left:24px" />*必填 
             	<br /><br />
             	确认密码：
             	<input type="password" name="repassword" autofocus required />*必填 
             	<br /><br />
            	邮箱: 
               <input type="email" name="email" id="email" autofocus required style="margin-left:24px" />*必填
            	<br /><br />
            	验证码：  
            	<input type="text" id="inputRandom" style="margin-left:15px;"> 
            	<label id="autoRandom" value=""></label><INPUT TYPE="button" VALUE="   获取验证码" ONCLICK="autoRandom.innerHTML=createCode(5)" class="b-return" style="padding-left:0; width:113px">  
            	<input type="button" value="验证" onclick="test()" class="b-return">
            	<script type="text/javascript" >  
            	window.onload()=autoRandom.innerHTML=createCode(5);  
            	</script>  
            	<br /><br />
            	<input name="Submit" type="submit" value="提交" class="b-return" style="margin:83px 18px 0 0;">
            	<input type="reset" value="重置" class="b-return" style="margin-right:206px;">    
              	<button class="b-return"><a href="admin-sys-generalUser.jsp" >返回</a></button>
        	</form>
			</div>
		</div>
	</div>
</div>	
<script type="text/javascript">
(function($) {
$.expr[":"].Contains = function(a, i, m) {
	return (a.textContent || a.innerText || "").toUpperCase().indexOf(m[3].toUpperCase()) >= 0;
};
function filterList(header, list) {
	//@header 头部元素
	//@list 无需列表
	//创建一个搜素表单
	var form = $("<form>").attr({
		"class":"filterform",
		action:"#"
	}), input = $("<input>").attr({
		"class":"filterinput",
		type:"text"
	});
	$(form).append(input).appendTo(header);
	$(input).change(function() {
		var filter = $(this).val();
		if (filter) {
			$matches = $(list).find("a:Contains(" + filter + ")").parent();
			$("li", list).not($matches).slideUp();
			$matches.slideDown();
		} else {
			$(list).find("li").slideDown();
		}
		return false;
	}).keyup(function() {
		$(this).change();
	});
}
$(function() {
	filterList($("#form"), $("#demo-list"));
});
})(jQuery);	
</script>

<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';clear:both;">

</div>
</body>
</html>
