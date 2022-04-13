package student_registration.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student_registration.dao.DAO;
import student_registration.dto.StuDTO;

/**
 * Servlet implementation class selectAllStusServlet
 */
@WebServlet("/selectAllStusServlet")
public class selectAllStusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		DAO dao = new DAO();
		
		ArrayList<StuDTO> stus = dao.takeAllStu();
		req.setAttribute("stus",stus);
		req.setAttribute("status", req.getAttribute("status"));
		req.getRequestDispatcher("studentsearch.jsp").forward(req, res);
	}
}
