package student_registration.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student_registration.dao.DAO;
import student_registration.dto.UserDTO;
import student_registration.model.UserBean;

/**
 * Servlet implementation class userDeleteServlet
 */
@WebServlet("/userDeleteServlet")
public class userDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		UserBean user = new UserBean();
		user.setId(Integer.parseInt(req.getParameter("id")));
		
		UserDTO dto = new UserDTO();
		dto.setId(user.getId());
		
		DAO dao = new DAO();
		dao.deleteUser(dto);
		
		req.setAttribute("status","Successfully Deleted!");
		req.getRequestDispatcher("selectAllUserServlet").forward(req,res);
		
	}

	
}
