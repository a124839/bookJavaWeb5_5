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
		//��ȡsession
		HttpSession httpSession = req.getSession();
		//��ȡ�û�����
		User user = (User) httpSession.getAttribute("user");
		//�ж��û��Ƿ���Ч��
		if (user!=null) {
			httpSession.removeAttribute("user");
			//��ʾ��Ϣ
			req.setAttribute("info", user.getUsername()+"�ѳɹ��˳�");
		}
		req.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(req, resp);
}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	
	}
}
