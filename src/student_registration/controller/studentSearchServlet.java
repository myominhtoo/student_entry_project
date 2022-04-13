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
 * Servlet implementation class studentSearchServlet
 */
@WebServlet("/studentSearchServlet")
public class studentSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		StuBean stu = new StuBean();
		stu.setStuId(req.getParameter("id"));
		
		if(stu.getStuId() == ""){
			req.setAttribute("error","Input can't be blank!");
			req.getRequestDispatcher("studentsearch.jsp").forward(req, res);
		}else {
			StuDTO dto = new StuDTO();
			dto.setStuId(stu.getStuId());
			
			DAO dao = new DAO();
			StuDTO result = dao.takeOneStu(dto);
			
			if(result.getStuId() != null && result.getName() != null && result.getClassName() != null && result.getRegisteredDate() != null && result.getStatus() != null) {
				req.setAttribute("status","Founded!");
				req.setAttribute("stu",result);
			}else {
				req.setAttribute("data",stu);
				req.setAttribute("status", "Did not found!");
			}
			req.getRequestDispatcher("studentsearch.jsp").forward(req, res);
		}
		
	}

}
