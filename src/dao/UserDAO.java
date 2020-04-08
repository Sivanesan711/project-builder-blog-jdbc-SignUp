package dao;

import java.time.LocalDate;

import model.User;

public class UserDAO implements UserDaoInterface {

	@Override
	public int signUP(User user) {
		
		int checkUser = 0;
		
		String email = user.getEmail();
		String password = user.getPassword();
		LocalDate localdate = user.getDate();
		
		return checkUser;
	}

	@Override
	public boolean loginUser(User user) {
		
		boolean validateUser = false;
		
		String email = user.getEmail();
		String password = user.getPassword();
		LocalDate localdate = user.getDate();
		
		return validateUser;
	}
	
    

}
