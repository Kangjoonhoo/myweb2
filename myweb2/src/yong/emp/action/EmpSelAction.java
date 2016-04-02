package yong.emp.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yong.command.CommandHandler;
import yong.emp.model.EmpDAO;
import yong.emp.model.EmpDTO;

public class EmpSelAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("userName");
		EmpDAO dao = new EmpDAO();
		ArrayList<EmpDTO> arr = dao.empSel(name);
		
		req.setAttribute("empSel", arr);
		return "/emp/empSel.jsp";
	}

}
