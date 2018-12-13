package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MoodDao;

/**
 * Servlet implementation class GetGroupServlet
 */

public class GetGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//…Ë÷√«Î«Û±‡¬Î
		req.setCharacterEncoding("utf-8");
		//…Ë÷√œÏ”¶±‡¬Î
		resp.setContentType("text/html;charset=utf-8");
		
		String uname=req.getParameter("uname");
		String groupNum=req.getParameter("groupNum");
		
		boolean b=MoodDao.registerGroup(uname, groupNum);
		
		if(b) {
			resp.getWriter().write("yes");
		}else {
			resp.getWriter().write("no");
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
   

}
