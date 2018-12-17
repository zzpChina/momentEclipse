package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

/**
 * 注册处理
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置请求编码'
		req.setCharacterEncoding("utf-8");
		// 设置响应编码
		resp.setContentType("text/html;charset=utf-8");
		// 获取请求信息
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("password");
		String sex = req.getParameter("sex");
		// 处理请求信息
		boolean b = UserDao.insertUser(uname, pwd, sex);
		// 响应处理结果
		// 直接响应
		if (b) {
			resp.getWriter().write("yes");
		} else {
			resp.getWriter().write("no");
		}

		// 请求转发
		// 重定向
	}

}
