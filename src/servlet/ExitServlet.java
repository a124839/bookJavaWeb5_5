package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;

public class ExitServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取session
		HttpSession httpSession = req.getSession();
		//获取用户对象
		User user = (User) httpSession.getAttribute("user");
		//判断用户是否有效？
		if (user!=null) {
			httpSession.removeAttribute("user");
			//提示信息
			req.setAttribute("info", user.getUsername()+"已成功退出");
		}
		req.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(req, resp);
}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	
	}
}
