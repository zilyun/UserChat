package net.chat.action;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.chat.db.UserDAO;
import net.coomon.action.ActionForward;

public class UserRegisterServlet implements net.coomon.action.Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String userID = request.getParameter("userID");
		String userPassword1 = request.getParameter("userPassword1");
		String userPassword2 = request.getParameter("userPassword2");
		String userName = request.getParameter("userName");
		String userAge = request.getParameter("userAge");
		String userGender = request.getParameter("userGender");
		String userEmail = request.getParameter("userEmail");
		String userProfile = request.getParameter("userProfile");
		if (userID == null || userID.equals("") || 
			userPassword1 == null || userPassword1.equals("") || 
			userPassword2 == null || userPassword2.equals("") ||
			userName == null || userName.equals("") ||
			userAge == null || userAge.equals("") || 
			userGender == null || userGender.equals("") || 
			userEmail == null || userEmail.equals("")) {
			request.getSession().setAttribute("massageType", "오류메시지");
			request.getSession().setAttribute("messageContent", "비밀번호가 서로 다릅니다.");
			//response.sendRedirect("join.jsp");
			forward.setRedirect(true);
			forward.setPath("join.jsp");
			return forward;
		}
		if(!userPassword1.equals(userPassword2)) {
			request.getSession().setAttribute("messageType", "오류 메시지");
			request.getSession().setAttribute("messageContent", "비밀번호가 서로 다릅니다.");
			//response.sendRedirect("join.jsp");
			forward.setRedirect(true);
			forward.setPath("join.jsp");
			return forward;
		}
		int result = new UserDAO().register(userID, userPassword2, userName, userAge, userGender, userEmail, userProfile);
		if (result == 1) {
			request.getSession().setAttribute("userID", userID);
			request.getSession().setAttribute("messageType", "성공 메시지");
			request.getSession().setAttribute("messageContent", "회원가입에 성공했습니다.");
			//response.sendRedirect("index.jsp");
			forward.setRedirect(true);
			forward.setPath("index.jsp");
		} else {
			request.getSession().setAttribute("messageType", "오류 메시지");
			request.getSession().setAttribute("messageContent", "이미 존재하는 회원입니다.");
			//response.sendRedirect("join.jsp");
			forward.setRedirect(true);
			forward.setPath("join.jsp");
		}
		return forward;
	}	
}
