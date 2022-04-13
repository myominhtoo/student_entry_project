package student_registration.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import student_registration.dto.ClassDTO;
import student_registration.dto.StuDTO;
import student_registration.dto.UserDTO;

public class DAO {
	//getting connection
	DB db = new DB();
	Connection con = db.con;
	
	//method for insert
	public void insertUser(UserDTO dto) {
		try {
			String query = "INSERT INTO users (name,email,password) VALUES(?,?,?)";
			PreparedStatement pre = con.prepareStatement(query);
			pre.setString(1,dto.getName());
			pre.setString(2,dto.getEmail());
			pre.setString(3,dto.getPassword());
			
			pre.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//method for select user
	public UserDTO takeUser(UserDTO dto) {
		UserDTO result = new UserDTO();
		try {
			String query = "SELECT * FROM users where email = ?";
			PreparedStatement pre = con.prepareStatement(query);
			pre.setString(1,dto.getEmail());
			ResultSet set = pre.executeQuery();
			
			while(set.next()) {
				result.setId(set.getInt("user_id"));
				result.setName(set.getString("name"));
				result.setEmail(set.getString("email"));
				result.setPassword(set.getString("password"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//method for take one student
			public void  updateUser(UserDTO dto) {
				try {
					String query = "UPDATE users SET  name = ? , email = ? ,password = ?  WHERE user_id = ?";
					PreparedStatement pre = con.prepareStatement(query);
					pre.setString(1, dto.getName());
					pre.setString(2, dto.getEmail());
					pre.setString(3, dto.getPassword());
					pre.setInt(4, dto.getId());
					pre.executeUpdate();
					
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
			}
			
			//method delete for users
			public void  deleteUser(UserDTO dto) {
				try {
					String query = "DELETE FROM users WHERE user_id = ?";
					PreparedStatement pre = con.prepareStatement(query);
					pre.setInt(1, dto.getId());
					pre.executeUpdate();
					
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
			}
			
	//method for select all users
	public ArrayList<UserDTO> takeAllUsers(){
		ArrayList<UserDTO> result = new ArrayList<>();
		try {
			String query = "SELECT * FROM users";
			PreparedStatement pre = con.prepareStatement(query);
			
			ResultSet set = pre.executeQuery();
			
			while(set.next()) {
				UserDTO user = new UserDTO();
				user.setId(set.getInt("user_id"));
				user.setName(set.getString("name"));
				user.setEmail(set.getString("email"));
				user.setPassword(set.getString("password"));
				result.add(user);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	//method for insert class
	public void insertClass(ClassDTO dto) {
		try {
			String query = "INSERT INTO classes (id,class_name,start_date,duration,fees) values(?,?,?,?,?)";
			PreparedStatement pre = con.prepareStatement(query);
			pre.setString(1, dto.getClassId());
			pre.setString(2,dto.getClassName());
			pre.setString(3, dto.getStartDate());
			pre.setString(4,dto.getDuration());
			pre.setString(5,dto.getFees());			
			pre.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//method for select class
	public ArrayList<ClassDTO> takeClasses() {
		ArrayList<ClassDTO> classes = new ArrayList<>();
		try {
			String query = "SELECT * FROM classes";
			PreparedStatement pre = con.prepareStatement(query);
			ResultSet set = pre.executeQuery();
			
			while(set.next()) {
				ClassDTO dto = new ClassDTO();
				dto.setClassId(set.getString("id"));
				dto.setClassName(set.getString("class_name"));
				dto.setStartDate(set.getString("start_date"));
				dto.setDuration(set.getString("duration"));
				dto.setFees(set.getString("fees"));
				classes.add(dto);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return classes;
	}
	
	//method for insert student
	public void insertStu(StuDTO dto) {
		try {
			String query = "INSERT INTO students (id,name,class_name,registered_date,status) VALUES(?,?,?,?,?)";
			PreparedStatement pre = con.prepareStatement(query);
			pre.setString(1,dto.getStuId());
			pre.setString(2,dto.getName());
			pre.setString(3,dto.getClassName());
			pre.setString(4,dto.getRegisteredDate());
			pre.setString(5,dto.getStatus());
			
			pre.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//method for take one student
	public StuDTO takeOneStu(StuDTO dto) {
		StuDTO result = new StuDTO();
		try {
			String query = "SELECT * FROM students WHERE id = ?";
			PreparedStatement pre = con.prepareStatement(query);
			pre.setString(1, dto.getStuId());
			
			ResultSet set = pre.executeQuery();
			while(set.next()) {
				result.setStuId(set.getString("id"));
				result.setName(set.getString("name"));
				result.setClassName(set.getString("class_name"));
				result.setRegisteredDate(set.getString("registered_date"));
				result.setStatus(set.getString("status"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//method for take one student
		public ArrayList<StuDTO> takeAllStu() {
			ArrayList<StuDTO> result = new ArrayList<>();
			try {
				String query = "SELECT * FROM students";
				PreparedStatement pre = con.prepareStatement(query);
				
				ResultSet set = pre.executeQuery();
				while(set.next()) {
					StuDTO stu = new StuDTO();
					stu.setStuId(set.getString("id"));
					stu.setName(set.getString("name"));
					stu.setClassName(set.getString("class_name"));
					stu.setRegisteredDate(set.getString("registered_date"));
					stu.setStatus(set.getString("status"));
					result.add(stu);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return result;
		}
		
		//method for take one student
		public void  updateStu(StuDTO dto) {
			try {
				String query = "UPDATE students SET  name = ? , class_name = ? , registered_date = ? , status = ?  WHERE id = ?";
				PreparedStatement pre = con.prepareStatement(query);
				pre.setString(1, dto.getName());
				pre.setString(2, dto.getClassName());
				pre.setString(3, dto.getRegisteredDate());
				pre.setString(4, dto.getStatus());
				pre.setString(5, dto.getStuId());
				pre.executeUpdate();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		//method for delete one student
				public void  deleteStu(StuDTO dto) {
					try {
						String query = "DELETE FROM students WHERE id = ?";
						PreparedStatement pre = con.prepareStatement(query);
						pre.setString(1, dto.getStuId());
						pre.executeUpdate();
						
					}catch(SQLException e) {
						e.printStackTrace();
					}
					
				}
}
