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
		//����ҳ���ֵ
				String username = req.getParameter("username");
				String password = req.getParameter("password");
				String gender = req.getParameter("gender");
				String photo = req.getParameter("photo");
				String tel = req.getParameter("tel");
				String email = req.getParameter("email");
				
				UserDao userDao = new UserDao();
				
				if (username!=null&&username.isEmpty()) {
					if (userDao.userExist(username)) {
						//ʵ����User����
						User user = new User();
						user.setUsername(username);
						user.setPassword(password);
						user.setGender(gender);
						user.setPhoto(photo);
						user.setTel(tel);
						user.setEmail(email);
						
						//�����û�ע����Ϣ
						userDao.saveUser(user);
						//��ʾ��Ϣ
						req.setAttribute("info", "ע��ɹ� <br>");
						
					}else {
						//��ʾ��Ϣ
						req.setAttribute("info", "ע��ʧ�ܣ��û����Ѿ�����");
					}
				}
				//zת����messageҳ��
				req.getRequestDispatcher("/WEB-INF/jsp/reg.jsp").forward(req, resp);
			
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	
	
	}
}
