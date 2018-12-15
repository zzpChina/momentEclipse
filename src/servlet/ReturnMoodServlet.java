package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MoodDao;
import model.Mood;

/**
 * 传回朋友圈动态处理
 */

public class ReturnMoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置请求编码
		req.setCharacterEncoding("utf-8");
		//设置请求编码
		resp.setContentType("text/html;charset=utf-8");
		//获取请求数据
		String uname=req.getParameter("uname");
		System.out.println(uname);
		//处理请求数据
		String result=MoodDao.getMoods(uname);
		if(result==null||result.equals("")) {
			resp.getWriter().write(new Mood("img/system.png","系统提示","您暂时没有动态","img/system.png").getMoodItem());
			return;
		}
		System.out.println(result);
//		String results[]=result.split("--");
		//响应处理结果
			//直接响应
		resp.getWriter().write(result);
			//请求转发
			//重定向
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
     
	

}
