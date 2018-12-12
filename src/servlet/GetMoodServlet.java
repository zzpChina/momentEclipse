package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MoodDao;
import dao.UserDao;
import model.Mood;
import model.User;

/**
 * Servlet implementation class GetMoodServlet
 */
public class GetMoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//设置请求编码
			req.setCharacterEncoding("utf-8");
		//设置响应编码
			resp.setContentType("text/html;charset=utf-8");
		//获取请求数据
			String uname=req.getParameter("uname");
			String content=req.getParameter("content");
		//处理请求数据
			User user=UserDao.findUserByUname(uname);
			Mood m=new Mood(user.getHeadImg(),user.getUname(),content);
			String addMood=m.getMoodItem();
			if(user!=null) {
				String oldMood=MoodDao.getMoods(uname);
				String newMood=addMood+"--"+oldMood;
				boolean b=MoodDao.setMoods(uname,newMood);
				if(b) {
					resp.getWriter().write("yes");
				}else {
					resp.getWriter().write("no");
				}
			}
			
		//响应处理结果
			
			//响应

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
   
	
}
