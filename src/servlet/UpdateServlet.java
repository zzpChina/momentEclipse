package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

/**
 *修改密码
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("熙哥哥");
		req.setCharacterEncoding("utf-8");
		resp.setContentType("type/html;charset=utf-8");
		String uname=req.getParameter("uname");
		String oldPwd=req.getParameter("oldPwd");
		String newPwd=req.getParameter("newPwd");
		System.out.println(uname);
		System.out.println(oldPwd);
		System.out.println(UserDao.findUserByUname(uname).getPassword());
		//处理数据
		if(oldPwd.equals(UserDao.findUserByUname(uname).getPassword())&&UserDao.updateUser(uname, newPwd)) {
			
			resp.getWriter().write("yes");
		}else {
			resp.getWriter().write("no");
		}
		
	}


}
