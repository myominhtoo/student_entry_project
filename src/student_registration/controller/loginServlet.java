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
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		UserBean user = new UserBean();
		user.setEmail(req.getParameter("email"));
		user.setPassword(req.getParameter("password"));
		
		if(user.getEmail() == "" || user.getPassword() == "") {
			req.setAttribute("error","Please fill inputs!");
			req.setAttribute("user",user);
			
			req.getRequestDispatcher("login.jsp").forward(req, res);
		}else {
			UserDTO dto = new UserDTO();
			dto.setEmail(user.getEmail());
			
			DAO dao = new DAO();
			UserDTO result = dao.takeUser(dto);
			
			if(result.getEmail() == null || result.getName() == null ){
				req.setAttribute("error","Invalid email or password!");
				req.getRequestDispatcher("login.jsp").forward(req, res);
			}else if(result.getEmail().equals(user.getEmail()) && result.getPassword().equals(user.getPassword())) {
				req.getSession().setAttribute("acc",result);
				req.setAttribute("user",user);
				req.getRequestDispatcher("home.jsp").forward(req, res);
			}else {
				req.setAttribute("error","Invalid email or password!");
				req.setAttribute("user",user);
				req.getRequestDispatcher("login.jsp").forward(req, res);
			}
		}
	}

}
