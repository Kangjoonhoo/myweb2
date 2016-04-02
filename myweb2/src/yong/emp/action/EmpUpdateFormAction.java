package yong.emp.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yong.command.CommandHandler;
import yong.emp.model.EmpDAO;
import yong.emp.model.EmpDTO;

public class EmpUpdateFormAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String idx_s = req.getParameter("idx");
		if(idx_s==null||idx_s.equals("")){
			idx_s="0";
		}
		int idx = Integer.parseInt(idx_s);
		EmpDAO dao = new EmpDAO();
		EmpDTO dto = dao.empUpdateInfo(idx);
		
		String page = "";
		if(dto==null){
			page="/emp/empMsg.jsp";
			req.setAttribute("msg", "잘못된 사원번호입니다.");
		}else{
			page="/emp/empUpdate.jsp";
			req.setAttribute("dto", dto);
		}
		return page;
	}

}
