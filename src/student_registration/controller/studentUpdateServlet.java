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
 * Servlet implementation class studentUpdateServlet
 */
@WebServlet("/studentUpdateServlet")
public class studentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		StuBean stu = new StuBean();
		stu.setStuId(req.getParameter("id"));
		
		StuDTO dto = new StuDTO();
		dto.setStuId(stu.getStuId());
		
		DAO dao = new DAO();
		StuDTO data = dao.takeOneStu(dto);
		req.setAttribute("data",data);
		req.getRequestDispatcher("studentupdatepage.jsp").forward(req, res);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		StuBean stu = new StuBean();
		stu.setStuId(req.getParameter("id"));
		stu.setName(req.getParameter("name"));
		stu.setClassName(req.getParameter("className"));
		stu.setRegisteredDate(req.getParameter("registeredDate"));
		stu.setStatus(req.getParameter("status"));
		System.out.println(stu.getClassName());
		
		if(stu.getStuId() == "" || stu.getStatus() == null || stu.getClassName() == null || stu.getName() == "" || stu.getRegisteredDate() == "") {
			req.setAttribute("error", "Input can't be blank!");
			req.setAttribute("data",stu);
			req.getRequestDispatcher("studentupdatepage.jsp").forward(req, res);
		}else {
			StuDTO dto = new StuDTO();
			dto.setStuId(stu.getStuId());
			dto.setName(stu.getName());
			dto.setClassName(stu.getClassName());
			dto.setRegisteredDate(stu.getRegisteredDate());
			dto.setStatus(stu.getStatus());
			DAO dao = new DAO();
			dao.updateStu(dto);
			req.setAttribute("status","Successfully updated!");
			res.sendRedirect("selectAllStusServlet");
		}
		
	}

}
