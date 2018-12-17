package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

/**
 * 返回头像URL
 */

public class HeadImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置请求编码格式
		req.setCharacterEncoding("utf-8");
		// 设置响应编码格式
		resp.setContentType("text/html;charset=utf-8");
		// 接收请求数据
		String uname = req.getParameter("uname");
		// 处理请求数据
		User user = UserDao.findUserByUname(uname);
		// 响应处理结果
		// 直接响应
		resp.getWriter().write(user.getHeadImg());
	}

}
