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
 * Servlet implementation class userRegisterServlet
 */
@WebServlet("/userRegisterServlet")
public class userRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//create user obj
		UserBean user = new UserBean();
		user.setName(req.getParameter("name"));
		user.setEmail(req.getParameter("email"));
		user.setPassword(req.getParameter("password"));
		
		if(user.getName() == "" || user.getEmail() == "" || user.getPassword() == ""){
			req.setAttribute("user",user);
			req.setAttribute("error","Please fill the inputs!");
			req.getRequestDispatcher("userregister.jsp").forward(req,res);
		}else {
			UserDTO dto = new UserDTO();
			dto.setName(user.getName());
			dto.setEmail(user.getEmail());
			dto.setPassword(user.getPassword());
			
			DAO dao = new DAO();
			dao.insertUser(dto);
			
//			req.setAttribute("status","Successfully Saved!");
			res.sendRedirect("selectAllUserServlet");
		}
	}
}
