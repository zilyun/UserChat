package net.chat.action;

import java.io.IOException;
import java.net.URLDecoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.chat.db.ChatDAO;
import net.coomon.action.Action;
import net.coomon.action.ActionForward;

public class ChatSubmitServlet implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String fromID = request.getParameter("fromID");
		String toID = request.getParameter("toID");
		String chatContent = request.getParameter("chatContent");
		if(fromID == null || fromID.equals("") || toID == null || toID.equals("") 
				|| chatContent == null || chatContent.equals("")) {
			response.getWriter().write("0");
		} else {
			fromID = URLDecoder.decode(fromID, "UTF-8");
			toID = URLDecoder.decode(toID, "UTF-8");
			chatContent = URLDecoder.decode(chatContent, "UTF-8");
			response.getWriter().write(new ChatDAO().submit(fromID, toID, chatContent));
		}
		return null;
	}

}
