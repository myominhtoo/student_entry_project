package student_registration.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student_registration.dao.DAO;
import student_registration.dto.ClassDTO;
import student_registration.model.ClassBean;

/**
 * Servlet implementation class classRegisterServlet
 */
@WebServlet("/classRegisterServlet")
public class classRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ClassBean cls = new ClassBean();
		cls.setClassId(req.getParameter("id"));
		cls.setClassName(req.getParameter("name"));
		cls.setStartDate(req.getParameter("start"));
		cls.setDuration(req.getParameter("duration"));
		cls.setFees(req.getParameter("fees"));
		
//		System.out.print(cls.getClassId()+""+cls.getClassName()+""+cls.getStartDate()+""+cls.getDuration()+""+cls.getFees());
		
		if(cls.getClassId() == "" || cls.getClassName() == "" || cls.getStartDate() == "" || cls.getDuration() == "" || cls.getFees() == "") {
			req.setAttribute("error","Input can't be blank!");
			req.setAttribute("cls",cls);
			req.getRequestDispatcher("classregister.jsp").forward(req, res);
		}else {
			ClassDTO dto = new ClassDTO();
			dto.setClassId(cls.getClassId());
			dto.setClassName(cls.getClassName());
			dto.setStartDate(cls.getStartDate());
			dto.setDuration(cls.getDuration());
			dto.setFees(cls.getFees());
			
			DAO dao = new DAO();
			dao.insertClass(dto);
			
			req.setAttribute("status","Successfully added!");
			req.getRequestDispatcher("classregister.jsp").forward(req, res);
		}
	}

}
