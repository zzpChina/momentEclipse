package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

/**
 * 
 * @author zzpComputer
 *
 */
public class ReturnHeadUrl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		resp.setContentType("type/html;charset=utf-8");
		String uname = req.getParameter("uname");

		User user = UserDao.findUserByUname(uname);
		if (user != null) {
			resp.getWriter().write(user.getHeadImg());
		} else {
			resp.getWriter().write("img/anoymous.png");
		}

	}

}
