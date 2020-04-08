package dao;

import model.User;

public interface UserDaoInterface {
	
	int signUP(User user);
	boolean loginUser(User user);
	

}
