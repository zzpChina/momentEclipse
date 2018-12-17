package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

/**
 * ÐÞ¸ÄÃÜÂë
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("type/html;charset=utf-8");
		String uname = req.getParameter("uname");
		String oldPwd = req.getParameter("oldPwd");
		String newPwd = req.getParameter("newPwd");
		if (oldPwd.equals(UserDao.findUserByUname(uname).getPassword()) && UserDao.updateUser(uname, newPwd)) {

			resp.getWriter().write("yes");
		} else {
			resp.getWriter().write("no");
		}

	}

}
