package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

/**
 * ����ͷ��URL
 */

public class HeadImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ������������ʽ
		req.setCharacterEncoding("utf-8");
		// ������Ӧ�����ʽ
		resp.setContentType("text/html;charset=utf-8");
		// ������������
		String uname = req.getParameter("uname");
		// ������������
		User user = UserDao.findUserByUname(uname);
		// ��Ӧ������
		// ֱ����Ӧ
		resp.getWriter().write(user.getHeadImg());
	}

}
