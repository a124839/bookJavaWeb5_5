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
 * servlet的主要功能
 * 1.接收页面的值
 * 2.向页面传值
 * 3.根据业务需要调用service
 * 4.跳转页面
 *
 */
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");//拿到页面的username的值给username
		String password = req.getParameter("password");
		//实例化UserDao对象
		UserDao userDao = new UserDao();
		//根据密码查询用户
		User user = userDao.login(username, password);
		//判断user是否为空
		if (user!=null) {
			//将用户对象放入Session中
			req.getSession().setAttribute("user", user);
			//转发result.jsp页面
			req.getRequestDispatcher("message.jsp").forward(req, resp);			
		}else {
			//登陆失败
			req.setAttribute("info", "错误，用户名或密码错误");
			req.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
	
}
