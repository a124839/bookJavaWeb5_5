package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import dao.UserDao;

/**
 * @author 570
 *
 */
public class RegServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接受页面的值
				String username = req.getParameter("username");
				String password = req.getParameter("password");
				String gender = req.getParameter("gender");
				String photo = req.getParameter("photo");
				String tel = req.getParameter("tel");
				String email = req.getParameter("email");
				
				UserDao userDao = new UserDao();
				
				if (username!=null&&username.isEmpty()) {
					if (userDao.userExist(username)) {
						//实力话User对象
						User user = new User();
						user.setUsername(username);
						user.setPassword(password);
						user.setGender(gender);
						user.setPhoto(photo);
						user.setTel(tel);
						user.setEmail(email);
						
						//保存用户注册信息
						userDao.saveUser(user);
						//提示信息
						req.setAttribute("info", "注册成功 <br>");
						
					}else {
						//提示信息
						req.setAttribute("info", "注册失败，用户名已经存在");
					}
				}
				//z转发到message页面
				req.getRequestDispatcher("/WEB-INF/jsp/reg.jsp").forward(req, resp);
			
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	
	
	}
}
