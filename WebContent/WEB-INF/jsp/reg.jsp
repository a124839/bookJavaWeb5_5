<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册页面</title>
</head>
<body>
	<form action="RegServlet" method="post" onsubmit="return reg(this);">
		<table align="center" width="450" border="0">
			<tr>
				<td align="right">用户名：</td>
				<td>
					<input type="text" name="username">
				</td>
			</tr>
			<tr>
				<td align="right">密码：</td>
				<td>
					<input type="password" name=""password"">
				</td>
			</tr>
			<tr>
				<td align="right">确认密码：</td>
				<td>
					<input type="password" name="username">
				</td>
			</tr>
			<tr>
				<td align="right">性别：</td>
				<td>
					<input type="radio" name="gender" value="男" checked="checked">男
					<input type="radio" name="gender" value="女">女
				</td>
			</tr>
			<tr>
				<td align="right">头像：</td>
				<td>
					<select name="photo" id="photo" onchange="change();">
						<option value="images/1.gif" selected="selected">头像一</option>
						<option value="images/1.gif">头像二</option>
					</select>
					<img id="photoImg" src="images/1.gif">
				</td>
			</tr>
			<tr>
				<td align="right">联系电话：</td>
				<td>
					<input type="text" name="tel">
				</td>
			</tr>
			<tr>
				<td align="right">电子邮件：</td>
				<td>
					<input type="text" name="email">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="注册">
					<input type="reset" value="重置">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>