package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MoodDao;

/**
 * 选择群组处理
 */

public class GetGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置请求编码
		req.setCharacterEncoding("utf-8");
		// 设置响应编码
		resp.setContentType("text/html;charset=utf-8");

		String uname = req.getParameter("uname");
		String groupNum = req.getParameter("groupNum");

		boolean b = MoodDao.registerGroup(uname, groupNum);

		if (b) {
			resp.getWriter().write("yes");
		} else {
			resp.getWriter().write("no");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
