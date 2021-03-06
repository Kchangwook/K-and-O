package project.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.dao.MemberDao;
import project.dto.Member;

/** 회원가입을 활용하기 위한 servlet */
@WebServlet("/Join.do")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		process(request, response);
	}

	/** 회원가입을 위해 데이터를 입력하는 함수 */
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		Member member = new Member(request.getParameter("id"), request.getParameter("password"), request.getParameter("name"), request.getParameter("email"), request.getParameter("phone"));
		String url = null;
		String msg = null;
		StringBuilder s = new StringBuilder();
		try {
			msg = MemberDao.join(member);
			System.out.println(msg);
			url = "index.jsp";
		} catch (Exception e) {
			// TODO: handle exception
		}
		
//		request.setAttribute("msg", msg);
		s.append(url);
		s.append("?msg=");
		s.append(URLEncoder.encode(msg, "UTF-8"));
		
		response.sendRedirect(s.toString());
		
	}
}
