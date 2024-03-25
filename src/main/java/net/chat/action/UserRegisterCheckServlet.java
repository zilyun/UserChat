package net.chat.action;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.chat.db.UserDAO;
import net.coomon.action.Action;
import net.coomon.action.ActionForward;

public class UserRegisterCheckServlet implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String userID = request.getParameter("userID");
		response.getWriter().write(new UserDAO().registerCheck(userID) + "");
		return null;
	}
}
