<%@page import="beans.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主要信息页面</title>
</head>
<body>
	<%
		//获取提示信息
		String info = (String)request.getAttribute("info");
		//如果提示信息非空,则输出提示信息
		if(info!=null){
			out.println(info);
		}
		//获取用户登录信息
		User user = (User)session.getAttribute("user");
		//判断用户是否登陆
		if(user!=null){
	%>
	<table align="center" width="350" border="0" height="250" bordercolor="#E8F4CC">
		<tr>
			<td align="right" colspan="2">
				<!-- <span style="font-weight:bold;font-size:18px;"></span> -->
				<%= user.getUsername() %>
				登陆成功
				<td><%=user.getUsername() %></td>
			</td>
		</tr>
	<!--  	<tr>
			<td align="right">头像：</td>
			<td>
				<img src="">
			</td>
		</tr>
		-->
		<tr>
			<td align="right">性别：</td>
			<td>
				<%=user.getGender() %>
			</td>
		</tr>
		<tr>
			<td align="right">联系电话：</td>
			<td>
				<%=user.getTel() %>
			</td>
		</tr>
		<tr>
			<td align="right">电子邮件：</td>
			<td>
				<%=user.getEmail() %>
			</td>
		</tr>		
	</table>
	<% }else{out.print("你还没有登陆");} %>
	</body>
</html>