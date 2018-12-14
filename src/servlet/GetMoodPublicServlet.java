package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MoodDao;
import dao.UserDao;
import model.Mood;
import model.User;

/**
 * Servlet implementation class GetMoodPublicServlet
 */
public class GetMoodPublicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("��������");
		//�����������
		req.setCharacterEncoding("utf-8");
	//������Ӧ����
		resp.setContentType("text/html;charset=utf-8");
	//��ȡ��������
		String uname=req.getParameter("uname");
		String content=req.getParameter("content");
	//������������
		
		User user=UserDao.findUserByUname(uname);
		if(user!=null) {
			Mood m=new Mood(user.getHeadImg(),user.getUname(),content);
			String addMood=m.getMoodItem();
			List<User> list=MoodDao.getAllUsers();
			System.out.println("�û�����:"+list.size());
			if(list!=null) {
				for(User temp:list) {
					String newMood="";
					String tempUname=temp.getUname();
					String oldMood=MoodDao.getMoods(tempUname);
					if(oldMood==null||oldMood.equals("")) {
						newMood=addMood;
						boolean b=MoodDao.setMoods(tempUname,newMood);
						if(b) {
							resp.getWriter().write("yes");
						}else {
							resp.getWriter().write("no");
						}
					}else {
						newMood=addMood+"--"+oldMood;
						boolean b=MoodDao.setMoods(tempUname,newMood);
						if(b) {
							resp.getWriter().write("yes");
						}else {
							resp.getWriter().write("no");
						}
					}
				}
			}
			
		}else {
			resp.getWriter().write("no");
		}
	}
       
    

}