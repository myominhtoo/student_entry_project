package student_registration.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student_registration.dao.DAO;
import student_registration.dto.StuDTO;
import student_registration.model.StuBean;

/**
 * Servlet implementation class studentDeleteServlet
 */
@WebServlet("/studentDeleteServlet")
public class studentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		StuBean stu = new StuBean();
		stu.setStuId(req.getParameter("id"));
		
		StuDTO dto = new StuDTO();
		dto.setStuId(stu.getStuId());
		
		DAO dao = new DAO();
		dao.deleteStu(dto);
		
		req.setAttribute("status","Successfully deleted!");
		req.getRequestDispatcher("selectAllStusServlet").forward(req, res);
	}

}
