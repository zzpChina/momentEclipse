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
 * 仅自己可见动态处理
 * @author zzpComputer
 *
 */
public class GetMoodPrivateServlet extends HttpServlet{

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
			
			if(user!=null) {
				
				Mood m=new Mood(user.getHeadImg(),user.getUname(),content);
				String addMood=m.getMoodItem();
				String oldMood=MoodDao.getMoods(uname);
				String newMood;
				if(oldMood==null) {
					newMood=addMood;
				}else {
					newMood=addMood+"--"+oldMood;
				}
				boolean b=MoodDao.setMoods(uname,newMood);
				if(b) {
					resp.getWriter().write("yes");
				}else {
					resp.getWriter().write("no");
				}
			}
		}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
