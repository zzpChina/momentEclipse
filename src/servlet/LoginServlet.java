package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

/**
 * 判断用户登录处理
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置请求编码
		req.setCharacterEncoding("utf-8");
		// 设置响应编码
		resp.setContentType("text/html;charset=utf-8");
		// 获取请求结果
		// 获取用户名
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		User user = UserDao.findUserByUnameAndPassword(uname, pwd);
		if (user != null) {
			// 直接响应
			resp.getWriter().write("yes");
		} else {
			resp.getWriter().write("no");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
