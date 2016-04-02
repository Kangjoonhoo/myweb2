package yong.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContentAction implements CommandHandler {

	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String result = "커맨드 패턴을 이용한 본문보기 기능";
		req.setAttribute("result", result);
		return "/content.jsp";
	}

}
