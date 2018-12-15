package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MoodDao;
import model.Mood;

/**
 * ��������Ȧ��̬����
 */

public class ReturnMoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//�����������
		req.setCharacterEncoding("utf-8");
		//�����������
		resp.setContentType("text/html;charset=utf-8");
		//��ȡ��������
		String uname=req.getParameter("uname");
		System.out.println(uname);
		//������������
		String result=MoodDao.getMoods(uname);
		if(result==null||result.equals("")) {
			resp.getWriter().write(new Mood("img/system.png","ϵͳ��ʾ","����ʱû�ж�̬","img/system.png").getMoodItem());
			return;
		}
		System.out.println(result);
//		String results[]=result.split("--");
		//��Ӧ������
			//ֱ����Ӧ
		resp.getWriter().write(result);
			//����ת��
			//�ض���
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
     
	

}
