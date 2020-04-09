package dao;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import model.User;
import utility.ConnectionManager;

public class UserDAO implements UserDaoInterface {

	@Override
	public int signUP(User user) throws ClassNotFoundException, SQLException, IOException {
		
		int checkUser = 0;
		
		String email = user.getEmail();
		String password = user.getPassword();
		String Confirmpassword = user.getConfirmpassword();
		
		LocalDate localdate = user.getDate();
		
		ConnectionManager cm = new ConnectionManager();
		
		String sql = "insert into blog(email,password,dt)values(?,?,?)";
		
		PreparedStatement st = cm.getconnection().prepareStatement(sql);
		
		st.setString(1, email);
		st.setString(2, password);
		st.setDate(3, Date.valueOf(localdate));
		
		st.executeQuery();
		
		return checkUser;
	}

	@Override
	public boolean loginUser(User user) throws ClassNotFoundException, SQLException, IOException {
		
		ConnectionManager con = new ConnectionManager();
		
		boolean validateUser = false;
		
		String email = user.getEmail();
		String password = user.getPassword();
		
		Statement stm = con.getconnection().createStatement();
		
		ResultSet rs = stm.executeQuery("select * from blog");
		
		while(rs.next())
		{
			if(email.equals(rs.getString("email"))&&password.equals(rs.getString("password")))
			{
				con.getconnection().close();
				return true;
			}
		}
		con.getconnection().close();
		
		return false;
	}

}
