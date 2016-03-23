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
<title>Insou 后台管理 链接提交</title>

<link rel="stylesheet" type="text/css"  href="css/admin-accordion-menu.css"/>
<link rel="stylesheet" type="text/css"  href="css/admin-font-awesome.css"/>
<link rel="stylesheet" type="text/css" href="css/admin-right-base.css" />
<link rel="stylesheet" type="text/css" href="css/admin-sys-generalUser.css">
<link rel="stylesheet" type="text/css" href="css/admin-link-submit.css">
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
			<span class="title-bar">&gt;&gt;连接管理&gt;&gt;链接提交 
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
			<div class="right-c2">
     			<table>
               		<thead class="t-thead">
                  	<tr class="t-tr">
                     	<th valign="middle">序号</th>
                     	<th >已添加URL</th>
                     	<th >是否有效</th>
                     	<th >操作</th>
                 	</tr>
               		</thead>
               		<tbody>
                 		<tr class="t-tr0">
                    		<td align="center" valign="middle">1</td>
                     		<td align="center">https://www.baidu.com</td>
                     		<td align="center">
                     			<form action="" method="post">
                        			<input type="radio" value="yes" name="danxuan" checked>是
                        			<input type="radio" value="no" name="danxuan">否
                      			</form>
                     		</td>
                     		<td align="center"><a href="#">修改</a>|<a href="#">删除</a></td>
                 		</tr>
               		</tbody>
               		<tbody>
                  		<tr class="t-tr0">
                     		<td align="center" valign="middle">2</td>
                     		<td align="center">https://www.youku.com</td>
                     		<td align="center">
                     			<form action="" method="post">
                        			<input type="radio" value="yes" name="danxuan" checked>是
                        			<input type="radio" value="no" name="danxuan">否
                      			</form>
                     		</td>
                     		<td align="center"><a href="#">修改</a>|<a href="#">删除</a></td>
                 		</tr>
               		</tbody>
              		<tbody>
                  		<tr class="t-tr0">
                     		<td align="center" valign="middle">3</td>
                     		<td align="center">https://www.tencent.com</td>
                     		<td align="center">
                     			<form action="" method="post">
                        			<input type="radio" value="yes" name="danxuan">是
                        			<input type="radio" value="no" name="danxuan" checked>否
                      			</form>
                     		</td>
                     		<td align="center"><a href="#">修改</a>|<a href="#">删除</a></td>
                		</tr>
       				</tbody>
              		<tbody>
                  		<tr class="t-tr0">
                     		<td align="center" valign="middle">4</td>
                     		<td align="center">https://www.iqiyi.com</td>
                     		<td align="center">
                     			<form action="" method="post">
                        			<input type="radio" value="yes" name="danxuan" checked>是
                        			<input type="radio" value="no" name="danxuan">否
                      			</form>
                     		</td>
                     		<td align="center"><a href="#">修改</a>|<a href="#">删除</a></td>
                		</tr>
       				</tbody>
         			<tbody>
                  		<tr class="t-tr0">
                     		<td align="center" valign="middle">5</td>
                     		<td align="center">https://www.kugou.com</td>
                     		<td align="center">
                     			<form action="" method="post">
                        			<input type="radio" value="yes" name="danxuan" >是
                        			<input type="radio" value="no" name="danxuan" checked>否
                      			</form>
                     		</td>
                     		<td align="center"><a href="#">修改</a>|<a href="#">删除</a></td>
                 		</tr>
               		</tbody>
               		<tbody>
                 		 <tr class="t-tr0">
                     		<td align="center" valign="middle">6</td>
                     		<td align="center">https://www.mail.com</td>
                     		<td align="center">
                     			<form action="" method="post">
                        			<input type="radio" value="yes" name="danxuan" checked>是
                        			<input type="radio" value="no" name="danxuan">否
                      			</form>
                     		</td>
                     		<td align="center"><a href="#">修改</a>|<a href="#">删除</a></td>
                 		</tr>
               		</tbody>
            	</table>
			</div>
		</div>
		<div>
			<button class="l-button">添加</button>
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
