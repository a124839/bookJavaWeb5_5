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
 * servlet����Ҫ����
 * 1.����ҳ���ֵ
 * 2.��ҳ�洫ֵ
 * 3.����ҵ����Ҫ����service
 * 4.��תҳ��
 *
 */
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");//�õ�ҳ���username��ֵ��username
		String password = req.getParameter("password");
		//ʵ����UserDao����
		UserDao userDao = new UserDao();
		//���������ѯ�û�
		User user = userDao.login(username, password);
		//�ж�user�Ƿ�Ϊ��
		if (user!=null) {
			//���û��������Session��
			req.getSession().setAttribute("user", user);
			//ת��result.jspҳ��
			req.getRequestDispatcher("message.jsp").forward(req, resp);			
		}else {
			//��½ʧ��
			req.setAttribute("info", "�����û������������");
			req.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
	
}
