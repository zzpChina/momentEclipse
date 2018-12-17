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
 * Ⱥ�鶯̬����
 */
public class GetMoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// �����������
		req.setCharacterEncoding("utf-8");
		// ������Ӧ����
		resp.setContentType("text/html;charset=utf-8");
		// ��ȡ��������
		String uname = req.getParameter("uname");
		String content = req.getParameter("content");
		String moodImg = req.getParameter("moodImgUrl");
		// ������������
		User user = UserDao.findUserByUname(uname);

		if (user != null) {
			Mood m = new Mood(user.getHeadImg(), user.getUname(), content, moodImg);
			String addMood = m.getMoodItem();
			if (!MoodDao.getGroupNum(uname).equals("") && MoodDao.getGroupNum(uname) != null) {
				List<User> list = MoodDao.getUsersByGroup(MoodDao.getGroupNum(uname));
				boolean b = false;
				if (list != null) {
					for (User temp : list) {
						String newMood = "";
						String tempUname = temp.getUname();
						String oldMood = MoodDao.getMoods(tempUname);
						if (oldMood == null || oldMood.equals("")) {
							newMood = addMood;
							b = MoodDao.setMoods(tempUname, newMood);
						} else {
							newMood = addMood + "--" + oldMood;
							b = MoodDao.setMoods(tempUname, newMood);
						}
					}
					if (b) {
						resp.getWriter().write("yes");
						return;
					} else {
						resp.getWriter().write("no");
						return;
					}
				}
			} else {
				resp.getWriter().write("no");
				return;
			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

}