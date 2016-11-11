<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录界面</title>
</head>
<body>
	<form action="LoginServlet" method="post" onsubmit="return login(this);">
		<table align="center" width="300" border="0" class="tb1">
			<tr>
				<td align="right">用户名：</td>
				<td>
					<input type="text" name="username">
				</td>
			</tr>
			<tr>
				<td align="right">密码：</td>
				<td>
					<input type="password" name="password">
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2" height="50">				
					<input type="submit" value="登陆">
					<input type="reset" value="重置">
				</td>					
			</tr>
		</table>
	</form>
</body>
</html>