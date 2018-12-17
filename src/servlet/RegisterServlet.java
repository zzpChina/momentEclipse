package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

/**
 * ע�ᴦ��
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// �����������'
		req.setCharacterEncoding("utf-8");
		// ������Ӧ����
		resp.setContentType("text/html;charset=utf-8");
		// ��ȡ������Ϣ
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("password");
		String sex = req.getParameter("sex");
		// ����������Ϣ
		boolean b = UserDao.insertUser(uname, pwd, sex);
		// ��Ӧ������
		// ֱ����Ӧ
		if (b) {
			resp.getWriter().write("yes");
		} else {
			resp.getWriter().write("no");
		}

		// ����ת��
		// �ض���
	}

}
