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
 * Servlet implementation class userUpdateServlet
 */
@WebServlet("/userUpdateServlet")
public class userUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		UserBean user = new UserBean();
		user.setEmail(req.getParameter("email"));
		
		UserDTO dto = new UserDTO();
		dto.setEmail(user.getEmail());
		
		DAO dao = new DAO();
		UserDTO result = dao.takeUser(dto);
		req.setAttribute("user",result);
		req.getRequestDispatcher("userupdatepage.jsp").forward(req, res);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		UserBean user = new UserBean();
		user.setId(Integer.parseInt(req.getParameter("id")));
		user.setName(req.getParameter("name"));
		user.setEmail(req.getParameter("email"));
		user.setPassword(req.getParameter("password"));
		
		if(user.getName() == "" || user.getEmail() == "" || user.getPassword() == "") {
			req.setAttribute("error","Complete fields!");
			req.setAttribute("user",user);
			req.getRequestDispatcher("userupdatepage.jsp").forward(req,res);
		}else {
			UserDTO dto = new UserDTO();
			dto.setName(user.getName());
			dto.setEmail(user.getEmail());
			dto.setPassword(user.getPassword());
			dto.setId(user.getId());
			
			DAO dao = new DAO();
			dao.updateUser(dto);
			req.setAttribute("status","Successfully updated!");
			res.sendRedirect("selectAllUserServlet");
		}
	}

}
