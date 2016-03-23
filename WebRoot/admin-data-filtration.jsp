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
<title>Insou 后台管理 内容过滤</title>

<link rel="stylesheet" type="text/css"  href="css/admin-accordion-menu.css"/>
<link rel="stylesheet" type="text/css"  href="css/admin-font-awesome.css"/>
<link rel="stylesheet" type="text/css" href="css/admin-right-base.css" />
<link rel="stylesheet" type="text/css" href="css/admin-data-filtration.css">
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
			<span class="title-bar">&gt;&gt;数据管理&gt;&gt;内容过滤
			
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
			<div class="right-d1">
				 <br>
           <span class="title-barb"><strong>添加过滤关键词</strong></span><br/>
           <div class="line-block">
              <table width="400" align="center" style="margin-top:20px;">
                  <tr>
                    <td class="word">关键词
                    </td>
                    <td>
                      <form>
                        <input class="add-w" tyle="text" name="keyword" value="">
                      </form>
                    </td>
                  </tr>
                  <tr>
                    <td class="word">是否过滤
                    </td>
                    <td>
                      <form action="" method="post">
                        <input type="radio" value="yes" name="danxuan" checked>是
                        <input type="radio" value="no" name="danxuan">否
                      </form>
                    </td>
                  </tr>
                  <tr>
                    <td class="word">相关关键词
                    </td>
                    <td>
                      <form>
                        <input class="add-w" tyle="text" name="relative-word" value="">
                      </form>
                    </td>
                  </tr>
                  <tr>
                    <td class="word">过滤原因
                    </td>
                    <td>
                      <form>
                        <input type="checkbox" value="seqing" name="cause" checked>色情
                        <input type="checkbox" value="baoli" name="cause" >暴力
                        <input type="checkbox" value="zhengzhi" name="cause" checked>政治
                        <input type="checkbox" value="qita" name="cause" >其它
                      </form>
                    </td>
                  </tr>
                  <tr>
                    <td>备注
                    </td>
                    <td>
                      <form>
                        <input class="add-w add-wb" type="text" value="" name="beizhu">
                      </form>
                    </td>
                  </tr>
                  <tr>
                    <td colspan="2" align="center">
                      <form>
                        <input type="button" value="确认" name="ensure">
                      </form>
                    </td>
                  </tr>
              </table>
           </div>
            <div class="h-hr"></div>
           <span class="title-barb"><strong>已过滤关键词</strong></span><br/>
           <div class="line-block f-word">
              <table width="320" height="200" style="margin-top:20px; border:1px solid #ebebeb;">
                 <tr>
                  <td class="td-bg"><li>关键词一</li></td>
                 </tr>
                 <tr>
                  <td class="td-bg"><li>关键词二</li></td>
                 </tr>
                 <tr>
                  <td class="td-bg"><li>关键词三</li></td>
                 </tr>
                 <tr>
                  <td class="td-bg"><li>关键词四</li></td>
                 </tr>
                 <tr>
                  <td class="td-bg"><li>关键词五</li></td>
                 </tr>
                 <tr>
                  <td class="td-bg"><li>关键词六</li>
                  </td>
                </tr>
              </table>
           </div>
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
