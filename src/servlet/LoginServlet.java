package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

/**
 * �ж��û���¼����
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// �����������
		req.setCharacterEncoding("utf-8");
		// ������Ӧ����
		resp.setContentType("text/html;charset=utf-8");
		// ��ȡ������
		// ��ȡ�û���
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		User user = UserDao.findUserByUnameAndPassword(uname, pwd);
		if (user != null) {
			// ֱ����Ӧ
			resp.getWriter().write("yes");
		} else {
			resp.getWriter().write("no");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
