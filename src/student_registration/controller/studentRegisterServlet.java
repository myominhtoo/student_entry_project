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
 * Servlet implementation class studentRegisterServlet
 */
@WebServlet("/studentRegisterServlet")
public class studentRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		StuBean stu = new StuBean();
		stu.setStuId(req.getParameter("id"));
		stu.setName(req.getParameter("name"));
		stu.setClassName(req.getParameter("className"));
		stu.setRegisteredDate(req.getParameter("registeredDate"));
		stu.setStatus(req.getParameter("status"));
		
		if(stu.getStuId() == "" || stu.getName() == "" || stu.getClassName() == "" || stu.getRegisteredDate() == "" || stu.getStatus() == "") {
			req.setAttribute("error","Inputs can't be blank!");
			req.setAttribute("stu",stu);
			req.getRequestDispatcher("studentregister.jsp").forward(req, res);
		}else {
			StuDTO dto = new StuDTO();
			dto.setStuId(stu.getStuId());
			dto.setName(stu.getName());
			dto.setClassName(stu.getClassName());
			dto.setRegisteredDate(stu.getRegisteredDate());
			dto.setStatus(stu.getStatus());
			
			DAO dao = new DAO();
			dao.insertStu(dto);
			
			req.setAttribute("status","Successfully Added!");
			res.sendRedirect("selectAllStusServlet");
		}
	}

}
