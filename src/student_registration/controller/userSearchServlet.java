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
 * Servlet implementation class userSearchServlet
 */
@WebServlet("/userSearchServlet")
public class userSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		UserBean user = new UserBean();
		user.setName(req.getParameter("name"));
		user.setEmail(req.getParameter("email"));
		
		if(user.getName() == "" && user.getEmail() == "") {
			req.setAttribute("error","Invalid search!");
			req.getRequestDispatcher("usersearch.jsp").forward(req, res);
		}else {
			UserDTO dto = new UserDTO();
			dto.setName(user.getName());
			dto.setEmail(user.getEmail());
			
			DAO dao = new DAO();
			UserDTO result = dao.takeUser(dto);
			
			
			if(result.getId() != 0 || result.getEmail() != null || result.getName() != null) {
				req.setAttribute("status","Founded!");
				req.setAttribute("user",result);
			}else {
				req.setAttribute("status", "Did not found!");
			}
			req.getRequestDispatcher("usersearch.jsp").forward(req, res);
		}
	}

}
